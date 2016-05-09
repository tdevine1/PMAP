/**
 * A Plain Old Java Object that is used to pass data containing the answers for assessment to the web page.
 */

package com.softwareengineers.web.model;

/**
 *
 * @author Samuel
 */
public class AssessmentAnswers {
    
    private String A1;
    private String A2;
    private String A3;
    private String A4;
    private String A5;
    private String A6;
    private String A7;
    private String A8;
    private String A9;
    private String A10;
    private String A11;
    private String A12;
    private String A13;
    private String A14;
    private String A15;
    private String A16;
    private String A17;
    private String A18;
    private String A19;
    private String A20;
    private String msg;
    private String answers;

    /**
     * CONSTRUCTOR FOR ASSESSMENTANSWERS.  The String array argument must contain 20 elements or default constructor will be used
     * @param answers 
     */
    public AssessmentAnswers(String[] answers) {
        this();
        if(answers.length == 20){
            this.A1 = answers[0];
            this.A2 = answers[1];
            this.A3 = answers[2];
            this.A4 = answers[3];
            this.A5 = answers[4];
            this.A6 = answers[5];
            this.A7 = answers[6];
            this.A8 = answers[7];
            this.A9 = answers[8];
            this.A10 = answers[9];
            this.A11 = answers[10];
            this.A12 = answers[11];
            this.A13 = answers[12];
            this.A14 = answers[13];
            this.A15 = answers[14];
            this.A16 = answers[15];
            this.A17 = answers[16];
            this.A18 = answers[17];
            this.A19 = answers[18];
            this.A20 = answers[19];
            this.answers = "Y";
        }
    }


    public AssessmentAnswers() {
        this.A1 = "";
        this.A2 = "";
        this.A3 = "";
        this.A4 = "";
        this.A5 = "";
        this.A6 = "";
        this.A7 = "";
        this.A8 = "";
        this.A9 = "";
        this.A10 = "";
        this.A11 = "";
        this.A12 = "";
        this.A13 = "";
        this.A14 = "";
        this.A15 = "";
        this.A16 = "";
        this.A17 = "";
        this.A18 = "";
        this.A19 = "";
        this.A20 = "";
        this.msg = "";
        this.answers = "N";
    }

    
    
//<editor-fold defaultstate="collapsed" desc="GETTERS AND SETTERS">
    public String getA1() {
        return A1;
    }
    
    public void setA1(String A1) {
        this.A1 = A1;
    }
    
    public String getA2() {
        return A2;
    }
    
    public void setA2(String A2) {
        this.A2 = A2;
    }
    
    public String getA3() {
        return A3;
    }
    
    public void setA3(String A3) {
        this.A3 = A3;
    }
    
    public String getA4() {
        return A4;
    }
    
    public void setA4(String A4) {
        this.A4 = A4;
    }
    
    public String getA5() {
        return A5;
    }
    
    public void setA5(String A5) {
        this.A5 = A5;
    }
    
    public String getA6() {
        return A6;
    }
    
    public void setA6(String A6) {
        this.A6 = A6;
    }
    
    public String getA7() {
        return A7;
    }
    
    public void setA7(String A7) {
        this.A7 = A7;
    }
    
    public String getA8() {
        return A8;
    }
    
    public void setA8(String A8) {
        this.A8 = A8;
    }
    
    public String getA9() {
        return A9;
    }
    
    public void setA9(String A9) {
        this.A9 = A9;
    }
    
    public String getA10() {
        return A10;
    }
    
    public void setA10(String A10) {
        this.A10 = A10;
    }
    
    public String getA11() {
        return A11;
    }
    
    public void setA11(String A11) {
        this.A11 = A11;
    }
    
    public String getA12() {
        return A12;
    }
    
    public void setA12(String A12) {
        this.A12 = A12;
    }
    
    public String getA13() {
        return A13;
    }
    
    public void setA13(String A13) {
        this.A13 = A13;
    }
    
    public String getA14() {
        return A14;
    }
    
    public void setA14(String A14) {
        this.A14 = A14;
    }
    
    public String getA15() {
        return A15;
    }
    
    public void setA15(String A15) {
        this.A15 = A15;
    }
    
     public String getA16() {
        return A16;
    }

    public void setA16(String A16) {
        this.A16 = A16;
    }

    public String getA17() {
        return A17;
    }

    public void setA17(String A17) {
        this.A17 = A17;
    }

    public String getA18() {
        return A18;
    }

    public void setA18(String A18) {
        this.A18 = A18;
    }

    public String getA19() {
        return A19;
    }

    public void setA19(String A19) {
        this.A19 = A19;
    }

    public String getA20() {
        return A20;
    }

    public void setA20(String A20) {
        this.A20 = A20;
    }

    public String getmsg() {
        return msg;
    }

    public void setmsg(String MSG) {
        this.msg = MSG;
    }
    
    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }
//</editor-fold>
}
