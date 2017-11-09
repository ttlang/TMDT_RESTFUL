package com.spring.mapper;
/**
 * Mapper cho table người dùng
 * @author ttlang
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.domain.User;
@Mapper
public interface UserMapper {
	public List<User>getAllUser();
	public User getUserByUserID(String userID);
	public User getUserByEmail (String email);

}
