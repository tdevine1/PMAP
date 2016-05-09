/**
 * Controller used to handle calls for the assessments.
 */

package com.softwareengineers.web.controller.assessments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AssessmentController {
    
    /**
     * This function returns the peerevaluation web page.
     * 
     * @return 
     */
    @RequestMapping("/peer")
    public ModelAndView peer(){
        return new ModelAndView("peerevaluation");
    }
    
    /**
     * This function returns the selfevaluation web page/
     * 
     * @return 
     */
    @RequestMapping("/self")
    public ModelAndView self(){
        return new ModelAndView("selfevaluation");
    }
}
