package com.cg.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import com.cg.dto.RoomDTO;

public interface HotelEmployeeService {
	//String enableOrdisable(String room_name);
HashMap<Integer,RoomDTO>  displayRooms(int hoteld,LocalDate bookedFrom,LocalDate bookedTo);
HashMap<Integer,RoomDTO>  displayRoomsBasedOnType(int hoteld,LocalDate bookedFrom,LocalDate bookedTo,String type);
  
}
