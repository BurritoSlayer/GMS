package models;
/*
 * Model for User, is super class for person. Contains the 
 * user role's information as well.
 */
public class User {
	
	private int UserID;
	private String username;
	private String password;
	private int personid;
	private int userRole;
	private String userRoleName;
	private String personName;
	
	public User(){ //non argument constructor for user

	} 
	
	public User(int iD, String username, String password, int 
			personid, int userRole, String userRoleName) {
		UserID = iD;
		this.username = username;
		this.password = password;
		this.personid = personid;
		this.userRole = userRole;
		this.userRoleName = userRoleName;
	}
	
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int iD) {
		UserID = iD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	public String getUserRoleName(){
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

}
