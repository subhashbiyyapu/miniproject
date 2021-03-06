package com.cg.dto;

public class RoomDTO {
	 private  int hotelId;
	 private  int roomId;
	 private  String roomNo;
	 private  String roomType;
	 private  double perNightRate;
	 private  boolean availability;
	public RoomDTO(int hotelId, int roomId, String roomNo, String roomType, double perNightRate, boolean availability) {
		super();
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.perNightRate = perNightRate;
		this.availability = availability;
	}
	public RoomDTO() {
		super();
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
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
	public double getPerNightRate() {
		return perNightRate;
	}
	public void setPerNightRate(double perNightRate) {
		this.perNightRate = perNightRate;
	}
	public boolean isAvailability() {
		return availability;
	}
	@Override
	public String toString() {
		return "RoomDTO [hotelId=" + hotelId + ", roomId=" + roomId + ", roomNo=" + roomNo + ", roomType=" + roomType
				+ ", perNightRate=" + perNightRate + ", availability=" + availability + "]";
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	 
	 
	 
	 
	
}