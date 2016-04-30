package com.softwareengineers.web.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public int insertOrUpdateAssessment(int AID, String UCA, String GID, String Name, String[] answers) throws SQLException{
        java.sql.PreparedStatement pStmt = con.prepareStatement(
                "INSERT into answers (AID, UCA, GID, assessmentName, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE a1=?, a2=?, a3=?, a4=?, a5=?, a6=?, a7=?, a8=?, a9=?, a10=?, a11=?, a12=?, a13=?, a14=?, a15=?, a16=?, a17=?, a18=?, a19=?, a20=?"
        );
        
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

    
}
