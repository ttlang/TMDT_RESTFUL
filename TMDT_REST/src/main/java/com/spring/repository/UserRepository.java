package com.spring.repository;

import java.util.List;

import com.spring.domain.User;

public interface UserRepository {
	public List<User> getAllUser();
	public User getUserByUserID(String userID);
	public int createUser(User user);
	public User getUserByEmail(String email);
	public boolean checkEmailExist(String email);
	public int saveUser(User user);
	public int changeStatusRegister(String userId);
	public int changePassWord(String userID,String newPassword);

}
