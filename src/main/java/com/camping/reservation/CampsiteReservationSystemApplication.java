package com.camping.reservation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CampsiteReservationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampsiteReservationSystemApplication.class, args);
	}
	
	@Bean
	
	void runner() {
		System.out.println("test");
		//return null;
	}

}
