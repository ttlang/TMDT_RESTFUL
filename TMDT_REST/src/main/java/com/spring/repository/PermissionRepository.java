package com.spring.repository;

import java.util.List;
import java.util.Map;

import com.spring.domain.Role;

public interface PermissionRepository {
	public List<Map<String, Role>> getAllPermission();

}
