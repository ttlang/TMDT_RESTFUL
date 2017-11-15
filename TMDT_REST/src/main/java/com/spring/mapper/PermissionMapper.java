package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.domain.Role;

@Mapper
public interface PermissionMapper {
	public List<Role>getPermissionByUserID(String userID);

}
