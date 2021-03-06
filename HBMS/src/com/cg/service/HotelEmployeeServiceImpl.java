package com.cg.service;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cg.dao.HotelEmployeeDAO;
import com.cg.dao.HotelEmployeeDAOImpl;
import com.cg.dto.BookingDTO;
import com.cg.dto.RoomDTO;

public class HotelEmployeeServiceImpl  implements HotelEmployeeService{
	
	HotelEmployeeDAO hdao=new  HotelEmployeeDAOImpl();
	/* public String enableOrdisable(String room_name)
	{

		List<RoomDTO> roomList=(ArrayList)hdao.fetchByHotelId( );
		boolean flag;
		String returnstring="";
		boolean roomNotFound=false;
		for(RoomDTO rdto:roomList)
		{
			if(rdto.getRoomNo().equals(room_name))
			{  roomNotFound=true;
				flag=rdto.isAvailability();
				rdto.setAvailability(!flag);
				returnstring= room_name+"'s availability is changed to "+(!flag);
				
			}
		}
		if(roomNotFound==false)
		{
			returnstring= room_name+"is not present in the hotel";
		}
		return returnstring;
		
	}*/

	 public HashMap<Integer,RoomDTO>    displayRooms(int hotelId,LocalDate fromDate,LocalDate toDate)
	 {
		 
		
		List<BookingDTO> bookList=hdao.fetchBookingdetails( hotelId);
		List<RoomDTO> roomList =hdao.fetchRoomsByHotelId(hotelId);
	    HashMap <Integer,RoomDTO> roomHashMap=new HashMap<Integer,RoomDTO>();
		
		for(RoomDTO room:roomList)
		{
			for(BookingDTO book: bookList)
			{
			if(room.getRoomId()==book.getRoomId())
			{
				if(fromDate.isBefore(book.getBookedFrom())   &&( toDate.isBefore(book.getBookedFrom())   || toDate.isEqual(book.getBookedFrom()) ))
				{
					room.setAvailability(true); 
				}
				
				else	if(fromDate.isAfter(book.getBookedTo()) || fromDate.isEqual(book.getBookedTo())    )
				{room.setAvailability(true); 
					
				}
				else
				{
					room.setAvailability(false);
					break;
				}
			}
			}
			
			
		}
		
		for(RoomDTO room:roomList){
			roomHashMap.put(room.getRoomId(),room);
				}
		
		return roomHashMap;
	 }
	 
	 
	
	 
	 public HashMap<Integer,RoomDTO>    displayRoomsBasedOnType(int hotelId,LocalDate fromDate,LocalDate toDate,String type)
	 {
		 
		
		List<BookingDTO> bookList=hdao.fetchBookingdetails( hotelId);
		List<RoomDTO> roomList =hdao.fetchRoomsByHotelId(hotelId);
	    HashMap <Integer,RoomDTO> roomHashMap=new HashMap<Integer,RoomDTO>();
		
		for(RoomDTO room:roomList)
		{
			if(room.getRoomType().equals(type))
			{
			for(BookingDTO book: bookList)
			{
			if(room.getRoomId()==book.getRoomId())
			{
				if(fromDate.isBefore(book.getBookedFrom())   &&( toDate.isBefore(book.getBookedFrom())   || toDate.isEqual(book.getBookedFrom()) ))
				{
					room.setAvailability(true); 
				}
				
				else	if(fromDate.isAfter(book.getBookedTo()) || fromDate.isEqual(book.getBookedTo())    )
				{room.setAvailability(true); 
					
				}
				else
				{
					room.setAvailability(false);
					break;
				}
			}
			}
			}
			
		}
		
		for(RoomDTO room:roomList){
			if(room.getRoomType().equals(type))
			roomHashMap.put(room.getRoomId(),room);
				}
		
		return roomHashMap;
	 }
	 
	 
	
}
