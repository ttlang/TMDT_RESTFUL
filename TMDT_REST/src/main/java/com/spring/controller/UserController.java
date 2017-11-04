package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.User;
import com.spring.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(value = "/user", produces = "application/json")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> listUsers = userService.getAllUser();
		if (listUsers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<User>>(listUsers, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/user/{userID}", produces = "application/json")
	public ResponseEntity<User> getUserByID(@PathVariable("userID") String userID) {
		User user = userService.getUserByUserID(userID);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}		
	}

}
