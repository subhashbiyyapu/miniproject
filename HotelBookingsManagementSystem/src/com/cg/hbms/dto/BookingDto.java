package com.cg.hbms.dto;

import java.time.LocalDate;
public class BookingDto {
	static int index=1;
	Integer bookingId;
	Integer roomId;
	Integer hotelId;
	Integer userId;
	LocalDate bookedFrom;
	LocalDate bookedTo;
	Integer noOfAdults;
	Integer noOfChildren;
	Double amount;
	public BookingDto(){}
	
	

	public BookingDto( Integer roomId, Integer hotelId, Integer userId, LocalDate bookedFrom,
			LocalDate bookedTo, Integer noOfAdults, Integer noOfChildren, Double amount) {
		super();
		this.bookingId = index++;
		this.roomId = roomId;
		this.hotelId = hotelId;
		this.userId = userId;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.noOfAdults = noOfAdults;
		this.noOfChildren = noOfChildren;
		this.amount = amount;
	}

	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public LocalDate getBookedFrom() {
		return bookedFrom;
	}
	public void setBookedFrom(LocalDate bookedFrom) {
		this.bookedFrom = bookedFrom;
	}
	public LocalDate getBookedTo() {
		return bookedTo;
	}
	public void setBookedTo(LocalDate bookedTo) {
		this.bookedTo = bookedTo;
	}
	public Integer getNoOfAdults() {
		return noOfAdults;
	}
	public void setNoOfAdults(Integer noOfAdults) {
		this.noOfAdults = noOfAdults;
	}
	public Integer getNoOfChildren() {
		return noOfChildren;
	}
	public void setNoOfChildren(Integer noOfChildren) {
		this.noOfChildren = noOfChildren;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString()
	{
		return "\nBooking ID: "+bookingId
				+"\nUser ID: "+userId
				+"\nRoom ID: "+roomId
				+"\nBooked From: "+bookedFrom
				+"\tBooked To: "+bookedTo
				+"\nNumber of Adults: "+noOfAdults
				+"\nAmount: "+amount+"\n";
	}
}
