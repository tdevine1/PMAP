/**
 * Plain Old Java Object that stores presentation grade info for the grading table.
 * Used as a model to transfer this info to the webpage.
 */

package com.softwareengineers.web.model;

/**
 *
 * @author Samuel
 */
public class PresentationGradeInfo {
    Boolean recordsExist;
    String[] evaluators;
    Double[] pointsEarned;
    Double[] pointsTotal;
    Double[] weighting;

    public PresentationGradeInfo(String[] evaluators, Double[] pointsEarned, Double[] pointsTotal, Double[] weighting) {
        this.evaluators = evaluators;
        this.pointsEarned = pointsEarned;
        this.pointsTotal = pointsTotal;
        this.weighting = weighting;
        recordsExist = true;
    }

    public PresentationGradeInfo() {
        this.evaluators = null;
        this.pointsEarned = null;
        this.pointsTotal = null;
        this.weighting = null;
        recordsExist = false;
    }

    public Boolean getRecordsExist() {
        return recordsExist;
    }

    public void setRecordsExist(Boolean recordsExist) {
        this.recordsExist = recordsExist;
    }

    public String[] getEvaluators() {
        return evaluators;
    }

    public void setEvaluators(String[] evaluators) {
        this.evaluators = evaluators;
    }

    public Double[] getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(Double[] pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public Double[] getPointsTotal() {
        return pointsTotal;
    }

    public void setPointsTotal(Double[] pointsTotal) {
        this.pointsTotal = pointsTotal;
    }

    public Double[] getWeighting() {
        return weighting;
    }

    public void setWeighting(Double[] weighting) {
        this.weighting = weighting;
    }
    
    
}
