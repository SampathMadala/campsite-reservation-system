package com.camping.reservation.exception;

public class BookingNotAvailableException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BookingNotAvailableException(String message) {
		super(message);
	}
	
	public BookingNotAvailableException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
