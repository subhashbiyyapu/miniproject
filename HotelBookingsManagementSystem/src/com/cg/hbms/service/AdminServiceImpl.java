package com.cg.hbms.service;
import java.util.List;

import com.cg.hbms.dao.AdminDao;
import com.cg.hbms.dao.AdminDaoImpl;
import com.cg.hbms.dto.BookingDto;
import com.cg.hbms.dto.HotelDto;

public class AdminServiceImpl implements AdminService{

	AdminDao adminDao = new AdminDaoImpl();


	@Override
	public boolean authenticate(String strUserId, String password) {
		
		return adminDao.authenticate(strUserId,password);
	}


	@Override
	public String addHotel(String hotelName, String hotelCity, String hotelAddress, String hotelDescription,
			String strHotelAvgRatePerNight, String hotelPhone1, String hotelPhone2, String strHotelRating,
			String hotelEmail) {
		
		return adminDao.addHotel(hotelName, hotelCity, hotelAddress, hotelDescription, strHotelAvgRatePerNight, hotelPhone1, hotelPhone2, strHotelRating, hotelEmail);
	}


	@Override
	public String delHotel(String strHotelId) {
		return adminDao.delHotel(strHotelId);
	}


	@Override
	public String addRoom(String strHotelId, String RoomNo, String roomType, String strPerNightRate) {
		return adminDao.addRoom(strHotelId,RoomNo, roomType, strPerNightRate);
	}


	@Override
	public String delRoom(String strRoomId) {
		return adminDao.delHotel(strRoomId);
	}


	@Override
	public List<HotelDto> viewListOfHotels() {
		return adminDao.viewListOfHotels();
	}


	@Override
	public List<BookingDto> viewBookingsByHotel(String strHotelId) {
		return adminDao.viewBookingsByHotel(strHotelId);
	}


	@Override
	public List<BookingDto> viewBookingsByDate(String strDate) {
		return adminDao.viewBookingsByDate(strDate);
	}


	
	

}
