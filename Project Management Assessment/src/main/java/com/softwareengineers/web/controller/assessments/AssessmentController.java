package com.softwareengineers.web.controller.assessments;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class AssessmentController {
    
    @RequestMapping("/peer")
    public ModelAndView peer(){
        return new ModelAndView("peerevaluation");
    }
    
    @RequestMapping("/self")
    public ModelAndView self(){
        return new ModelAndView("selfevaluation");
    }
}
