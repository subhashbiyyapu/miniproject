package com.cg.dto;

public class HotelDTO {
	private int HotelId;
	private String city;
	private String hotelName;
	private String address;
	private String description ;
	double avgRatPerNight;
	private String phoneno1;
	private String phoneno2;
	private float rating;
	private String email;
	
	
	
	
	

	
	public HotelDTO(int hotelId, String city, String hotelName, String address, String description,
			double avgRatPerNight, String phoneno1, String phoneno2, float rating, String email) {
		super();
		HotelId = hotelId;
		this.city = city;
		this.hotelName = hotelName;
		this.address = address;
		this.description = description;
		this.avgRatPerNight = avgRatPerNight;
		this.phoneno1 = phoneno1;
		this.phoneno2 = phoneno2;
		this.rating = rating;
		this.email = email;
	}
	
	public HotelDTO()
	{
		
	}

	
	public int getHotelId() {
		return HotelId;
	}

	public void setHotelId(int hotelId) {
		HotelId = hotelId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAvgRatPerNight() {
		return avgRatPerNight;
	}

	public void setAvgRatPerNight(double avgRatPerNight) {
		this.avgRatPerNight = avgRatPerNight;
	}

	public String getPhoneno1() {
		return phoneno1;
	}

	public void setPhoneno1(String phoneno1) {
		this.phoneno1 = phoneno1;
	}

	public String getPhoneno2() {
		return phoneno2;
	}

	public void setPhoneno2(String phoneno2) {
		this.phoneno2 = phoneno2;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
