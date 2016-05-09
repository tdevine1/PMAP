/**
 * This object is used to handle most of the transactions between the server and the database.
 */

package com.softwareengineers.web.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 *
 * @author Samuel
 */
public class DBHandler {
    private final SimpleDriverDataSource dataSource;
    private final java.sql.Connection con;

    /**
     * Constructor for the DBHandler
     * 
     * @throws SQLException 
     */
    public DBHandler() throws SQLException {
        this.dataSource = new SimpleDriverDataSource(new com.mysql.jdbc.Driver() , DatabaseConstants.URL, DatabaseConstants.USER, DatabaseConstants.PASSWORD);
        this.con =  dataSource.getConnection();
    }
    
    /**
     * Function that is used to build a preparedStatement from the queryString 
     * and then assign its parameters with the string array that is passed to it.
     * Executes the query and the ResultSet is returned
     * 
     * @param queryString, 
     * @param params
     * @return ResultSet
     * @throws SQLException 
     */
    public ResultSet processQuery(String queryString, String[] params) throws SQLException{
        java.sql.PreparedStatement pStmt = con.prepareStatement(queryString);
        pStmt.clearParameters();
        for(int i = 0; i < params.length; i++){
            pStmt.setString(i+1, params[i]);
        }
        return pStmt.executeQuery();
    }
    
    /**
     * Function that build a statement from the queryString and then executes the query.
     * the ResultSet is then returned
     * 
     * @param queryString
     * @return
     * @throws SQLException 
     */
    public ResultSet processQuery(String queryString) throws SQLException{
        java.sql.Statement stmt = con.createStatement();
        return stmt.executeQuery(queryString);
    }
    
    /**
     * The function takes the info passed to it to to build a preparesStatement for saving the answers to the database.
     * Once the preparedStatement is built, the update is then executed and the int value that is
     * returned from the update is the return value for the function.
     * 
     * @param AID
     * @param UCA
     * @param GID
     * @param Name
     * @param answers
     * @return
     * @throws SQLException 
     */
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
    
    /**
     * The function creates and preparedStatement for getting assessment answers. The arguments passed
     * to the function are set to the prepared state and the ResultSet that results from executing the
     * query is the return value.
     * 
     * @param AID
     * @param UCA
     * @param GID
     * @param Name
     * @return
     * @throws SQLException 
     */
    public ResultSet getAssessment(int AID, String UCA, String GID, String Name) throws SQLException{
        java.sql.PreparedStatement pStmt = con.prepareStatement(DatabaseConstants.GETASSESSMENT);
        
        pStmt.clearParameters();
        pStmt.setInt(1, AID);
        pStmt.setString(2, UCA);
        pStmt.setString(3, GID);
        pStmt.setString(4, Name);
        
        return pStmt.executeQuery();
    }
    
    /**
     * The function uses the arguments passed to it to build a preparedStatement
     * for adding a group to the database.  If successful true is returned, other the return
     * value is false.
     * 
     * @param gid
     * @param name
     * @param cid
     * @return
     * @throws SQLException 
     */
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
    
    /**
     * This function uses to data passed to it to build preparedStatements for adding users to
     * the database.  If any of the inserts fail, the function will return false. Otherwise, the return value
     * is true.
     * 
     * @param ucas
     * @param fnames
     * @param lnames
     * @return
     * @throws SQLException 
     */
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
    
    /**
     * Function is used to add the member ucas passed to it to either the dev or projectmanager table,
     * which is specified by the role, and to associate them with the group gid that is provided. The members are then
     * appended to the groupMember column for the group they have been added to.  If this is successful, true is returned. Otherwise,
     * the function returns false.
     * 
     * @param gid
     * @param role
     * @param ucas
     * @return
     * @throws SQLException 
     */
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
    
    /**
     * This function takes the arrays passed to it and creates a preparedStatement for inserting the presentation grades into the 
     * database and associating them with the gid provided.  If successful, the function returns true. Otherwise, false is returned.
     * 
     * @param gid
     * @param evaluators
     * @param ptsEarned
     * @param ptsPos
     * @param weights
     * @return
     * @throws SQLException 
     */
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
    
    /**
     * The function is used to generate and 8 character long random String value
     * to be used as a password for new users added to the database
     * 
     * @return 
     */
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
