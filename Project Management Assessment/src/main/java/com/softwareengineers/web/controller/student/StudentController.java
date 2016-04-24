package com.softwareengineers.web.controller.student;

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

@Controller
public class StudentController {
    
    @RequestMapping(value="/student/show", method=RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
        try {
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
    
    @RequestMapping(value="/studentTabContainer")
    public ModelAndView tabContainer() {
        return new ModelAndView("studentTabContainer");
    }
}
