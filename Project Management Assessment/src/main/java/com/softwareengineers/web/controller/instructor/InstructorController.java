package com.softwareengineers.web.controller.instructor;

import java.util.ArrayList;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.bind.annotation.ResponseBody;
import com.softwareengineers.web.model.AssessmentsTakenByUser;
import com.softwareengineers.web.model.GroupsForClass;
import com.softwareengineers.web.model.MembersOfGroup;
import com.softwareengineers.web.model.UCASToAdd;
import com.softwareengineers.web.database.DBHandler;
import com.softwareengineers.web.database.DatabaseConstants;
import com.softwareengineers.web.model.GroupInfo;
import com.softwareengineers.web.model.PresentationGradeInfo;
import java.util.Arrays;

@Controller
public class InstructorController {
    DBHandler db;
    
    @RequestMapping(value="/instructor/show", method=RequestMethod.GET)
    public ModelAndView show(HttpServletRequest request) {
        try {
            db = new DBHandler();
            Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
            Map<String,String> model = new HashMap<String,String>();
            model.put("username", (String)flashMap.get("username"));
            ResultSet rs;
            String classArray;
            String assessments;
            //ALL DB TRANSACTIONS NEED PUT IN A NEW CLASS AND NEED TO WORK ON POJO MODELS TO HOLD REQUESTS IN ALL FUTURE QUERIES SINCE THEY WILL BE AJAX CALLS
            SimpleDriverDataSource dataSource;
            dataSource = new SimpleDriverDataSource(new com.mysql.jdbc.Driver() , "jdbc:mysql://127.0.0.1:3306/mydb", "root", "Prog1");
            java.sql.Connection con = dataSource.getConnection();
            java.sql.PreparedStatement pStmt = con.prepareStatement("SELECT fname, lname FROM users WHERE UCA = ?");
            pStmt.clearParameters();
            pStmt.setString(1, model.get("username"));
            rs = pStmt.executeQuery();
            while(rs.next()){
                model.put("FirstName", rs.getString("fname"));
                model.put("LastName", rs.getString("lname"));
            }
            rs.close();
            
            pStmt = con.prepareStatement("SELECT CID FROM taughtCourse WHERE UCA = ?");
            pStmt.clearParameters();
            pStmt.setString(1, model.get("username"));
            rs = pStmt.executeQuery();
            rs.next();
            classArray = rs.getString("CID");
            while(rs.next()){
                classArray += "," + rs.getString("CID");
            }
            rs.close();
            
            pStmt = con.prepareStatement("SELECT aName FROM assessments WHERE CID = ?");
            pStmt.clearParameters();
            pStmt.setString(1, classArray);
            rs = pStmt.executeQuery();
            rs.next();
            assessments = rs.getString("aName");
            while(rs.next()){
                assessments += "," + rs.getString("aName");
            }
            rs.close();
            
            model.put("classes", classArray);
            model.put("assessments", assessments);
            
            return new ModelAndView("instructorSite", "model", model);
        } catch (SQLException ex) {
            Logger.getLogger(InstructorController.class.getName()).log(Level.SEVERE, null, ex);
            return new ModelAndView("error");
        }
    }
    
    @RequestMapping(value="/instructor/groupInfo")
    public ModelAndView groupLogin(){
        return new ModelAndView("studentPW");
    }
    
    @RequestMapping(value="/instructor/weightedGradeTable")
    public ModelAndView displayTable(){
        return new ModelAndView("weightedGradeTable");
    }
    
