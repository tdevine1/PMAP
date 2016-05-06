package com.softwareengineers.web.controller.instructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.bind.annotation.ResponseBody;
import com.softwareengineers.web.model.GroupsForClass;
import com.softwareengineers.web.model.MembersOfGroup;
import com.softwareengineers.web.database.DBHandler;
import com.softwareengineers.web.database.DatabaseConstants;

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
}
