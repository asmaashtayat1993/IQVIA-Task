package com.iqvia.usermanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	private int status;
	private String message;
	public ErrorResponse ( String message) {
		this.message=message;
	}

}