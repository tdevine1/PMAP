/**
 * Controller that handles calls made by the login page.
 */

package com.softwareengineers.web.controller.login;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    
    /**
     * This function displays the login page for the web app.
     * 
     * @return 
     */
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public ModelAndView login() {
        Map<String,String> model = new HashMap<String,String>();
        model.put("username","");
        model.put("password","");
        return new ModelAndView("loginPage", "model", model);
    }
    
    /**
     * This function handles the login process.
     * Using the data provided within the request, this function checks if the user login
     * information is valid.  If it is, the function then checks if the user is an instructor or not
     * and send redirects them to their respective page accordingly. If the user login info is invalid,
     * the error page is called.
     * 
     * @param request
     * @param redirectAttributes
     * @return 
     */
    @RequestMapping(value="/processLogin", method=RequestMethod.POST)
    public String processLogin(HttpServletRequest request, RedirectAttributes redirectAttributes){
        java.sql.Connection con;
        try {
            //logger.debug(request.getAttribute("username"));
            //Map<String,String> model = new HashMap<String,String>();
            SimpleDriverDataSource dataSource;
            dataSource = new SimpleDriverDataSource(new com.mysql.jdbc.Driver() , "jdbc:mysql://127.0.0.1:3306/mydb", "root", "Prog1");
            con = dataSource.getConnection();
            java.sql.PreparedStatement pStmt = con.prepareStatement("SELECT IF( uca is not null  , 1, 0) as IsUser FROM users WHERE uca = ? and password = ?");
            pStmt.clearParameters();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            pStmt.setString(1, username);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();
            
            boolean check = false;
            while(rs.next()){
            check = rs.getBoolean("IsUser");
            }
            redirectAttributes.addFlashAttribute("username", username);
            
            if(check){
                pStmt = con.prepareStatement("SELECT IF(uca is not null, 1, 0) as IsInstructor FROM instructor WHERE uca = ?");
                pStmt.clearParameters();
                pStmt.setString(1, username);
                boolean isInstructor = false;
                rs = pStmt.executeQuery();
                //con.close();
                while(rs.next()){
                    isInstructor = rs.getBoolean("IsInstructor");
                }
                con.close();
                if(isInstructor){
                    return "redirect:/instructor/show";
                }
                else{
                    return "redirect:/student/show";
                }
            }
            else{
                con.close();
                return "error";
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            return "error";
        }
    }


}