package com.iqvia.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.iqvia.userservice.entity.UserEntity;
import com.iqvia.userservice.exception.UserNotFoundException;
import com.iqvia.userservice.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public ResponseEntity<UserEntity> createUser(UserEntity user) {
		UserEntity savedUser = userRepository.save(user);
		log.info("user created successfully:");
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	public UserEntity getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User  with id: " + id + " not found"));

	}
	
	public Page<UserEntity> getAllUsers(int page, int size, String sortBy) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		return userRepository.findAll(pageable);
	}

	@Transactional
    public UserEntity updateUser(Long id, UserEntity user) {
        UserEntity existingUser = getUserById(id);

        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setDateOfBirth(user.getDateOfBirth());
        existingUser.setMobileNo(user.getMobileNo());

        return userRepository.save(existingUser);
    }
	
	
	public void deleteUser(Long id) {
        UserEntity existingUser =getUserById(id);
        userRepository.delete(existingUser);
    }
}