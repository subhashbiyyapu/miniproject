package com.cg.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cg.dto.RoomDTO;
import com.cg.dto.UserDTO;
import com.cg.dto.BookingDTO;
import com.cg.dto.HotelDTO;


public class StaticDB {
	private static List<UserDTO> userList=new ArrayList<UserDTO>();
	private static List<RoomDTO> roomList=new ArrayList<RoomDTO>();
	private static List<HotelDTO> hotelList=new ArrayList<HotelDTO>();
	private static List<BookingDTO> bookingList=new ArrayList<BookingDTO>();
	static
	{
	   	userList.add(new UserDTO(1001,"password1","HotelEmployee","user1","9912994098","ongole","user1@gmail.com"));
	   	userList.add(new UserDTO(1002,"password2","HotelEmployee","user2","9912994097","ongole","user2@gmail.com"));
		 roomList.add(new RoomDTO(122,1,"g101","AC",1200.00,true) );
		 roomList.add(new RoomDTO(122,2,"g102","NAC",800.00,true) );
		  roomList.add(new RoomDTO(121,3,"g103","AC",1200.00,true) );
	 	  roomList.add(new RoomDTO(121,4,"g104","NAC",800.00,true) );
	 	  //change locations of city and name
		  hotelList.add(new HotelDTO(121,"pune","pjr hotels","talwade","description1",1000.0,"9951187457","9912994098",4.5f,"pjr@gmail.com"));
	  	  hotelList.add(new HotelDTO(122,"pune","mvr hotels","talwade","description1",1000.0,"9951187457","9912994098",4.5f,"mvr@gmail.com"));
		 bookingList.add(new BookingDTO(121,3,1001, LocalDate.of(2020,3,12), LocalDate.of(2020,3,14), 1, 2, 2400.0));
		 bookingList.add(new BookingDTO(121,4,1002, LocalDate.of(2020,3,14), LocalDate.of(2020,3,15), 1, 2, 2400.0));
		bookingList.add(new BookingDTO(122,1,1001, LocalDate.of(2020,3,15), LocalDate.of(2020,3,16), 1, 2, 2400.0));
		bookingList.add(new BookingDTO(122,2,1002, LocalDate.of(2020,3,15), LocalDate.of(2020,3,16), 1, 2, 2400.0));
		
		
	}
	

	public static List<UserDTO> getUserList() {
		return userList;
	}
	public static void setUserList(List<UserDTO> userList) {
		StaticDB.userList = userList;
	}
	public static List<RoomDTO> getRoomList() {
		return roomList;
	}
	public static void setRoomList(List<RoomDTO> roomList) {
		StaticDB.roomList = roomList;
	}
	public static List<HotelDTO> getHotelList() {
		return hotelList;
	}
	public static void setHotelList(List<HotelDTO> hotelList) {
		StaticDB.hotelList = hotelList;
	}
	public static List<BookingDTO> getBookingList() {
		return bookingList;
	}
	public static void setBookingList(List<BookingDTO> bookingList) {
		StaticDB.bookingList = bookingList;
	}
	

}
