package com.spring.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.User;
import com.spring.repository.UserRepository;
import com.spring.service.UserService;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUser() {
		return userRepository.getAllUser();
	}

	@Override
	public User getUserByUserID(String userID) {
		return userRepository.getUserByUserID(userID);
	}
}
