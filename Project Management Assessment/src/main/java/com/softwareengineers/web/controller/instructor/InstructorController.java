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

@Controller
public class InstructorController {
    
    @RequestMapping(value="/instructor/show", method=RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        if((Boolean)flashMap.get("isAdmin")){
            Map<String,String> model = new HashMap<String,String>();
            model.put("username", (String)flashMap.get("username"));
            
            //THESE WILL BE PULLED FROM THE DATABASE, HARD CODING THEM FOR NOW TO GET THE FRONT END WORKING
            //To get these in the jsp we will use tokens
            //For example, the class array will be split with just commas (no whitespace between them) for each class
            //The assessments with have each assessment separated by comma (no whitespace) and then a slash as a separater for when
            //we have reached the assessments for the next class
            String classArray = "Project Management,Software Engineering";
            model.put("classes", classArray);
            model.put("assessments", "peer,self");
            
            return new ModelAndView("instructorSite", "model", model);
        }
        else
            return new ModelAndView("error");
    }
    
    @RequestMapping(value="/instructorTabContainer")
    public ModelAndView tab(HttpServletRequest request) {
    return new ModelAndView("instructorTabContainer");
    }
}
