package com.spring.mapper;
/**
 * Mapper cho table người dùng
 * @author ttlang
 *
 */

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.domain.User;

@Mapper
public interface UserMapper {
	public List<User> getAllUser();

	public User getUserByUserID(String userID);

	public User getUserByEmail(@Param("email") String email);

	public boolean checkEmailExist(@Param("email") String email);

	public void saveUser(Map<String, Object> param);

	public void changeStatusRegister(Map<String, Object> param);
	
	public void changeUserPassword(Map<String , Object>param);

}
