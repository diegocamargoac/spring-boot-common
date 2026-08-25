package com.spring.common.handler;

import com.spring.common.dto.ApiResponseDTO;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ApiResponseDTO<Object>> handleNotFound(
			NoSuchElementException exception
			) {
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(ApiResponseDTO.error("Resource not found: " + exception.getLocalizedMessage()));
	}
	
	
	
}
