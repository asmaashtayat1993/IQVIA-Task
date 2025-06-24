package com.iqvia.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iqvia.usermanagement.dto.PageResponse;
import com.iqvia.usermanagement.dto.UserDTO;
import com.iqvia.usermanagement.service.UserManagementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/managment/users")
public class UserManagmentController {

	//Majd
	@Autowired
	private UserManagementService userManagementService;

	@GetMapping("/get/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id) {
		UserDTO user = userManagementService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long id, @Valid @RequestBody UserDTO customer) {
		UserDTO updatedUser = userManagementService.updateUser(id, customer);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
		userManagementService.deleteUser(id);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<PageResponse<UserDTO>> getAllUsers(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "sortBy", defaultValue = "id") String sortBy) {

		PageResponse<UserDTO> users = userManagementService.getAllUsers(page, size, sortBy);

		if (users.getContent().isEmpty()) {
			return ResponseEntity.ok(users);
		}
		return ResponseEntity.ok(users);
	}
}