    @RequestMapping(value="/instructor/getInfo")
    public @ResponseBody GroupInfo getInfo(HttpServletRequest request){
        String gid = request.getParameter("gid");
        String[] params = {gid};
        ArrayList<String> ucas = new ArrayList<String>();
        ArrayList<String> pws = new ArrayList<String>();
        try {
            ResultSet rs = db.processQuery(DatabaseConstants.GETDEVLOGIN, params);
            while(rs.next()){
                ucas.add(rs.getString("UCA"));
                pws.add(rs.getString("password"));
            }
            rs.close();
            
            rs = db.processQuery(DatabaseConstants.GETPROJECTMANAGERLOGIN, params);
            while(rs.next()){
                ucas.add(rs.getString("UCA"));
                pws.add(rs.getString("password"));
            }
            rs.close();
            
            if(ucas.isEmpty()){
                return new GroupInfo();
            }
            else{
                return new GroupInfo(ucas.toArray(new String[ucas.size()]), pws.toArray(new String[pws.size()]));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorController.class.getName()).log(Level.SEVERE, null, ex);
            return new GroupInfo();
        }
    }
    
    @RequestMapping(value="/instructor/groupsForClass")
    public @ResponseBody GroupsForClass groupsForClass(HttpServletRequest request) {
        String cid = request.getParameter("course");
        ArrayList<String> gids = new ArrayList<String>();
        ArrayList<String> groups = new ArrayList<String>();
        
        String[] params = {cid};
        try {
            ResultSet rs = db.processQuery(DatabaseConstants.GROUPSINCOURSE, params);
            while(rs.next()){
                gids.add(rs.getString("GID"));
                groups.add(rs.getString("groupName"));
            }
            rs.close();
            
            return new GroupsForClass(groups.toArray(new String[groups.size()]), gids.toArray(new String[gids.size()]));
        } catch (SQLException ex) {
            Logger.getLogger(InstructorController.class.getName()).log(Level.SEVERE, null, ex);
            return new GroupsForClass();
        }
        
    }
    
    @RequestMapping(value="/instructor/membersForGroup")
    public @ResponseBody MembersOfGroup membersForGroup(HttpServletRequest request) {
        String gid = request.getParameter("gid");
        ArrayList<String> ucas = new ArrayList<String>();
        ArrayList<String> names = new ArrayList<String>();
        
        String[] params = {gid};
        try {
            ResultSet rs = db.processQuery(DatabaseConstants.PROJECTMANAGERSOFGROUP, params);
            while(rs.next()){
                ucas.add(rs.getString("UCA"));
                names.add(rs.getString("fname") + " " + rs.getString("lname"));
            }
            rs.close();
            
            rs = db.processQuery(DatabaseConstants.DEVSOFGROUP, params);
            while(rs.next()){
                ucas.add(rs.getString("UCA"));
                names.add(rs.getString("fname") + " " + rs.getString("lname"));
            }
            rs.close();
            
            return new MembersOfGroup(ucas.toArray(new String[ucas.size()]), names.toArray(new String[names.size()]));
        } catch (SQLException ex) {
            Logger.getLogger(InstructorController.class.getName()).log(Level.SEVERE, null, ex);
            return new MembersOfGroup();
        }
        
    }
            
    @RequestMapping(value="/instructor/assessmentsTaken")
    public @ResponseBody AssessmentsTakenByUser assessmentsTaken(HttpServletRequest request) {
        String gid = request.getParameter("gid");
        String uca = request.getParameter("uca");
        String name = request.getParameter("name");
        ArrayList<String> aids = new ArrayList<String>();
        ArrayList<String> names = new ArrayList<String>();
        
        String[] params = {gid, uca};
        try {
            ResultSet rs = db.processQuery(DatabaseConstants.GETANSWEREDASSESSMENTS, params);
            
            while(rs.next()){
                aids.add(rs.getString("AID"));
                names.add(rs.getString("assessmentName").replace(name+" ", ""));
            }
            rs.close();
            
            return new AssessmentsTakenByUser(aids.toArray(new String[aids.size()]), names.toArray(new String[names.size()]));
        } catch (SQLException ex) {
            Logger.getLogger(InstructorController.class.getName()).log(Level.SEVERE, null, ex);
            return new AssessmentsTakenByUser();
        }
        
    }
    
