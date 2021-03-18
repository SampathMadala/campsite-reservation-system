package com.camping.reservation.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.camping.reservation.repository.AvailableDates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserInfo {
	
	
	private String uuid;
	@Id
	private String email;
	
	private String name;
	
	private LocalDate arrivalDate;
	
	private LocalDate departureDate;
	

}
