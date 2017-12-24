package model;

public class UserModel {
   
	 private String username;
	 private String password;
	 
public UserModel() {
	
}
public UserModel(String username) {//why use more than one constructor with different parameter
	this.username=username;
}
public UserModel(String username,String password) {
	this.username=username;
	this.password=password;
}
/**
 * @return the username
 */
public String getUsername() {
	return username;
}
/**
 * @param username the username to set
 */
public void setUsername(String username) {
	this.username = username;
}
/**
 * @return the password
 */
public String getPassword() {
	return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}

	
	
}
