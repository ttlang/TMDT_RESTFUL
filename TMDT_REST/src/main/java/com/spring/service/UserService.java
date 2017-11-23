package com.spring.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.spring.domain.User;

public interface UserService {
	public List<User> getAllUser();

	public User getUserByUserID(String userID);

	public User getUserByEmail(String email);

	public boolean saveUser(User user);

	public boolean checkEmailExist(String email);

	public boolean checkIDUserExist(String userID);

	/**
	 * register user
	 * 
	 * @param user
	 * @return number of user saved
	 */
	public int register(User user);

	/**
	 * Change the user status from 0 to 1 If the status is not zero, the status
	 * remains the same
	 * 
	 * @param userId
	 * @return number of records change
	 */
	public int changeStatusRegister(String userId);

	/**
	 * create password reset token (userID + date time)
	 * 
	 * @param userID
	 * @param offsetDateTime
	 * @return encrypt String
	 */
	public String createPasswordResetToken(String userID, LocalDateTime offsetDateTime);
	/**
	 * decrypt reset password token  
	 * @param encrypt
	 * @return Map
	 */
	public Map<String, Object> decryptPasswordResetToken(String encrypt);
	
	public boolean sendEmailResetPassword(String email);
	/**
	 * change user's password
	 * @param userID 
	 * @param newPassword
	 * @return number of record changed
	 */
	public int changePassWord(String userID,String newPassword);

}
