package com.cg.hbms.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.cg.hbms.dto.BookingDto;
import com.cg.hbms.dto.RoomDto;



public class HotelEmployeeDaoImpl  implements HotelEmployeeDao{
	
	 public List<RoomDto> fetchRoomsByHotelId( int hotelId)
	{
		 //	roomData.put(1001,(new RoomDto(101,1001,"301","Ac",1600.0,true)));
RoomDto key;
		 List<RoomDto> tempRoomList=new ArrayList<RoomDto>();
		 Set<Entry<Integer,RoomDto>> roomEntrySet=StaticDb.getRoomData().entrySet();
		 for(Entry  search:roomEntrySet )
		 {
			 key=(RoomDto)search.getValue();
			 if(key.getHotelId()==hotelId)
			 {
				 tempRoomList.add(key);
			 }
		 }
		 
		 return tempRoomList;
		 
	
	}
	 
	 
		public List<BookingDto> fetchBookingdetails(int hotelId)
		{
			BookingDto key;
			 Set<Entry<Integer,BookingDto>> bookingEntrySet=StaticDb.getBookingData().entrySet();
			 List<BookingDto> bookingList=new ArrayList<BookingDto>();
			
			 for(Entry  search:bookingEntrySet )
			 {
				 key=(BookingDto)search.getValue();
				 if(key.getHotelId()==hotelId)
				 {
					 bookingList.add(key);
				 }
			 }
			 
			 return bookingList;
		//have to write exception for null values
		}


		@Override
		public Boolean insertInToBookingTable(BookingDto bookedObj) {
			// TODO Auto-generated method stub
			StaticDb.getBookingData().put(bookedObj.getBookingId(),bookedObj);
		return true;
		}



}
