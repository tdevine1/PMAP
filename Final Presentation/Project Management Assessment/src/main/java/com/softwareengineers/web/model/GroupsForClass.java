/**
 * Plain Old Java Object used to store the gids and group names associated with a class.
 * Used as a model for transferring this data to the web page. 
 */

package com.softwareengineers.web.model;

/**
 *
 * @author Samuel
 */
public class GroupsForClass {
    public final String selectId = "groups";
    public String[] groups;
    public String[] gids;

    public GroupsForClass(String[] groups, String[] gids) {
        this.groups = groups;
        this.gids = gids;
    }

    public GroupsForClass() {
        this.groups = new String[1];
        this.groups[0] = "error";
        this.gids = new String[1];
        this.gids[0] = "error";
    }
    

    public String getSelectId() {
        return selectId;
    }

    public String[] getGids() {
        return gids;
    }

    public void setGids(String[] gids) {
        this.gids = gids;
    }

    public String[] getGroups() {
        return groups;
    }

    public void setGroups(String[] groups) {
        this.groups = groups;
    }
    
    
}
