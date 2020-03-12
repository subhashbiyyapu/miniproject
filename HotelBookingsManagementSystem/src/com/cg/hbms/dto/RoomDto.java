package com.cg.hbms.dto;

public class RoomDto {

	private  Integer hotelId;
	private  Integer roomId;
	private  String roomNo;
	private  String roomType;
	private  Double perNightRate;
	private  Boolean availability;
	 
	public RoomDto(){}
	
	public RoomDto(Integer hotelId, Integer roomId, String roomNo, String roomType, Double perNightRate,
			Boolean availability) {
		super();
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.perNightRate = perNightRate;
		this.availability = availability;
	}
	
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Double getPerNightRate() {
		return perNightRate;
	}
	public void setPerNightRate(Double perNightRate) {
		this.perNightRate = perNightRate;
	}
	public Boolean isAvailability() {
		return availability;
	}
	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "RoomDto [hotelId=" + hotelId + ", roomId=" + roomId + ", roomNo=" + roomNo + ", roomType=" + roomType
				+ ", perNightRate=" + perNightRate + ", availability=" + availability + "]";
	}
	
	
}
