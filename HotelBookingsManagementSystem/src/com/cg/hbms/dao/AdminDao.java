package com.cg.hbms.dao;

import java.util.List;

import com.cg.hbms.dto.BookingDto;
import com.cg.hbms.dto.HotelDto;

public interface AdminDao {
	public String addHotel(String hotelName,String hotelCity,String hotelAddress,String hotelDescription,String strHotelAvgRatePerNight,String hotelPhone1,String hotelPhone2,String strHotelRating,String hotelEmail);
	public String delHotel(String strHotelId);
	public String addRoom(String strHotelId,String RoomNo,String roomType,String strPerNightRate);
	public String delRoom(String strRoomId);
	public List<HotelDto> viewListOfHotels();
	public List<BookingDto> viewBookingsByHotel(String strHotelId);
	public List<BookingDto> viewBookingsByDate(String strDate);
	public boolean authenticate(String strUserId, String password);
}
