package com.cg.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.dto.BookingDTO;
import com.cg.dto.RoomDTO;

public class HotelEmployeeDAOImpl  implements HotelEmployeeDAO{
	
	 public List<RoomDTO> fetchRoomsByHotelId( int hotelId)
	{
		 
		 List<RoomDTO> roomlist= StaticDB.getRoomList();
		 List<RoomDTO> tempRoomList=new ArrayList<RoomDTO>();
		 for(RoomDTO rdto :roomlist)
		 {
			 if((rdto.getHotelId()==hotelId))
			 {
			
				 tempRoomList.add(rdto);
			 }
			 else
			 {
				
			 }
		 }
		 return tempRoomList;
	}
	 
	 
		public List<BookingDTO> fetchBookingdetails(int hotelId)
		{
			 List<BookingDTO> bookingList= StaticDB.getBookingList();
			 int index=0;
			 for(BookingDTO rdto :bookingList)
			 {
				 if(!(rdto.getHotelId()==hotelId))
				 {
					 bookingList.remove(index);
				 }
				 else
				 {
					 index++;
				 }
			 }
			 return bookingList;

		
		}



}
