package com.iqvia.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.iqvia.usermanagement.dto.PageResponse;
import com.iqvia.usermanagement.dto.UserDTO;
import com.iqvia.usermanagement.exception.UserNotFoundException;
import com.iqvia.usermanagement.feignclient.UserServiceFeignClient;

@Service
public class UserManagementService {
	@Autowired
	private UserServiceFeignClient userServiceFeignClient;

	public UserDTO getUserById(Long id) {
			UserDTO existingUser = userServiceFeignClient.getUserById(id);
			if (existingUser == null) {
				throw new UserNotFoundException("User with id: " + id + " not found");
			}
			return existingUser;
	}

	 public PageResponse<UserDTO> getAllUsers(int page, int size, String sortBy) {
	        ResponseEntity<PageResponse<UserDTO>> response = userServiceFeignClient.getAllUsers(page, size, sortBy);	        
	        return response.getBody(); 
	    }
	public UserDTO updateUser(Long id, UserDTO user) {

		UserDTO existingUser = getUserById(id);

		if (existingUser == null) {
			throw new UserNotFoundException("User with id: " + id + " not found");
		}

		if (user.getFullName() != null) {
			existingUser.setFullName(user.getFullName());
		}
		if (user.getEmail() != null) {
			existingUser.setEmail(user.getEmail());
		}
		if (user.getPassword() != null) {
			existingUser.setPassword(user.getPassword());
		}
		if (user.getDateOfBirth() != null) {
			existingUser.setDateOfBirth(user.getDateOfBirth());
		}
		if (user.getMobileNo() != null) {
			existingUser.setMobileNo(user.getMobileNo());
		}

		return userServiceFeignClient.updateUser(id, existingUser);
	}

	public void deleteUser(Long id) {
		
		UserDTO existingUser = getUserById(id);
		if(existingUser !=null) {
		userServiceFeignClient.deleteUser(id);
		}
	}
}
