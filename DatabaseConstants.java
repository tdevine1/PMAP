package com.softwareengineers.web.database;



public static class DatabaseConstants{
	//Login Queries
	public static final string serverURL = "jdbc:mysql://127.0.0.1:3306/mydb";
	public static final string loginQuery = "SELECT IF( uca is not null  , 1, 0) as IsUser FROM users WHERE uca = ? and password = ?";
	public static final string instructorQuery = " SELECT IF(uca is not null, 1, 0) as IsInstructor FROM instructor WHERE uca = ?";
	//Instructor controller queries
	public static final string getName = "SELECT fname, lname FROM users WHERE UCA = ?";
	public static final string taughtCourse "SELECT CID FROM taughtCourse WHERE UCA = ?";
	public static final string getAName "SELECT aName FROM assessments WHERE CID = ?";
	//Student Controller queries
	public static final string getGID "SELECT GID, groupName FROM `group` WHERE groupMembers like ?";
	public static final string getGroupMembers "SELECT groupMembers FROM `group` WHERE GID = ?";
}