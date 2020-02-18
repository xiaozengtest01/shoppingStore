package com.dianbenshu.entiy;

public class User {
	int UserId ;
	String UserName;
	String UserPassword;
	String UserSex;
	int UserType;
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public String getUserSex() {
		return UserSex;
	}
	public void setUserSex(String userSex) {
		UserSex = userSex;
	}
	public int getUserType() {
		return UserType;
	}
	public void setUserType(int userType) {
		UserType = userType;
	}
	
	public User(int userId, String userName, String userPassword, String userSex, int userType) {
		super();
		UserId = userId;
		UserName = userName;
		UserPassword = userPassword;
		UserSex = userSex;
		UserType = userType;
	}
	
	public User( String userName, String userPassword) {
		super();
		UserName = userName;
		UserPassword = userPassword;
	}
	
}
