package com.softwareengineers.web.model;

/**
 *
 * @author Samuel
 */
public class GroupInfo {
    public String[] ucas;
    public String[] passwords;

    public GroupInfo(String[] ucas, String[] passwords) {
        this.ucas = ucas;
        this.passwords = passwords;
    }
    
    public GroupInfo(){
        this.ucas = new String[1];
        this.ucas[0] = "error";
        this.passwords = new String[1];
        this.passwords[0] = "error";
    }

    public String[] getUcas() {
        return ucas;
    }

    public void setUcas(String[] ucas) {
        this.ucas = ucas;
    }

    public String[] getPasswords() {
        return passwords;
    }

    public void setPasswords(String[] passwords) {
        this.passwords = passwords;
    }
    
    
}
