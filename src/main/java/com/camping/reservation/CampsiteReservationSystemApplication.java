package com.camping.reservation;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.camping.reservation.repository.AvailableDates;
import com.camping.reservation.repository.AvailableDatesRepository;

@SpringBootApplication
public class CampsiteReservationSystemApplication {
	
	@Autowired
	AvailableDatesRepository availableDatesRepository;

	public static void main(String[] args) {
		SpringApplication.run(CampsiteReservationSystemApplication.class, args);
	}
	
	@Bean
	
	void runner() {
		int daysBetween = (int) Duration.between(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusMonths(1L)).toDays();
		for(int i = 1; i <= daysBetween; i++){
			AvailableDates availableDate = new AvailableDates();
			availableDate.setAvailableDate(LocalDate.now().plusDays(i));
			availableDatesRepository.save(availableDate);
		}
	}

}
