package com.cg.dto;

import java.time.LocalDate;
import java.util.Date;

public class BookingDTO {
	

	static int bookingIndex=1;
	private    int  bookingId;
	private int hotelId;//has to be changed
private int roomId;
private int userId;

LocalDate bookedFrom;
LocalDate bookedTo;
int noOfAdults;
int noOfChilderen;
Double amount;







public BookingDTO() {
	super();
}




public BookingDTO( int hotelId, int roomId, int userId, LocalDate bookedFrom, LocalDate bookedTo,
		int noOfAdults, int noOfChilderen, Double amount) {
	super();
	this.bookingId =bookingIndex++;
	this.hotelId = hotelId;
	this.roomId = roomId;
	this.userId = userId;
	this.bookedFrom = bookedFrom;
	this.bookedTo = bookedTo;
	this.noOfAdults = noOfAdults;
	this.noOfChilderen = noOfChilderen;
	this.amount = amount;
}




public int getBookingId() {
	return bookingId;
}
public void setBookingId(int bookingId) {
	this.bookingId = bookingId;
}
public int getRoomId() {
	return roomId;
}
public void setRoomId(int roomId) {
	this.roomId = roomId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
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
public int getNoOfAdults() {
	return noOfAdults;
}
public void setNoOfAdults(int noOfAdults) {
	this.noOfAdults = noOfAdults;
}
public int getNoOfChilderen() {
	return noOfChilderen;
}
public void setNoOfChilderen(int noOfChilderen) {
	this.noOfChilderen = noOfChilderen;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}




@Override
public String toString() {
	return "BookingDTO [\nbookingId=" + bookingId + ",\nhotelId=" + hotelId + "\nroomId=" + roomId + "\nuserId=" + userId
			+ "\n bookedFrom=" + bookedFrom + "\n bookedTo=" + bookedTo + "\nnoOfAdults=" + noOfAdults
			+ "\nnoOfChilderen=" + noOfChilderen + "\n amount=" + amount + "]";
}




public int getHotelId() {
	return hotelId;
}




public void setHotelId(int hotelId) {
	this.hotelId = hotelId;
}








}
