package com.spring.common.handler;

import com.spring.common.dto.ApiResponseDTO;

import jakarta.servlet.http.HttpServletRequest;

import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ApiResponseDTO<Object>> noSuchElementExceptionHandle(
			NoSuchElementException exception,
			HttpServletRequest request
			) {
		String requestPath = "[" + request.getMethod() + "]" + request.getRequestURI();
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND) // 404
				.body(ApiResponseDTO.error(exception.getLocalizedMessage(), requestPath));
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ApiResponseDTO<Object>> missingServletRequestParameterExceptionHable(
			MissingServletRequestParameterException exception,
			HttpServletRequest request
			) {
		
		String requestPath = "[" + request.getMethod() + "]" + request.getRequestURI();
		
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST) // 400
				.body(ApiResponseDTO.error(exception.getLocalizedMessage(), requestPath));
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ApiResponseDTO<Object>> methodArgumentTypeMismatchException(
			MethodArgumentTypeMismatchException exception,
			HttpServletRequest request
			) {
		
		String requestPath = "[" + request.getMethod() + "]" + request.getRequestURI();
		
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST) // 400
				.body(ApiResponseDTO.error(exception.getLocalizedMessage(), requestPath));
	}

	@ExceptionHandler(InvalidDataAccessApiUsageException.class)
	public ResponseEntity<ApiResponseDTO<Object>> invalidDataAccessApiUsageException(
		MethodArgumentTypeMismatchException exception,
		HttpServletRequest request
		) {
	
	String requestPath = "[" + request.getMethod() + "]" + request.getRequestURI();
	
	return ResponseEntity
			.status(HttpStatus.INTERNAL_SERVER_ERROR) // 500
			.body(ApiResponseDTO.error(exception.getLocalizedMessage(), requestPath));
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ApiResponseDTO<Object>> illegalArgumentExceptionHandle(
			IllegalArgumentException exception,
			HttpServletRequest request
			) {
		String requestPath = "[" + request.getMethod() + "]" + request.getRequestURI();

		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR) // 500
				.body(ApiResponseDTO.error(exception.getLocalizedMessage(), requestPath));
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ApiResponseDTO<Object>> httpMessageNotReadableExceptionHandle(
			HttpMessageNotReadableException exception,
			HttpServletRequest request
			) {
		String requestPath = "[" + request.getMethod() + "]" + request.getRequestURI();

		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST) // 400
				.body(ApiResponseDTO.error(exception.getLocalizedMessage(), requestPath));
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ApiResponseDTO<Object>> dataIntegrityViolationExceptionHandle(
			DataIntegrityViolationException exception,
			HttpServletRequest request
			) {
		String requestPath = "[" + request.getMethod() + "]" + request.getRequestURI();
		
		return ResponseEntity				
				.status(HttpStatus.BAD_REQUEST) // 500
				.body(ApiResponseDTO.error(exception.getLocalizedMessage(), requestPath));
	}
	
}
