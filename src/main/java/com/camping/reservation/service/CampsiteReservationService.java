package com.camping.reservation.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camping.reservation.exception.BookingNotAvailableException;
import com.camping.reservation.exception.ResourceNotFoundException;
import com.camping.reservation.model.UserInfo;
import com.camping.reservation.repository.AvailableDates;
import com.camping.reservation.repository.AvailableDatesRepository;
import com.camping.reservation.repository.CampsiteRepository;

@Service
public class CampsiteReservationService {

	@Autowired
	CampsiteRepository campsiteRepository;
	
	@Autowired
	AvailableDatesRepository availableDatesRepository;

	public UserInfo saveBooking(UserInfo userInfo) {
		Period period = Period.between(userInfo.getArrivalDate(), userInfo.getDepartureDate());
		int days = period.getDays() +1;
		List<LocalDate> bookingDates = new ArrayList<>();
		bookingDates.add(userInfo.getArrivalDate());
		for(int i =1; i< days; i++) {
			bookingDates.add(userInfo.getArrivalDate().plusDays(i));
		}
		List<AvailableDates> availableDates = (List<AvailableDates>) availableDatesRepository.getAvailableDate();
		List<LocalDate>availableLocalDates = availableDates.stream().map(x -> x.getAvailableDate()).collect(Collectors.toList());
		boolean available = availableLocalDates.containsAll(bookingDates);
		
		if(!available) throw new BookingNotAvailableException("Booking Dates not available");		

		UserInfo user = campsiteRepository.save(userInfo);
		return user;
	}
	
	public UserInfo getUserBooking(String uuid) {
		Optional<UserInfo> getUser = campsiteRepository.findByUuid(uuid);
		if (getUser.isPresent()) {
			UserInfo user = getUser.get();
			return user;
		} else {
			throw new ResourceNotFoundException(uuid + " Doesn't exist in the database");
		}
	}

	public UserInfo updateBooking(UserInfo userInfo) {
		Optional<UserInfo> updateUser = campsiteRepository.findByUuid(userInfo.getUuid());
		if (updateUser.isPresent()) {
			UserInfo userUpdate = updateUser.get();
			userUpdate.setName(userInfo.getName());
			userUpdate.setArrivalDate(userInfo.getArrivalDate());
			userUpdate.setDepartureDate(userInfo.getDepartureDate());
			campsiteRepository.save(userUpdate);
			return userUpdate;
		} else {
			throw new ResourceNotFoundException(userInfo.getUuid() + " Doesn't exist in the database");
		}
	}
	
	public void deleteBooking(String uuid) {
		Optional<UserInfo> deleteUser = campsiteRepository.findByUuid(uuid);
		if(deleteUser.isPresent()) {
			campsiteRepository.deleteById(uuid);
		} else {
			throw new ResourceNotFoundException(uuid + " Doesn't exist in the database");
		}
	}

}
