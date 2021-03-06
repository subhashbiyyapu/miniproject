package com.cg.hbms.ui;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import com.cg.hbms.dto.BookingDto;
import com.cg.hbms.dto.RoomDto;
import com.cg.hbms.exception.NoRoomsAvailableException;
import com.cg.hbms.service.AdminService;
import com.cg.hbms.service.AdminServiceImpl;
import com.cg.hbms.service.HotelEmployeeService;
import com.cg.hbms.service.HotelEmployeeServiceImpl;


public class Ui {
	
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
		
		Scanner sc = new Scanner(System.in);
		
		int mainOption;
		char mainChoice='y';
		System.out.println("----------------WELCOME TO HBMS----------------");
		while(mainChoice=='y')
		{
			System.out.println("\n1. Login as Customer"
					+ "\n2. Login as Hotel Employee"
					+ "\n3. Login as Admin"
					+ "\n4. New user? Register"
					+ "\n5. Exit"
					+ "\n\nSelect option: ");
			mainOption=sc.nextInt();
			sc.nextLine();
			switch(mainOption)
			{
			case 1:
				System.out.println("User Login coming soon...");
				break;
				
				
				
			case 2:
				System.out.println("Hotel Employee Login ");
				int hotelId=101;
				int userId=1001;
				
				System.out.println("1.Display all the rooms \n 2.book a room");
				int choice=sc.nextInt();
			    HotelEmployeeService he=new HotelEmployeeServiceImpl();
			    HashMap <Integer,RoomDto> roomHashMap=new HashMap<Integer,RoomDto>();
			  
			    List<RoomDto>  roomList=null;
			    int roomChoice,roomTypeI;
			    String roomTypeS;
			    Double amount;
			 
				switch(choice)
				{
				
				case 1:
					roomHashMap=   he.displayRooms(hotelId, LocalDate.of(2020,3,13),  LocalDate.of(2020,3,14));
					Set<Entry<Integer,RoomDto>> entrySet=roomHashMap.entrySet();
					for(Entry entry : entrySet)
					{
						RoomDto room=new RoomDto();
						room=(RoomDto)entry.getValue();
						System.out.println(room.getRoomNo()+"       "+room.isAvailability()+"     "+room.getRoomType());
					}

					break;
				case 2:
					try
					{
				
					System.out.println("enter Type of the room\n1.AC\n2.NonAC");
					roomTypeI=sc.nextInt();
					if(roomTypeI==1)
					{
						roomTypeS="AC";
					}
					else
					{
						roomTypeS="NAC";

					}
					//validation for dates 
					/*
					 * 1.to date has to be after from date
					 * max days 1 week
					 * check for validity of the date ,ie date should not be before todays date
					 */
					/*
					 * if rooms available are all false,
					 * then exception has to be generated
					 * 
					 */
					/*
					 * booking details has to be updated in data base,
					 * so service layer and dao class must be written
					 */
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
					System.out.println(roomTypeS+"Rooms available ::::::");
					roomHashMap=   he.displayRoomsBasedOnType(hotelId, fromDate,toDate,roomTypeI);
					Set<Entry<Integer,RoomDto>> entrySet1=roomHashMap.entrySet();
					for(Entry entry : entrySet1)
					{ 
						RoomDto room=new RoomDto();
						
						room=(RoomDto)entry.getValue();
						
						System.out.println(room.getRoomId()+"      "+room.getRoomNo()+"       "+room.isAvailability());
						
					}

					
					
					while(true)
					{
					System.out.println("Enter room Id");
					roomChoice=sc.nextInt();
				
					RoomDto tempRoom=roomHashMap.get(roomChoice);
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
					//		bookingData.put(9002,(new BookingDto(9002,1005,102,112,LocalDate.of(2020,2,20), LocalDate.of(2020,2,22),2,0,5000.0)));

			      BookingDto bookDto=new BookingDto(roomChoice,hotelId,userId,fromDate,toDate,noOfAdult,noOfChildren,amount);
			      String bookingStatus=he.addBookingRecord(bookDto);
						System.out.println(bookingStatus);
						System.out.println(bookDto);
						
				}
						catch(NoRoomsAvailableException e)
						{
							System.out.println(e);
						}
			
				
				}
				
				
			

				
				
				
				break;
			
			case 3:
				char adminLoginChoice='y';
				AdminService adminService= new AdminServiceImpl();
				while(adminLoginChoice=='y')
				{
					System.out.println("Enter Admin User ID: ");
					String strAdminId =sc.nextLine();
					System.out.println("Enter Admin password: ");
					String adminPassword=sc.nextLine();
					if(adminService.authenticate(strAdminId,adminPassword))
					{
						System.out.println("Login Successful");
						int adminOption;
						char adminChoice='y';
						System.out.println("\n\t-----WELCOME ADMIN-----\nPlease select on option:\n");
						while(adminChoice=='y')
						{
							System.out.println("1. Add Hotel\n"
									+ "2. Delete Hotel\n"
									+ "3. Add Room\n"
									+ "4. Delete Room\n"
									+ "5. View List of Hotels\n"
									+ "6. View Bookings for a spcific hotel\n"
									+ "7. View Bookings of a specific date\n"
									+ "8. Back to Home Page\n"
									+ "9. Exit"
									+ "\nEnter choice (1-9) : ");
							adminOption = sc.nextInt();
							sc.nextLine();
							String strHotelId;
							String hotelName;
							String hotelCity;
							String hotelAddress;
							String hotelDescription;
							String strHotelAvgRatePerNight;
							String hotelPhone1;
							String hotelPhone2;
							String strHotelRating;
							String hotelEmail;
							String roomType;
							String strPerNightRate;
							String RoomNo;
							String strDate;
							switch(adminOption){
							case 1:
								System.out.println("Enter Hotel Name : ");
								hotelName=sc.nextLine();
								System.out.println("Enter City : ");
								hotelCity=sc.nextLine();
								System.out.println("Enter Hotel Address : ");
								hotelAddress=sc.nextLine();
								System.out.println("Enter Discription : ");
								hotelDescription=sc.nextLine();
								System.out.println("Enter Average Rate per night : ");
								strHotelAvgRatePerNight=sc.nextLine();
								System.out.println("Hotel Phone Number : ");
								hotelPhone1=sc.nextLine();
								System.out.println("Alternate Phone Number : ");
								hotelPhone2=sc.nextLine();
								System.out.println("Hotel Rating : ");
								strHotelRating=sc.nextLine();
								System.out.println("Hotel Email ID : ");
								hotelEmail=sc.nextLine();
								System.out.println(adminService.addHotel(hotelName, hotelCity, hotelAddress, hotelDescription, strHotelAvgRatePerNight, hotelPhone1, hotelPhone2, strHotelRating, hotelEmail));
								break;
								
							case 2:
								System.out.println("Enter Hotel ID : ");
								strHotelId = sc.nextLine();
								System.out.println(adminService.delHotel(strHotelId));
								sc.nextLine();
								break;
								
							case 3:
								System.out.println("Enter Hotel ID : ");
								strHotelId = sc.nextLine();
								System.out.println("Enter Room Number");
								RoomNo=sc.nextLine();
								System.out.println("Enter Room Type (Ac / NonAc) : ");
								roomType = sc.nextLine();
								System.out.println("Enter Rate per night : ");
								strPerNightRate = sc.nextLine();
								System.out.println(adminService.addRoom(strHotelId,RoomNo,roomType,strPerNightRate));
								break;
							case 4:
								System.out.println("Enter Hotel ID: ");
								strHotelId=sc.nextLine();
								System.out.println(adminService.delRoom(strHotelId));
								break;
							case 5:
								System.out.println("***List of Hotels***\n"+adminService.viewListOfHotels());
								break;
							case 6:
								System.out.println("Enter Hotel ID: ");
								strHotelId=sc.nextLine();
								if(adminService.viewBookingsByHotel(strHotelId).isEmpty())
								{
									System.out.println("No bookings found for given Hotel ID "+strHotelId);
								}
								else
								{
									System.out.println("Bookings for Hotel ID: "+strHotelId);
									System.out.println(adminService.viewBookingsByHotel(strHotelId));
								}
								break;
							case 7:
								System.out.println("Enter Date (yyyy-m-d) : ");
								strDate = sc.nextLine();
								if(adminService.viewBookingsByDate(strDate).isEmpty())
								{
									System.out.println("No Bookings founf for given Date "+strDate);
								}
								else
								{
									System.out.println("Bookings for Date "+strDate);
									System.out.println(adminService.viewBookingsByDate(strDate));
								}
								
								break;
							case 8:
								adminChoice='n';
								adminLoginChoice='n';
								break;
							case 9:
								adminChoice='n';
								adminLoginChoice='n';
								mainChoice='n';
								System.out.println("Thank you for using HBMS");
								break;
							default :
								System.out.println("\nInvalid Selection!..Select Again\n");
								break;
						}
					}
				}
				else
				{
					System.out.println("Invalid Login Credentials!..\n");
					System.out.println("\nPress 0 to Go back to home page"
							+ "\nPress any other digit to try again..."
							+ "\n\nSelect option");
					int tryLogin = sc.nextInt();
					sc.nextLine();
					if(tryLogin==0)
					{
						adminLoginChoice='n';
					}
				}
				}
				
				break;
			case 4:
				System.out.println("Registeration page coming soon...");
				break;
			case 5:
				System.out.println("Thank you");
				mainChoice='n';
				break;
			default:
				System.out.println("Invalid Selection!! Select Again\n");
				break;
			}
		}
		
	}

}
