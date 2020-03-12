package com.cg.hbms.dao;

import java.util.List;


import com.cg.hbms.dto.BookingDto;
import com.cg.hbms.dto.RoomDto;

public interface HotelEmployeeDao {
	
	List<RoomDto> fetchRoomsByHotelId(int hotelId);
	List<BookingDto> fetchBookingdetails(int hotelId);
	Boolean insertInToBookingTable(BookingDto bookedObj);
	

}
