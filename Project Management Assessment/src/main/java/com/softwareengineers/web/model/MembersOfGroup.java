/**
 * Plain Old Java Object that stored the ucas and names of members of a group and used to populate a select object.
 * Used as a model to transfer this data to the web page.
 */

package com.softwareengineers.web.model;
/**
 *
 * @author Samuel
 */
public class MembersOfGroup {
    public final String selectId = "members";
    public String[] ucas;
    public String[] names;

    public MembersOfGroup(String[] ucas, String[] names) {
        this.ucas = ucas;
        this.names = names;
    }
    
    public MembersOfGroup() {
        this.ucas = new String[1];
        this.ucas[0] = "error";
        this.names = new String[1];
        this.names[0] = "error";
    }

    public String[] getUcas() {
        return ucas;
    }

    public void setUcas(String[] ucas) {
        this.ucas = ucas;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public String getSelectId() {
        return selectId;
    }
}
