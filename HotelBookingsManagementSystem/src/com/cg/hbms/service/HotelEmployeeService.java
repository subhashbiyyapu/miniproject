package com.cg.hbms.service;

import java.time.LocalDate;

import java.util.HashMap;
import java.util.List;

import com.cg.hbms.dto.BookingDto;
import com.cg.hbms.dto.RoomDto;
import com.cg.hbms.exception.NoRoomsAvailableException;



public interface HotelEmployeeService {
	//String enableOrdisable(String room_name);
HashMap<Integer,RoomDto>  displayRooms(int hoteld,LocalDate bookedFrom,LocalDate bookedTo);
HashMap<Integer,RoomDto>  displayRoomsBasedOnType(int hoteld,LocalDate bookedFrom,LocalDate bookedTo,int RoomType) throws NoRoomsAvailableException;
  String  addBookingRecord(BookingDto bookingObj);
}