    @RequestMapping(value="/instructor/newGroup")
    public @ResponseBody GroupsForClass newGroup(HttpServletRequest request) {
        String cid = request.getParameter("cid");
        String gName = request.getParameter("group");
        String gid;
        ArrayList<String> gids = new ArrayList<String>();
        ArrayList<String> groups = new ArrayList<String>();
        
        try {
            ResultSet rs = db.processQuery(DatabaseConstants.GETMAXGID);
            if(rs.next()){
                gid = Integer.toString(rs.getInt("MAX") + 1);
            }
            else{
                gid = "1";
            }
            rs.close();
            
            if(db.insertGroup(gid, gName, cid)){
                String[] params = {cid};
                rs = db.processQuery(DatabaseConstants.GROUPSINCOURSE, params);
                while(rs.next()){
                    gids.add(rs.getString("GID"));
                    groups.add(rs.getString("groupName"));
                }
                rs.close();
                return new GroupsForClass(groups.toArray(new String[groups.size()]), gids.toArray(new String[gids.size()]));
            }
            else{
                return new GroupsForClass();
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorController.class.getName()).log(Level.SEVERE, null, ex);
            return new GroupsForClass();
        }
        
    }
    
    @RequestMapping(value="/instructor/addMembers")
    public @ResponseBody MembersOfGroup addMembersToGroup(HttpServletRequest request) {
        String gid = request.getParameter("gid");
        String role = request.getParameter("role");
        String[] ucaArray = request.getParameter("ucas").split(",");
        
        //TRIMMING WHITESPACE FROM ENTRIES
        for(int i = 0; i< ucaArray.length; i++){
            ucaArray[i] = ucaArray[i].trim();
        }
        try {
            if(db.addMembers(gid, role, ucaArray)){
                ArrayList<String> ucas = new ArrayList<String>();
                ArrayList<String> names = new ArrayList<String>();
                String[] params = {gid};
                ResultSet rs = db.processQuery(DatabaseConstants.PROJECTMANAGERSOFGROUP, params);
                while(rs.next()){
                    ucas.add(rs.getString("UCA"));
                    names.add(rs.getString("fname") + " " + rs.getString("lname"));
                }
                rs.close();
            
                rs = db.processQuery(DatabaseConstants.DEVSOFGROUP, params);
                while(rs.next()){
                    ucas.add(rs.getString("UCA"));
                    names.add(rs.getString("fname") + " " + rs.getString("lname"));
                }
                rs.close();
            
                return new MembersOfGroup(ucas.toArray(new String[ucas.size()]), names.toArray(new String[names.size()]));
            }
            else{
                return new MembersOfGroup();
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorController.class.getName()).log(Level.SEVERE, null, ex);
            return new MembersOfGroup();
        }
        
    }
    
    @RequestMapping(value="/instructor/ucaExistCheck")
    public @ResponseBody UCASToAdd ucaExistCheck(HttpServletRequest request) {
        String ucaString = request.getParameter("ucas");
        ArrayList<String> ucasToAdd = new ArrayList<String>(Arrays.asList(ucaString.split(",")));
        ArrayList<String> ucas = new ArrayList<String>();
        try {
            ResultSet rs = db.processQuery(DatabaseConstants.GETUCALIST);
            while(rs.next()){
                ucas.add(rs.getString("UCA"));
            }
            rs.close();
            Logger.getLogger(InstructorController.class.getName()).log(Level.INFO, "UCAS---" + ucas.toString());
            for(String s: ucasToAdd){
                //Logger.getLogger(InstructorController.class.getName()).log(Level.INFO, "ITEMTOCheck---" + s);
                if(ucas.contains(s.trim())){
                    ucasToAdd.remove(s);
                }
            }
            ucasToAdd.trimToSize();
            Logger.getLogger(InstructorController.class.getName()).log(Level.INFO, "UCASTOADD---" + ucasToAdd.toString());
            if(!ucasToAdd.isEmpty()){
                return new UCASToAdd(ucasToAdd.toArray(new String[ucasToAdd.size()]));
            }
            else{
                return new UCASToAdd(null);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InstructorController.class.getName()).log(Level.SEVERE, null, ex);
            UCASToAdd err = new UCASToAdd(null);
            err.error = "y";
            return err;
        }
    }
    
