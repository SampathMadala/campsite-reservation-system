package com.camping.reservation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camping.reservation.exception.ResourceNotFoundException;
import com.camping.reservation.model.UserInfo;
import com.camping.reservation.repository.CampsiteRepository;

@Service
public class CampsiteReservationService {

	@Autowired
	CampsiteRepository campsiteRepository;

	public UserInfo saveBooking(UserInfo userInfo) {
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
