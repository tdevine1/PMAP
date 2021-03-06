/**
 * This Object is used to store queries, transactions, and connection info for the database
 */

package com.softwareengineers.web.database;

public class DatabaseConstants{
	//Login Queries
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/mydb";
        public static final String USER = "root";
        public static final String PASSWORD = "Prog1";
	public static final String LOGINQUERY = "SELECT IF( uca is not null  , 1, 0) as IsUser FROM users WHERE uca = ? and password = ?";
	public static final String INSTRUCTORQUERY = " SELECT IF(uca is not null, 1, 0) as IsInstructor FROM instructor WHERE uca = ?";
	//Instructor controller queries
	public static final String GETNAME = "SELECT fname, lname FROM users WHERE UCA = ?";
	public static final String TAUGHTCOURSE = "SELECT CID FROM taughtCourse WHERE UCA = ?";
	public static final String GETANAME = "SELECT aName FROM assessments WHERE CID = ?";
	//Student Controller queries
	public static final String GETGIDS = "SELECT GID, groupName FROM `group` WHERE groupMembers like ?";
	public static final String GETGROUPMEMBERS = "SELECT groupMembers FROM `group` WHERE GID = ?";
        public static final String INSERTORUPDATEASSESSMENT =   "INSERT into answers (AID, UCA, GID, assessmentName, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20) " +
                                                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                                                                "ON DUPLICATE KEY UPDATE a1=?, a2=?, a3=?, a4=?, a5=?, a6=?, a7=?, a8=?, a9=?, a10=?, a11=?, a12=?, a13=?, a14=?, a15=?, a16=?, a17=?, a18=?, a19=?, a20=?";
        public static final String GETASSESSMENT = "SELECT a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20 " +
                                                   "FROM answers A " +
                                                   "WHERE A.AID = ? AND A.UCA = ? AND A.GID = ? AND A.assessmentName = ?";
        public static final String GETGID = "SELECT GID FROM `group` WHERE groupName = ? AND groupMembers like ?";
        public static final String GROUPSINCOURSE = "SELECT g.GID, g.groupName FROM groupsincourse gic, `group` g WHERE gic.CID = ? AND gic.GIDs = g.GID";
        public static final String PROJECTMANAGERSOFGROUP = "SELECT u.UCA, u.fname, u.lname FROM projectmanager pjm, users u WHERE pjm.GID = ? AND pjm.UCA = u.UCA";
        public static final String DEVSOFGROUP = "SELECT u.UCA, u.fname, u.lname FROM dev d, users u WHERE d.GID = ? AND d.UCA = u.UCA";
        public static final String GETANSWEREDASSESSMENTS = "SELECT a.AID, a.assessmentName FROM answers a WHERE a.GID = ? AND a.UCA = ?";
        public static final String GETMAXGID = "SELECT MAX(g.GID) AS MAX FROM(SELECT CAST(GID AS UNSIGNED) AS 'GID' FROM `group`) AS g";
        public static final String INSERTTOGROUP = "INSERT INTO `group` (GID, groupName) VALUES(?,?)";
        public static final String INSERTTOGInC = "INSERT INTO groupsincourse (CID, semester, GIDs) VALUES(?,'S2016', ?)";
        public static final String GETUCALIST = "SELECT UCA FROM users";
        public static final String INSERTUCA = "INSERT INTO users (UCA, password, fname, lname) VALUES(?,?,?,?)";
        public static final String INSERTPROJECTMANAGER = "INSERT INTO projectmanager (GID, UCA) VALUES(?,?)";
        public static final String INSERTDEV = "INSERT INTO dev (GID, UCA) VALUES(?,?)";
        public static final String UPDATEMEMBERLIST = "UPDATE `group` SET groupMembers = ? WHERE GID = ?";
        public static final String GETDEVLOGIN = "SELECT u.UCA, u.password FROM dev d, users u WHERE d.GID = ? AND d.UCA = u.UCA";
        public static final String GETPROJECTMANAGERLOGIN = "SELECT u.UCA, u.password FROM projectmanager pm, users u WHERE pm.GID = ? AND pm.UCA = u.UCA";
        public static final String PRESENTATIONGRADEFORGROUP = "SELECT * FROM presentationgrades WHERE GID = ?";
        public static final String INSERTORUPDATEPRESENTATIONGRADE = "INSERT into presentationgrades (GID, Evaluator, Points_earned, Points_possible, weighting) "
                                                                   + "VALUES (?, ?, ?, ?, ?) "
                                                                   + "ON DUPLICATE KEY UPDATE Points_earned=?, Points_possible=?, weighting=?";
}