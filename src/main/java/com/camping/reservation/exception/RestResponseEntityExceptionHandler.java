package com.camping.reservation.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	ResponseEntity<ErrorDataResponseDto> handleResourceNotFoundException(ResourceNotFoundException ex) {
		List<ErrorDto> errorsDto = new ArrayList<>();
		ErrorDto errorDto = new ErrorDto();
		errorDto.setCode("EX777");
		errorDto.setMessage(ex.getMessage());
		errorsDto.add(errorDto);
		ErrorDataResponseDto errorDataResponseDto = new ErrorDataResponseDto();
		errorDataResponseDto.setErrors(errorsDto);
		return new ResponseEntity(errorDataResponseDto, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(BookingNotAvailableException.class)
	ResponseEntity<ErrorDataResponseDto> handleBookingNotAvailableException(BookingNotAvailableException ex) {
		List<ErrorDto> errorsDto = new ArrayList<>();
		ErrorDto errorDto = new ErrorDto();
		errorDto.setCode("EX888");
		errorDto.setMessage(ex.getMessage());
		errorsDto.add(errorDto);
		ErrorDataResponseDto errorDataResponseDto = new ErrorDataResponseDto();
		errorDataResponseDto.setErrors(errorsDto);
		return new ResponseEntity(errorDataResponseDto, HttpStatus.CONFLICT);
		
	}
	

}
