package com.cg.hbms.dto;

public class UserDto {
	private  Integer userId;
	private String password;
	private String role;
	private  String userName;
	private String phoneNumber;
	private  String address;
	private String email;
	private Integer hotelId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhonenumber() {
		return phoneNumber;
	}
	public void setPhonenumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public UserDto(Integer userId, String password, String role, String userName, String phoneNumber, String address,
			String email, Integer hotelId) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.hotelId = hotelId;
	}
	public UserDto()
	{
		
	}
}
