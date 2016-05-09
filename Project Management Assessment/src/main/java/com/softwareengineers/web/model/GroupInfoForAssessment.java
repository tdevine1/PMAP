/**
 * Plain Old Java Object used to store group info and assessment type.
 * Used as a model to transfer this data to the web page.
 */

package com.softwareengineers.web.model;

/**
 *
 * @author Samuel
 */
public class GroupInfoForAssessment {
    private String groupID;
    private String groupName;
    private String type;

    public GroupInfoForAssessment(String groupID, String groupName, String type) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.type = type;
    }
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS AND SETTERS">
    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    //</editor-fold>
}
