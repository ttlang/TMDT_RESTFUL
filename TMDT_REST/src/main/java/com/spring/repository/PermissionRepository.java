package com.spring.repository;

import java.util.List;

import com.spring.domain.Role;

public interface PermissionRepository {
	public List<Role>getPermissionByUserID(String userID);
	

}
