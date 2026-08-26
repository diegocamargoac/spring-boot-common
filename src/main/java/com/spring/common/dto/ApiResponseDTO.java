package com.spring.common.dto;

import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponseDTO<T> {

	private Boolean success;
	
	private String message;
	
	private LocalDateTime timestamp;
	
	private String path;
	
	private T data;

	public static <T> ApiResponseDTO<T> success(
			String message,
			T data,
			HttpServletRequest request
			) {
		String requestPath = "[" + request.getMethod() + "]" + request.getRequestURI();
		return new ApiResponseDTO<>(true, message, LocalDateTime.now(), requestPath, data);
	}
	
	public static <T> ApiResponseDTO<T> error(String message,
			String path
			) {
		return new ApiResponseDTO<T>(false, message, LocalDateTime.now(), path, null);
	}
	
}
