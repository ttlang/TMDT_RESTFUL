package com.spring.repository;

import java.util.List;

import com.spring.domain.User;

public interface UserRepository {
	public List<User> getAllUser();
	public User getUserByUserID(String userID);

}
