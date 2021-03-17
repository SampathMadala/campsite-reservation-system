package com.camping.reservation.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampsiteAvailability {
	
	private String fromDate;
	
	private String toDate;

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	

}