    @RequestMapping(value="/instructor/newUCAs")
    public @ResponseBody boolean newUCAs(HttpServletRequest request) {
        String ucaStr = request.getParameter("ucas");
        String nameStr = request.getParameter("names");
        
        String[] ucas = ucaStr.split(",");
        String[] names = nameStr.split(",");
        ArrayList<String> fnameList = new ArrayList<String>();
        ArrayList<String> lnameList = new ArrayList<String>();
        for(String s: names){
            String[] temp = s.split(" ");
            fnameList.add(temp[0]);
            lnameList.add(temp[1]);
        }
        try {
            return db.insertUCA(ucas, fnameList, lnameList);
        } catch (SQLException ex) {
            Logger.getLogger(InstructorController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    /**
     * Method that is used to get the info for the Weighted Presentation Grading Table.
     * If no grading data exists for the group then the object returned will have a flag set to false 
     * representing that no data currently exists in the presentationgrades table for this group.
     * @param request
     * @return PresentationGradeInfo object that will be converted to JSON by the Spring Framework 
     */
    @RequestMapping(value="/instructor/presentationGrades")
    public @ResponseBody PresentationGradeInfo presentationGrades(HttpServletRequest request) {
        String gid = request.getParameter("gid");
        String[] params = {gid};
        ArrayList<String> evaluators = new ArrayList<String>();
        ArrayList<Double> pointsEarned = new ArrayList<Double>();
        ArrayList<Double> pointsTotal = new ArrayList<Double>();
        ArrayList<Double> weights = new ArrayList<Double>();
        try {
            ResultSet rs = db.processQuery(DatabaseConstants.PRESENTATIONGRADEFORGROUP, params);
            while(rs.next()){
                evaluators.add(rs.getString("Evaluator"));
                pointsEarned.add(rs.getDouble("Points_earned"));
                pointsTotal.add(rs.getDouble("Points_possible"));
                weights.add(rs.getDouble("weighting"));
            }
            if(evaluators.size() == 0){
                return new PresentationGradeInfo();
            }
            else{
                return new PresentationGradeInfo(evaluators.toArray(new String[evaluators.size()]), pointsEarned.toArray(new Double[pointsEarned.size()]), pointsTotal.toArray(new Double[pointsTotal.size()]), weights.toArray(new Double[weights.size()]));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorController.class.getName()).log(Level.SEVERE, null, ex);
            return new PresentationGradeInfo();
        }  
    }
    
    @RequestMapping(value="/instructor/savePresentationGrades")
    public @ResponseBody boolean savePresentationGrades(HttpServletRequest request) {
        String gid = request.getParameter("gid");
        String[] evaluators = request.getParameter("evaluators").split(",");
        String[] ptsEarnedStr = request.getParameter("ptsErnd").split(",");
        String[] ptsPosStr = request.getParameter("ptsPos").split(",");
        String[] weightsStr = request.getParameter("weights").split(",");
        Double[] ptsEarned = convertToDoubleArray(ptsEarnedStr);
        Double[] ptsPos = convertToDoubleArray(ptsPosStr);
        Double[] weights = convertToDoubleArray(weightsStr);
        
        try {
            return db.savePresentationGrades(gid, evaluators, ptsEarned, ptsPos, weights);
        } catch (SQLException ex) {
            Logger.getLogger(InstructorController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public Double[] convertToDoubleArray(String[] arr){
        Double[] answer = new Double[arr.length];
        for(int i = 0; i< arr.length; i++){
            answer[i] = Double.parseDouble(arr[i]);
        }
        return answer;
    }
}
