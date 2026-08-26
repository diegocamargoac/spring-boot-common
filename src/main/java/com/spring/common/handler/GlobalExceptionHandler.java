package com.spring.common.handler;

import com.spring.common.dto.ApiResponseDTO;

import jakarta.servlet.http.HttpServletRequest;

import java.util.NoSuchElementException;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ApiResponseDTO<Object>> handleNotFound(
			NoSuchElementException exception
			) {
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND) // Error 404
				.body(ApiResponseDTO.error("Resource not found: " + exception.getLocalizedMessage(), "/path"));
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ApiResponseDTO<Object>> missingServletRequestParameterExceptionHable(
			MissingServletRequestParameterException exception,
			HttpServletRequest request
			) {
		
		String requestPath = "[" + request.getMethod() + "]" + request.getRequestURI();
		
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST) // Error 400
				.body(ApiResponseDTO.error(exception.getLocalizedMessage(), requestPath));
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ApiResponseDTO<Object>> methodArgumentTypeMismatchException(
			MethodArgumentTypeMismatchException exception,
			HttpServletRequest request
			) {
		
		String requestPath = "[" + request.getMethod() + "]" + request.getRequestURI();
		
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST) // Error 400
				.body(ApiResponseDTO.error(exception.getLocalizedMessage(), requestPath));
	}

	@ExceptionHandler(InvalidDataAccessApiUsageException.class)
	public ResponseEntity<ApiResponseDTO<Object>> invalidDataAccessApiUsageException(
		MethodArgumentTypeMismatchException exception,
		HttpServletRequest request
		) {
	
	String requestPath = "[" + request.getMethod() + "]" + request.getRequestURI();
	
	return ResponseEntity
			.status(HttpStatus.INTERNAL_SERVER_ERROR) // Error 500
			.body(ApiResponseDTO.error(exception.getLocalizedMessage(), requestPath));
	}
	
}
