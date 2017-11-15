package com.spring.service;

import java.util.List;

import com.spring.domain.User;

public interface UserService {
	public List<User>getAllUser();
	public User getUserByUserID(String userID);
	public User getUserByEmail(String email);
}
