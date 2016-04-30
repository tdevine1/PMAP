package com.softwareengineers.web.database;



public class DatabaseConstants{
	//Login Queries
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/mydb";
        public static final String USER = "root";
        public static final String PASSWORD = "Prog1";
	public static final String loginQuery = "SELECT IF( uca is not null  , 1, 0) as IsUser FROM users WHERE uca = ? and password = ?";
	public static final String instructorQuery = " SELECT IF(uca is not null, 1, 0) as IsInstructor FROM instructor WHERE uca = ?";
	//Instructor controller queries
	public static final String getName = "SELECT fname, lname FROM users WHERE UCA = ?";
	public static final String taughtCourse = "SELECT CID FROM taughtCourse WHERE UCA = ?";
	public static final String getAName = "SELECT aName FROM assessments WHERE CID = ?";
	//Student Controller queries
	public static final String getGID = "SELECT GID, groupName FROM `group` WHERE groupMembers like ?";
	public static final String getGroupMembers = "SELECT groupMembers FROM `group` WHERE GID = ?";
}