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
    
    /**
     * This function is used to call the studentSite web page.
     * Information for the user who has logged in is retrieved from the database and then
     * passed to website as a HashMap.
     * 
     * 
     * @param request
     * @return 
     */
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
            String[] params = {model.get("username")};
            rs = db.processQuery(DatabaseConstants.GETNAME, params);
            while(rs.next()){
                model.put("Name", rs.getString("fname") + " " + rs.getString("lname"));
            }
            rs.close();
            
            params[0] = "%" + model.get("Name") + "%";
            rs = db.processQuery(DatabaseConstants.GETGIDS, params);
            rs.next();
            groups = rs.getString("groupName");
            gids.add(rs.getInt("GID"));
            while(rs.next()){
                groups += "," + rs.getString("groupName");
                gids.add(rs.getInt("GID"));
            }
            rs.close();
            
            params[0] = gids.get(0).toString();
            rs = db.processQuery(DatabaseConstants.GETGROUPMEMBERS, params);
            rs.next();
            groupMembers = rs.getString("groupMembers");
            rs.close();
            for(int i = 1; i < gids.size(); i++){
                params[0] = gids.get(i).toString();
                rs = db.processQuery(DatabaseConstants.GETGROUPMEMBERS, params);
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
    
    /**
     * Function that saves the assessment.
     * This functions saves the assessment using the data provided within the request.
     * If successful, the function returns an AssessmentAnswers object to the web page, 
     * with the answers that were saved stored within it. If unsuccessful, the function
     * still returns an AssessmentAnswers object, but the default constructor is used and
     * and its msg attribute is set with a message for the web page.
     * 
     * @param request
     * @return 
     */
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
    
    /**
     * Function that gets the answers for an assessment.
     * This function retrieves an assessment from the database using the primary key info provided
     * in the request.  If successful, an AssessAnswers object is returned with the answers stored within.
     * If no answers are in the database, then the object is returned using the default constructor.
     * If an error occurs during the process, the object is returned using the default constructor, and
     * a message set for the web page.
     * 
     * @param request
     * @return 
     */
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
                rs.close();
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
    
    /**
     * Function used to populate the answer array.
     * This function uses the ResultSet passed to it to populate the answer array that
     * will be used to build the AssessmentAnswers object.
     * 
     * @param rs
     * @return
     * @throws SQLException 
     */
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
    
    /**
     * Function is used to retrieve the gid for a group.
     * Using the info within the request, the gid for the group is question is retrieved.
     * All the info for the group is then stored within the GroupInfoForAssessment object and returned
     * to the web page.
     * 
     * @param request
     * @return 
     */
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
