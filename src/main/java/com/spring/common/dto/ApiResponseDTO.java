package com.spring.common.dto;

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
	
	private T data;

	public static <T> ApiResponseDTO<T> success(String message, T data) {
		return new ApiResponseDTO<>(true, message, LocalDateTime.now(), data);
	}
	
	public static <T> ApiResponseDTO<T> error(String message) {
		return new ApiResponseDTO<T>(false, message, LocalDateTime.now(), null);
	}
	
}
