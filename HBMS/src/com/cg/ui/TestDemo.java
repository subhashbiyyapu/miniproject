package com.cg.ui;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.cg.dto.BookingDTO;
import com.cg.dto.RoomDTO;
import com.cg.service.HotelEmployeeService;
import com.cg.service.HotelEmployeeServiceImpl;
public class TestDemo {
	
	static LocalDate  getDate()
	{

		Scanner sc=new Scanner(System.in);
		System.out.println("enter year");
		int year=sc.nextInt();
		System.out.println("enter month  from 1 to 12");
		int month=sc.nextInt();;
		System.out.println("enter day ");
		int day =sc.nextInt();
		LocalDate ld=LocalDate.of(year, month, day);
		return ld;
	}

	public static void main(String[] args) {
		int hotelId=121;
		int userId=1001;
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Enable or Disable a Room\n2.Display all the rooms \n 3.book a room");
		int choice=sc.nextInt();
	    HotelEmployeeService he=new HotelEmployeeServiceImpl();
	    HashMap <Integer,RoomDTO> roomHashMap=new HashMap<Integer,RoomDTO>();
	  
	    List<RoomDTO>  roomList=null;
	    int roomChoice,roomType;
	    String roomTypeS;
	    Double amount;
	 
		switch(choice)
		{
		case 1:
		
		
	/*	String room_name=sc.next();
		String response=he.enableOrdisable(room_name);
		System.out.println(response);
		*/
		
		case 2:
			roomHashMap=   he.displayRooms(hotelId, LocalDate.of(2020,3,13),  LocalDate.of(2020,3,14));
			Set<Entry<Integer,RoomDTO>> entrySet=roomHashMap.entrySet();
			for(Entry entry : entrySet)
			{
				RoomDTO room=new RoomDTO();
				room=(RoomDTO)entry.getValue();
				System.out.println(room.getRoomNo()+"       "+room.isAvailability()+"     "+room.getRoomType());
			}

			break;
		case 3:
			
			
			
			System.out.println("enter Type of the room\n1.AC\n2.NonAC");
			roomType=sc.nextInt();
			if(roomType==1)
			{
				roomTypeS="AC";
			}
			else
			{
				roomTypeS="NAC";

			}
			
			System.out.println("enter FROM date");
			LocalDate fromDate=getDate();
			LocalDate toDate;
			while(true)
			{
			System.out.println("Enter TO date");
		        toDate=getDate();
			if(toDate.compareTo(fromDate)>0)
				break;
			else
			{
				System.out.println("TO date has to be after FROM date");
			}
			}
			
			  
			
			 int numDays = Period.between(fromDate, toDate).getDays();
			
			//LocalDate.of(2020,3,13),  LocalDate.of(2020,3,14)
			
			System.out.println(roomTypeS+"Rooms available ::::::");
			roomHashMap=   he.displayRoomsBasedOnType(hotelId, fromDate,toDate,roomTypeS);
			Set<Entry<Integer,RoomDTO>> entrySet1=roomHashMap.entrySet();
			for(Entry entry : entrySet1)
			{ 
				RoomDTO room=new RoomDTO();
				
				room=(RoomDTO)entry.getValue();
				
				System.out.println(room.getRoomId()+"      "+room.getRoomNo()+"       "+room.isAvailability());
				
			}

			
			
			while(true)
			{
			System.out.println("Enter room Id");
			roomChoice=sc.nextInt();
		
			RoomDTO tempRoom=roomHashMap.get(roomChoice);
			if(tempRoom==null)
			{
				System.out.println("room is not available");
			}
			else
			{
			if(tempRoom.isAvailability()==true )
			{amount=tempRoom.getPerNightRate();
				break;
			}
			else
			{
				System.out.println("room is not available");
			}
			}
			}
			
			
			System.out.println("enter no of adults");
			int noOfAdult=sc.nextInt();
			
			System.out.println("enter no of children");
			int noOfChildren=sc.nextInt();
			
		amount=numDays*amount;
		System.out.println("Total    Amount"+amount);
			
	      BookingDTO bookdto=new BookingDTO(hotelId,roomChoice,userId,fromDate,toDate,noOfAdult,noOfChildren,amount);
	      
				System.out.println("Booking Finished");
				System.out.println(bookdto);
				
		
			
		
		}
		
		

	

	}

}
