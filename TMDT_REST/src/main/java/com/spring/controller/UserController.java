package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.User;
import com.spring.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "/user", produces = "application/json", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> listUsers = userService.getAllUser();
		if (listUsers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<User>>(listUsers, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/user/{userID}", produces = "application/json",method = RequestMethod.GET)
	public ResponseEntity<User> getUserByID(@PathVariable("userID") String userID) {
		User user = userService.getUserByUserID(userID);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

}
