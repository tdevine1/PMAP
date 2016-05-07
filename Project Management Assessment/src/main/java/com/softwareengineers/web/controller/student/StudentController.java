package com.softwareengineers.web.controller.student;

import com.softwareengineers.web.model.AssessmentAnswers;
import com.softwareengineers.web.model.GroupInfoForAssessment;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.bind.annotation.ResponseBody;
import com.softwareengineers.web.database.DBHandler;
import com.softwareengineers.web.database.DatabaseConstants;

@Controller
public class StudentController {
    DBHandler db = null;
    
    @RequestMapping(value="/student/show", method=RequestMethod.GET)
    public ModelAndView show(HttpServletRequest request) {
        try {
            db = new DBHandler();
            Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
            Map<String,String> model = new HashMap<String,String>();
            model.put("username", (String)flashMap.get("username"));
            ResultSet rs;
            Vector<Integer> gids = new Vector<Integer>();
            String groups;
            String groupMembers;
            //SAME AS INSTRUCTOR CONTROLLER. THESE NEED PUT IN A DIFFERENT CLASS
            SimpleDriverDataSource dataSource;
            dataSource = new SimpleDriverDataSource(new com.mysql.jdbc.Driver() , "jdbc:mysql://127.0.0.1:3306/mydb", "root", "Prog1");
            java.sql.Connection con = dataSource.getConnection();
            java.sql.PreparedStatement pStmt = con.prepareStatement("SELECT fname, lname FROM users WHERE UCA = ?");
            pStmt.clearParameters();
            pStmt.setString(1, model.get("username"));
            rs = pStmt.executeQuery();
            while(rs.next()){
                model.put("Name", rs.getString("fname") + " " + rs.getString("lname"));
            }
            rs.close();
            
            pStmt = con.prepareStatement("SELECT GID, groupName FROM `group` WHERE groupMembers like ?");
            pStmt.clearParameters();
            pStmt.setString(1, "%" + model.get("Name") + "%");
            rs = pStmt.executeQuery();
            rs.next();
            groups = rs.getString("groupName");
            gids.add(rs.getInt("GID"));
            while(rs.next()){
                groups += "," + rs.getString("groupName");
                gids.add(rs.getInt("GID"));
            }
            rs.close();
            
            pStmt = con.prepareStatement("SELECT groupMembers FROM `group` WHERE GID = ?");
            pStmt.clearParameters();
            pStmt.setString(1, gids.get(0).toString());
            rs = pStmt.executeQuery();
            rs.next();
            groupMembers = rs.getString("groupMembers");
            rs.close();
            for(int i = 1; i < gids.size(); i++){
                pStmt.clearParameters();
                pStmt.setString(1, gids.get(i).toString());
                rs = pStmt.executeQuery();
                while(rs.next()){
                    groupMembers += "%" + rs.getString("groupMembers");
                }
                rs.close();
            }
            
            model.put("Groups", groups);
            model.put("GroupMembers", groupMembers);
            
            return new ModelAndView("studentSite", "model", model);
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            return new ModelAndView("error");
        }
    }
    
    @RequestMapping(value="/student/saveSelf")
    public @ResponseBody AssessmentAnswers saveAssessment(HttpServletRequest request){
        try {
            String[] answerArray = new String[Integer.parseInt(request.getParameter("answers"))];
            int numSaved=0;
            for(int i = 0; i<answerArray.length; i++){
                answerArray[i] = request.getParameter("A"+(i+1));
            }
            numSaved = db.insertOrUpdateAssessment(Integer.parseInt(request.getParameter("AID")), request.getParameter("UCA"), request.getParameter("GID"), request.getParameter("Name"), answerArray); 
            if(numSaved != 0){
                String[] array = {"","","","","","","","","","","","","","","","","","","",""};
                for(int i = 0; i<answerArray.length; i++){
                    array[i] = answerArray[i];
                }
                return new AssessmentAnswers(array);
            }
            else{
                AssessmentAnswers response = new AssessmentAnswers();
                response.setmsg("SAVE FAILED");
                return response;
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            AssessmentAnswers response = new AssessmentAnswers();
            response.setmsg("AN ERROR OCCURED WHILE SAVING");
            return response;
        }
    }
    
    @RequestMapping(value="/student/getAssessment")
    public @ResponseBody AssessmentAnswers getAssessment(HttpServletRequest request){
        try{
            if(db == null){
                db = new DBHandler();
            }
            ResultSet rs;
            rs = db.getAssessment(Integer.parseInt(request.getParameter("AID")), request.getParameter("UCA"), request.getParameter("GID"), request.getParameter("Name"));
            
            if(rs.next()){
                AssessmentAnswers answer;
                String[] array = populateArray(rs);
                answer = new AssessmentAnswers(array);
                answer.setmsg("Display");
                return answer;
            }
            else{
                AssessmentAnswers answer = new AssessmentAnswers();
                return answer;
            }
        } catch(SQLException ex){
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            AssessmentAnswers response = new AssessmentAnswers();
            response.setmsg("AN ERROR OCCURED WHILE SAVING");
            return response;
        }
    }
    
    public String[] populateArray(ResultSet rs) throws SQLException{
        String output;
        String [] array = new String[20];
        for(int i = 0; i < 20; i++){
            output = rs.getString(i+1);
            if(output == null){
                array[i] = "";
            }
            else{
                array[i] = output;
            }
        }
        
        return array;
    }
    
    @RequestMapping(value="/student/getGroupInfo")
    public @ResponseBody GroupInfoForAssessment getGroupInfo(HttpServletRequest request){
        String type = request.getParameter("Type");
        String name = request.getParameter("Name");
        String gName = request.getParameter("Group");
        String gId;
        
        String[] params = {gName, "%"+name+"%"};
        try {
            ResultSet rs = db.processQuery(DatabaseConstants.GETGID, params);
            if(rs.next()){
                gId = rs.getString("GID");
                return new GroupInfoForAssessment(gId, gName, type);
            }
            else{
                return new GroupInfoForAssessment("", gName, type);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            return new GroupInfoForAssessment("", gName, type);
        }
    }
}
