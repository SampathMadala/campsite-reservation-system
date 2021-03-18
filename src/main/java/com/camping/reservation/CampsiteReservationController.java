package com.camping.reservation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.camping.reservation.model.UserInfo;
import com.camping.reservation.repository.AvailableDates;
import com.camping.reservation.repository.AvailableDatesRepository;
import com.camping.reservation.service.CampsiteReservationService;

@RestController
public class CampsiteReservationController {
	
	@Autowired
	CampsiteReservationService campsiteReservationService;
	
	@Autowired
	AvailableDatesRepository availableDatesRepository;
	
	@GetMapping(value="/v1/campsite")
	public ResponseEntity<List<AvailableDates>> getAvailableDates() {  
		List<AvailableDates> availabelDates = (List<AvailableDates>) availableDatesRepository.getAvailableDate();
		return new ResponseEntity<>(availabelDates,HttpStatus.ACCEPTED);
	}

	
	@GetMapping(value="/v1/campsite/{uuid}")
	public ResponseEntity<UserInfo> getUserReservation(@PathVariable String uuid) {
		UserInfo userinfo = campsiteReservationService.getUserBooking(uuid);
		return new ResponseEntity<>(userinfo,HttpStatus.OK);
	}
	
	@PostMapping(value="/v1/campsite")
	public ResponseEntity<UserInfo> saveUserReservation(@RequestBody UserInfo userInfo) {
		userInfo.setUuid(UUID.randomUUID().toString());
		UserInfo userinfo = campsiteReservationService.saveBooking(userInfo);
		return new ResponseEntity<>(userinfo,HttpStatus.OK);
	}
	
	@PutMapping(value="/v1/campsite")
	public ResponseEntity<UserInfo> updateUserReservation(@RequestBody UserInfo userInfo) {
		UserInfo userinfo = campsiteReservationService.updateBooking(userInfo);
		return new ResponseEntity<>(userinfo,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/v1/campsite/{uuid}")
	public ResponseEntity<UserInfo> deleteUserReservation(@PathVariable String uuid) {
		 campsiteReservationService.deleteBooking(uuid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
