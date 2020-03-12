package com.cg.hbms.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.hbms.dto.BookingDto;
import com.cg.hbms.dto.HotelDto;
import com.cg.hbms.dto.RoomDto;
import com.cg.hbms.dto.UserDto;

/*
 * Hotel Id starts from 101
 * Booking Id starts from 9001
 * Room Id 1001
 * Admin Id is 999
 * User Id starts from 911
 */
public class StaticDb {
	private static Map<Integer,UserDto> userData = new HashMap<Integer,UserDto>();
	private static Map<Integer, RoomDto> roomData=new HashMap<Integer,RoomDto>();
	private static Map<Integer, BookingDto> bookingData= new HashMap<Integer,BookingDto>();
	private static Map<Integer,HotelDto> hotelData = new HashMap<Integer,HotelDto>();
	static{
		userData.put(911, (new UserDto(911,"aSD1122@","user","Shubham","9805905823","Dharamshala","U1mail.com",null)));
		userData.put(912, (new UserDto(912,"Qwe1234!","user","Ashish","8894672528","Utarakhand","U2mail.com",null)));
		hotelData.put(101,(new HotelDto(101,"H1","Pune","Plot no.1","H1 desc",1500.0,"1231231231","1121214354",3.5,"H1mail.com")));
		hotelData.put(102,(new HotelDto(102,"H2","Pune","Plot no.1","H2 desc",2500.0,"1254734895","8568435757",4.5,"H2mail.in")));
		roomData.put(1001,(new RoomDto(101,1001,"301","Ac",1600.0,true)));
		roomData.put(1002,(new RoomDto(101,1002,"302","NonAc",800.0,true)));
		roomData.put(1003,(new RoomDto(101,1003,"303","Ac",2000.0,true)));
		roomData.put(1004,(new RoomDto(102,1004,"201","Ac",2500.0,true)));
		roomData.put(1005,(new RoomDto(102,1005,"202","Ac",2500.0,true)));
		roomData.put(1006,(new RoomDto(102,1006,"203","Ac",2500.0,true)));
		bookingData.put(9001,(new BookingDto(1003,101,111,LocalDate.of(2020,2,14), LocalDate.of(2020,2,15),2,0,2000.0)));
		bookingData.put(9002,(new BookingDto(1005,102,112,LocalDate.of(2020,2,20), LocalDate.of(2020,2,22),2,0,5000.0)));
	}
	public static Map<Integer, UserDto> getUserData() {
		return userData;
	}
	public static void setUserData(Map<Integer, UserDto> userData) {
		StaticDb.userData = userData;
	}
	public static Map<Integer, RoomDto> getRoomData() {
		return roomData;
	}
	public static void setRoomData(Map<Integer, RoomDto> roomData) {
		StaticDb.roomData = roomData;
	}
	public static Map<Integer, BookingDto> getBookingData() {
		return bookingData;
	}
	public static void setBookingData(Map<Integer, BookingDto> bookingData) {
		StaticDb.bookingData = bookingData;
	}
	public static Map<Integer, HotelDto> getHotelData() {
		return hotelData;
	}
	public static void setHotelData(Map<Integer, HotelDto> hotelData) {
		StaticDb.hotelData = hotelData;
	}
	
	
	
}
