package com.camping.reservation;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.camping.reservation.model.CampsiteAvailability;
import com.camping.reservation.model.UserInfo;
import com.camping.reservation.service.CampsiteReservationService;

@RestController
public class CampsiteReservationController {
	
	@Autowired
	CampsiteReservationService campsiteReservationService;
	
	@GetMapping(value="/v1/slotsavailable")
	public ResponseEntity<CampsiteAvailability> getTimiings() {
		CampsiteAvailability campsiteAvailability = new CampsiteAvailability();
		campsiteAvailability.setFromDate( LocalDate.now().plusDays(1).toString());
		campsiteAvailability.setToDate(LocalDate.now().plusMonths(1L).toString()); // try to keep date
		return new ResponseEntity<>(campsiteAvailability,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping(value="/v1/slotsavailable/{uuid}")
	public ResponseEntity<UserInfo> getUserReservation(@PathVariable String uuid) {
		UserInfo userinfo = campsiteReservationService.getUserBooking(uuid);
		return new ResponseEntity<>(userinfo,HttpStatus.OK);
	}
	
	@PostMapping(value="/v1/slotsavailable")
	public ResponseEntity<UserInfo> saveUserReservation(@RequestBody UserInfo userInfo) {
		userInfo.setUuid(UUID.randomUUID().toString());
		UserInfo userinfo = campsiteReservationService.saveBooking(userInfo);
		return new ResponseEntity<>(userinfo,HttpStatus.OK);
	}
	
	@PutMapping(value="/v1/slotsavailable")
	public ResponseEntity<UserInfo> updateUserReservation(@RequestBody UserInfo userInfo) {
		UserInfo userinfo = campsiteReservationService.updateBooking(userInfo);
		return new ResponseEntity<>(userinfo,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/v1/slotsavailable/{uuid}")
	public ResponseEntity<UserInfo> deleteUserReservation(@PathVariable String uuid) {
		 campsiteReservationService.deleteBooking(uuid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
