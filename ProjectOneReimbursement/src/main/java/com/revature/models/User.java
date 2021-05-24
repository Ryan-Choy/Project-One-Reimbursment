package com.revature.models;

public class User {
	private Integer userId;
	private Integer roleId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer userId, Integer roleId, String userName, String password, String firstName, String lastName,
			String email) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", roleId=" + roleId + ", userName=" + userName + ", password=" + password
				+ ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
