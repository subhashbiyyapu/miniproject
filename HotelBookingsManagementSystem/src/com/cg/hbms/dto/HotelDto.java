package com.cg.hbms.dto;
public class HotelDto {
	private Integer hotelId;
	private String hotelName;
	private String hotelCity;
	private String hotelAddress;
	private String hotelDescription ;
	private Double hotelAvgRatePerNight;
	private String hotelPhone1;
	private String hotelPhone2;
	private Double hotelRating;
	private String hotelEmail;
	
	public HotelDto(){}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelCity() {
		return hotelCity;
	}

	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getHotelDescription() {
		return hotelDescription;
	}

	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	public Double getHotelAvgRatePerNight() {
		return hotelAvgRatePerNight;
	}

	public void setHotelAvgRatePerNight(Double hotelAvgRatePerNight) {
		this.hotelAvgRatePerNight = hotelAvgRatePerNight;
	}

	public String getHotelPhone1() {
		return hotelPhone1;
	}

	public void setHotelPhone1(String hotelPhone1) {
		this.hotelPhone1 = hotelPhone1;
	}

	public String getHotelPhone2() {
		return hotelPhone2;
	}

	public void setHotelPhone2(String hotelPhone2) {
		this.hotelPhone2 = hotelPhone2;
	}

	public Double getHotelRating() {
		return hotelRating;
	}

	public void setHotelRating(Double hotelRating) {
		this.hotelRating = hotelRating;
	}

	public String getHotelEmail() {
		return hotelEmail;
	}

	public void setHotelEmail(String hotelEmail) {
		this.hotelEmail = hotelEmail;
	}

	public HotelDto(Integer hotelId, String hotelName, String hotelCity, String hotelAddress, String hotelDescription,
			Double hotelAvgRatePerNight, String hotelPhone1, String hotelPhone2, Double hotelRating,
			String hotelEmail) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelCity = hotelCity;
		this.hotelAddress = hotelAddress;
		this.hotelDescription = hotelDescription;
		this.hotelAvgRatePerNight = hotelAvgRatePerNight;
		this.hotelPhone1 = hotelPhone1;
		this.hotelPhone2 = hotelPhone2;
		this.hotelRating = hotelRating;
		this.hotelEmail = hotelEmail;
	}

	@Override
	public String toString() {
		return 	"\n"+hotelName+" [Hotel ID: " + hotelId +"]"
				+ "\nCity:" + hotelCity
				+ "\nAddress:" + hotelAddress 
				+ "\nDescription: " + hotelDescription
				+ "\nAverage Rate Per Night: " + hotelAvgRatePerNight 
				+ "\nHotel Phone Number: " + hotelPhone1 
				+ "\nAlternate Phone Number: " + hotelPhone2 
				+ "\nCustomer Rating: " + hotelRating 
				+ "\nEmail address: " + hotelEmail + "\n\n";
	}
	
	
}
