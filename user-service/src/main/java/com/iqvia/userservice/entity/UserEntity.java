package com.iqvia.userservice.entity;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="full_name")
    @NotBlank(message = "please enter your full name")
    private String fullName;
    
    @Column(name="email")
    @NotBlank(message = "please enter your  email")
    private String email;
    
    @Column(name="password")
    @NotBlank(message = "please enter your password")
    @Size(min = 5,message = "at least your password should be 5 character , thank you.")
    private String password;
    
    @Column(name="date_of_birth")
    @NotNull(message = "please enter your Date of Birthday")
    private LocalDate dateOfBirth;

    
    @Column(name="mobile_no")
	@Size(max = 14)
	private String mobileNo;

}
