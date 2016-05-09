/**
 * Plain Old Java Object used to store the list of assessment aids and the names of the assessment a user has taken.
 * This is used as a model to send this info to the web page.
 */

package com.softwareengineers.web.model;

/**
 *
 * @author Samuel
 */
public class AssessmentsTakenByUser {
    public String[] aids;
    public String[] assessmentNames;

    public AssessmentsTakenByUser(String[] aids, String[] assessmentNames) {
        this.aids = aids;
        this.assessmentNames = assessmentNames;
    }
    
    public AssessmentsTakenByUser() {
        this.aids = new String[1];
        this.aids[0] = "error";
        this.assessmentNames = new String[1];
        this.assessmentNames[0] = "error";
    }

    public String[] getAids() {
        return aids;
    }

    public void setAids(String[] aids) {
        this.aids = aids;
    }

    public String[] getAssessmentNames() {
        return assessmentNames;
    }

    public void setAssessmentNames(String[] assessmentNames) {
        this.assessmentNames = assessmentNames;
    }
    
}
