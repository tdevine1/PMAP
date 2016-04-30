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
}