package com.camping.reservation.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AvailableDatesRepository extends JpaRepository<AvailableDates, String> {
	
	@Query(nativeQuery=true, value="SELECT id,available_date   FROM user_info right JOIN Available_dates  ON Available_date  "
			+ "between arrival_date and  Departure_date where uuid is null")
	Collection<AvailableDates> getAvailableDate();
	
}
