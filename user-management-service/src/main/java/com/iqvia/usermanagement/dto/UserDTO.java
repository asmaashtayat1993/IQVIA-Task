package com.iqvia.usermanagement.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
	    private Long id;
	    private String fullName;
	    private String email;
	    private String password;
	    private LocalDate dateOfBirth;
		private String mobileNo;

}
