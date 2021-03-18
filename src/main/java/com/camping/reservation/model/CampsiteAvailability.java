package com.camping.reservation.model;

import java.time.LocalDate;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampsiteAvailability {
	
	private LocalDate fromDate;
	
	private LocalDate toDate;

	
	
	

}
