package com.cg.hbms.service;



import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import com.cg.hbms.dao.HotelEmployeeDao;
import com.cg.hbms.dao.HotelEmployeeDaoImpl;
import com.cg.hbms.dto.BookingDto;
import com.cg.hbms.dto.RoomDto;
import com.cg.hbms.exception.NoRoomsAvailableException;

public class HotelEmployeeServiceImpl  implements HotelEmployeeService{
	
	HotelEmployeeDao hdao=new  HotelEmployeeDaoImpl();
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

	 public HashMap<Integer,RoomDto>    displayRooms(int hotelId,LocalDate fromDate,LocalDate toDate)
	 {
		 
		
		List<BookingDto> bookList=hdao.fetchBookingdetails( hotelId);
		List<RoomDto> roomList =hdao.fetchRoomsByHotelId(hotelId);
		 HashMap <Integer,RoomDto> roomHashMap=new HashMap<Integer,RoomDto>();
		if(bookList==null)
		{
			
		}
		else
		{
	   
		
		for(RoomDto room:roomList)
		{
			for(BookingDto book: bookList)
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
		for(RoomDto room:roomList){
			roomHashMap.put(room.getRoomId(),room);
				}
		
		return roomHashMap;
	 }
	 
	 
	
	 
	 public HashMap<Integer,RoomDto>    displayRoomsBasedOnType(int hotelId,LocalDate fromDate,LocalDate toDate,int type) throws NoRoomsAvailableException
	 {
		 String roomType;
			if(type==1)
			{
				roomType="Ac";
			}
			else
			{
				roomType="NonAc";

			}
		
		List<BookingDto> bookList=hdao.fetchBookingdetails( hotelId);
		List<RoomDto> roomList =hdao.fetchRoomsByHotelId(hotelId);
	    HashMap <Integer,RoomDto> roomHashMap=new HashMap<Integer,RoomDto>();
		
		if(bookList==null)
		{
			
		}
		else
		{
	   
		for(RoomDto room:roomList)
		{
			if(room.getRoomType().equals(roomType))
			{
			for(BookingDto book: bookList)
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
		}
		
		System.out.println(roomList);
		for(RoomDto room:roomList){
			if(room.getRoomType().equals(roomType)  &&  room.isAvailability()==true)
			{
			roomHashMap.put(room.getRoomId(),room);
			}
				}
		if(roomHashMap.isEmpty())
		{
			throw new NoRoomsAvailableException();
		}
		return roomHashMap;
	 }




	@Override
	public String addBookingRecord(BookingDto bookingObj) {
		Boolean flag=hdao.insertInToBookingTable(bookingObj);
		if(flag)
			return "Booking Finished";
		else
		return "Booking error";
	}
	 
	 
	
}
