package com.cg.dto;

public class UserDTO {
	private  int user_id;
	private String password;
	private String role;
	private  String user_name;
	private String phonenumber;
	private  String address;
	private String email;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonrnumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserDTO(int user_id, String password, String role, String user_name, String phonenumber, String address,
			String email) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.role = role;
		this.user_name = user_name;
		this.phonenumber = phonenumber;
		this.address = address;
		this.email = email;
	}
	
	public UserDTO()
	{
		
	}

}
//user_id(varchar(4)), password (varchar(7)), 
//role(varchar(10),  user_name(varchar (20)), 
//		mobile_no(varchar(10)),
//		phone(varchar(10)), address (varchar(25)),
//		email (varchar(15))