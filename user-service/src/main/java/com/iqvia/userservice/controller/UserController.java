package com.iqvia.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iqvia.userservice.entity.UserEntity;
import com.iqvia.userservice.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<UserEntity> createCustomer(@Valid @RequestBody UserEntity customer) {
		ResponseEntity<UserEntity> user = userService.createUser(customer);
		return new ResponseEntity<>(user.getBody(), HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id) {
		UserEntity user = userService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Page<UserEntity>> getAllUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "sortBy", defaultValue = "id") String sortBy) {
		Page<UserEntity> users = userService.getAllUsers(page, size, sortBy);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable("id") Long id, @Valid @RequestBody UserEntity user) {
		UserEntity updatedUser = userService.updateUser(id, user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<>("Deleted Successfully",HttpStatus.NO_CONTENT);
	}
}
