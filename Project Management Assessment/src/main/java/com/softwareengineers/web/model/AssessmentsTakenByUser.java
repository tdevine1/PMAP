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
