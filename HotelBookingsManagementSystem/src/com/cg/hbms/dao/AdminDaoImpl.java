package com.cg.hbms.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.cg.hbms.dto.BookingDto;
import com.cg.hbms.dto.HotelDto;
import com.cg.hbms.dto.RoomDto;
import com.cg.hbms.dto.UserDto;

public class AdminDaoImpl implements AdminDao{

	private static Integer hotelId = 103;
	private static Integer roomId= 1007;
	
	@Override
	public boolean authenticate(String strUserId, String password) {
		Integer userId = Integer.parseInt(strUserId);
		for (Entry<Integer, UserDto> user : StaticDb.getUserData().entrySet())  
            if(user.getKey().equals(userId) && user.getValue().getPassword().equals(password))
            {
            	return true;
            }
		return false;
	}
	@Override
	public String addHotel(String hotelName, String hotelCity, String hotelAddress, String hotelDescription,
			String strHotelAvgRatePerNight, String hotelPhone1, String hotelPhone2, String strHotelRating,
			String hotelEmail) {
		HotelDto hotel = new HotelDto();
		hotel.setHotelId(hotelId++);
		hotel.setHotelName(hotelName);
		hotel.setHotelCity(hotelCity);
		hotel.setHotelAddress(hotelAddress);
		hotel.setHotelDescription(hotelDescription);
		Double hotelAvgRatePerNight = Double.parseDouble(strHotelAvgRatePerNight);
		hotel.setHotelAvgRatePerNight(hotelAvgRatePerNight);
		hotel.setHotelPhone1(hotelPhone1);
		hotel.setHotelPhone2(hotelPhone2);
		Double hotelRating = Double.parseDouble(strHotelRating);
		hotel.setHotelRating(hotelRating);
		hotel.setHotelEmail(hotelEmail);
		StaticDb.getHotelData().put(hotel.getHotelId(),hotel);
		return "New Hotel Added [ Hotel ID : "+hotel.getHotelId()+" ]\n";
	}

	@Override
	public String delHotel(String strHotelId) {
		Integer hotelId = Integer.parseInt(strHotelId);
		if(StaticDb.getHotelData().containsKey(hotelId))
		{
			StaticDb.getHotelData().remove(hotelId);
			Iterator<Integer> it = StaticDb.getRoomData().keySet().iterator();
			List<Integer> rooms = new ArrayList<Integer>();
			while (it.hasNext()) {
				Integer roomIdKey = it.next();
				if (StaticDb.getRoomData().get(roomIdKey).getHotelId().equals(hotelId)) {
					rooms.add(StaticDb.getRoomData().get(roomIdKey).getRoomId());
					it.remove();
				}
			}
			return "Hotel Deleted [ Rooms belonging to hotel ID: "+hotelId+" also deleted ]\n"
					+ "Rooms Deleted "+rooms;
		}
			return "Hotel with given Id does not exist!!..";
	}
	@Override
	public String addRoom(String strHotelId,String RoomNo, String roomType, String strPerNightRate) {
		RoomDto room = new RoomDto();
		Integer hotelId = Integer.parseInt(strHotelId);
		room.setHotelId(hotelId);
		room.setRoomId(roomId++);
		room.setRoomNo(RoomNo);
		room.setRoomType(roomType);
		Double perNightRate = Double.parseDouble(strPerNightRate);
		room.setPerNightRate(perNightRate);
		StaticDb.getRoomData().put(room.getRoomId(),room);
		return "New Room added [ Hotel ID: "+room.getHotelId()+" ... Room ID: "+room.getRoomId()+" ]";
	}
	@Override
	public String delRoom(String strRoomId) {
		Integer roomId=Integer.parseInt(strRoomId);
		if(StaticDb.getRoomData().containsKey(roomId))
		{
			StaticDb.getRoomData().remove(roomId);
			return "Room Deleted [ Room ID: "+roomId+" ]";
		}
		return "Room with given ID does not exist";
	}
	@Override
	public List<HotelDto> viewListOfHotels() {
		List<HotelDto> listOfHotels = new ArrayList<HotelDto>(StaticDb.getHotelData().values());
		return listOfHotels;
	}
	@Override
	public List<BookingDto> viewBookingsByHotel(String strHotelId) {
		Integer hotelId = Integer.parseInt(strHotelId);
		List<BookingDto> bookingsByHotel = new ArrayList<BookingDto>();
		for (Entry<Integer, BookingDto> booking : StaticDb.getBookingData().entrySet())  
		{
			if(hotelId.equals(booking.getValue().getHotelId()))
				{
				bookingsByHotel.add(booking.getValue());
				}
		}
		return bookingsByHotel;
	}
	@Override
	public List<BookingDto> viewBookingsByDate(String strDate) {
		LocalDate date = LocalDate.parse(strDate);
		List<BookingDto> bookingsByDate = new ArrayList<BookingDto>();
		for (Entry<Integer, BookingDto> booking : StaticDb.getBookingData().entrySet())  
		{
			if((date.isEqual(booking.getValue().getBookedFrom()) || date.isAfter(booking.getValue().getBookedFrom())) && (date.isEqual(booking.getValue().getBookedTo()) || date.isBefore(booking.getValue().getBookedTo())))
			{
				bookingsByDate.add(booking.getValue());
			}
		}
		return bookingsByDate;
	}




	

}
