package com.softwareengineers.web.controller.login;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public ModelAndView login() {
        Map<String,String> model = new HashMap<String,String>();
        model.put("username","");
        model.put("password","");
        return new ModelAndView("loginPage", "model", model);
    }
    
    @RequestMapping(value="/processLogin", method=RequestMethod.POST)
    public String processLogin(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        //logger.debug(request.getAttribute("username"));
        Map<String,String> model = new HashMap<String,String>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        redirectAttributes.addFlashAttribute("username", username);
        
        if(username.equals("teach")){
            redirectAttributes.addFlashAttribute("isAdmin", true);
            return "redirect:/instructor/show";
        }
        else{
            return "redirect:/student/show";
        }
    }


}