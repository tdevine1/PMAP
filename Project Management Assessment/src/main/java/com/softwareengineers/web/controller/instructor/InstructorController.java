package com.softwareengineers.web.controller.instructor;

import java.util.HashMap;
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
            return new ModelAndView("instructorSite", "model", model);
        }
        else
            return new ModelAndView("error");
    }
}
