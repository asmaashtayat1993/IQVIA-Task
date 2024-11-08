package com.iqvia.usermanagement.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.iqvia.usermanagement.dto.PageResponse;
import com.iqvia.usermanagement.dto.UserDTO;

@FeignClient(name = "user-service", url = "${user-service.url}")
public interface UserServiceFeignClient {
	@GetMapping("/get/{id}")
	UserDTO getUserById(@PathVariable("id") Long id);

	@PutMapping("/update/{id}")
	UserDTO updateUser(@PathVariable("id") Long id, @RequestBody UserDTO user);

	@DeleteMapping("/delete/{id}")
	void deleteUser(@PathVariable("id") Long id);

	 @GetMapping("/all")
	    ResponseEntity<PageResponse<UserDTO>> getAllUsers(
	        @RequestParam(value = "page", defaultValue = "0") int page,
	        @RequestParam(value = "size", defaultValue = "10") int size,
	        @RequestParam(value = "sortBy", defaultValue = "id") String sortBy
	    );
}
