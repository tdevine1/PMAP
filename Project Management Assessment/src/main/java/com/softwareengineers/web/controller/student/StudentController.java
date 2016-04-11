package com.softwareengineers.web.controller.student;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class StudentController {
    
    @RequestMapping(value="/student/show", method=RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        
        return new ModelAndView("studentSite");
    }
    
    @RequestMapping(value="/studentTabContainer")
    public ModelAndView tabContainer() {
        return new ModelAndView("studentTabContainer");
    }
}
