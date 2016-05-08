package com.softwareengineers.web.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 *
 * @author Samuel
 */
public class DBHandler {
    private final SimpleDriverDataSource dataSource;
    private final java.sql.Connection con;

    public DBHandler() throws SQLException {
        this.dataSource = new SimpleDriverDataSource(new com.mysql.jdbc.Driver() , DatabaseConstants.URL, DatabaseConstants.USER, DatabaseConstants.PASSWORD);
        this.con =  dataSource.getConnection();
    }
    
    public ResultSet processQuery(String queryString, String[] params) throws SQLException{
        java.sql.PreparedStatement pStmt = con.prepareStatement(queryString);
        pStmt.clearParameters();
        for(int i = 0; i < params.length; i++){
            pStmt.setString(i+1, params[i]);
        }
        return pStmt.executeQuery();
    }
    
    public ResultSet processQuery(String queryString) throws SQLException{
        java.sql.Statement stmt = con.createStatement();
        return stmt.executeQuery(queryString);
    }
    
    public int insertOrUpdateAssessment(int AID, String UCA, String GID, String Name, String[] answers) throws SQLException{
        java.sql.PreparedStatement pStmt = con.prepareStatement(DatabaseConstants.INSERTORUPDATEASSESSMENT);
        
        pStmt.clearParameters();
        pStmt.setInt(1, AID);
        pStmt.setString(2, UCA);
        pStmt.setString(3, GID);
        pStmt.setString(4, Name);
        int iterator = 5;
        
        for(int i = 0; i < answers.length; i++){
            pStmt.setString(iterator, answers[i]);
            iterator++;
        }
        for(int i = 0; i<(20 - answers.length); i++){
            pStmt.setNull(iterator, java.sql.Types.VARCHAR);
            iterator++;
        }
        for(int i = 0; i < answers.length; i++){
            pStmt.setString(iterator, answers[i]);
            iterator++;
        }
        for(int i = 0; i<(20 - answers.length); i++){
            pStmt.setNull(iterator, java.sql.Types.VARCHAR);
            iterator++;
        }
        
        return pStmt.executeUpdate();
    }
    
    public ResultSet getAssessment(int AID, String UCA, String GID, String Name) throws SQLException{
        java.sql.PreparedStatement pStmt = con.prepareStatement(DatabaseConstants.GETASSESSMENT);
        
        pStmt.clearParameters();
        pStmt.setInt(1, AID);
        pStmt.setString(2, UCA);
        pStmt.setString(3, GID);
        pStmt.setString(4, Name);
        
        return pStmt.executeQuery();
    }
    
    public boolean insertGroup(String gid, String name, String cid) throws SQLException{
        java.sql.PreparedStatement pStmt = con.prepareStatement(DatabaseConstants.INSERTTOGROUP);
        pStmt.clearParameters();
        pStmt.setString(1, gid);
        pStmt.setString(2, name);
        if(pStmt.executeUpdate() != 0){
            pStmt.close();
            pStmt = con.prepareStatement(DatabaseConstants.INSERTTOGInC);
            pStmt.clearParameters();
            pStmt.setString(1, cid);
            pStmt.setString(2, gid);
            if(pStmt.executeUpdate() != 0){
                pStmt.close();
                
                return true;
            }
            else{
                throw new SQLException();
            }
        }
        else{
            throw new SQLException();
        }
    }
    
    public boolean insertUCA(String[] ucas, ArrayList<String> fnames, ArrayList<String> lnames) throws SQLException{
        java.sql.PreparedStatement pStmt = con.prepareStatement(DatabaseConstants.INSERTUCA);
        pStmt.clearParameters();
        for(int i = 0; i< ucas.length; i++){
            pStmt.setString(1, ucas[i]);
            pStmt.setString(2, PWGen());
            pStmt.setString(3, fnames.get(i));
            pStmt.setString(4, lnames.get(i));
            if(pStmt.executeUpdate() == 0){
                return false;
            }
            else{
                pStmt.clearParameters();
            }
        }
        
        return true;
    }
    
    public boolean addMembers(String gid, String role, String[] ucas) throws SQLException{
        java.sql.PreparedStatement pStmt;
        ResultSet rs;
        String memberString = "";
        if(role.equals("PM")){
            pStmt = con.prepareStatement(DatabaseConstants.INSERTPROJECTMANAGER);
        }
        else if(role.equals("DEV")){
            pStmt = con.prepareStatement(DatabaseConstants.INSERTDEV);
        }
        else{
            throw new SQLException();
        }
        
        for(String uca: ucas){
            pStmt.clearParameters();
            pStmt.setString(1, gid);
            pStmt.setString(2, uca);
            pStmt.executeUpdate();
        }
        pStmt.close();
        ArrayList<String> fnames = new ArrayList<String>();
        ArrayList<String> lnames = new ArrayList<String>();
        pStmt = con.prepareStatement(DatabaseConstants.GETNAME);
        for(String uca: ucas){
            pStmt.clearParameters();
            pStmt.setString(1, uca);
            rs = pStmt.executeQuery();
            if(rs.next()){
                fnames.add(rs.getString("fname"));
                lnames.add(rs.getString("lname"));
            }
            rs.close();
        }
        if(fnames.size() != ucas.length && lnames.size() != ucas.length){
            return false;
        }
        pStmt.close();
        pStmt = con.prepareStatement(DatabaseConstants.GETGROUPMEMBERS);
        pStmt.clearParameters();
        pStmt.setString(1, gid);
        rs = pStmt.executeQuery();
        if(rs.next()){
            memberString = rs.getString("groupMembers");
        }
        rs.close();
        if(memberString == null){
            memberString = fnames.get(0) + " " + lnames.get(0);
            for(int i = 1; i< fnames.size(); i++){
                memberString = memberString +", " + fnames.get(i) + " " + lnames.get(i);
            }
        }
        else{
            for(int i = 0; i< fnames.size(); i++){
                memberString = memberString +", " + fnames.get(i) + " " + lnames.get(i);
            }
        }
        pStmt.close();
        pStmt = con.prepareStatement(DatabaseConstants.UPDATEMEMBERLIST);
        pStmt.clearParameters();
        pStmt.setString(1, memberString);
        pStmt.setString(2, gid);
        if(pStmt.executeUpdate() != 0){
            pStmt.close();
            return true;
        }
        else{
            pStmt.close();
            return false;
        }
    }
    
    public boolean savePresentationGrades(String gid, String[] evaluators, Double[] ptsEarned, Double[] ptsPos, Double[] weights) throws SQLException{
        java.sql.PreparedStatement pStmt = con.prepareStatement(DatabaseConstants.INSERTORUPDATEPRESENTATIONGRADE);
        for(int i = 0; i < evaluators.length; i++){
            pStmt.clearParameters();
            pStmt.setString(1, gid);
            pStmt.setString(2, evaluators[i]);
            pStmt.setDouble(3, ptsEarned[i]);
            pStmt.setDouble(4, ptsPos[i]);
            pStmt.setDouble(5, weights[i]);
            pStmt.setDouble(6, ptsEarned[i]);
            pStmt.setDouble(7, ptsPos[i]);
            pStmt.setDouble(8, weights[i]);
            
            if(pStmt.executeUpdate() == 0){
                return false;
            }
        }
        return true;
    }
    
    private String PWGen(){
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = 8;
        StringBuilder builder = new StringBuilder();
        while (length-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    
}
