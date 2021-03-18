package com.camping.reservation.exception;


import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDataResponseDto {
	
	private List<ErrorDto> errors;

}
