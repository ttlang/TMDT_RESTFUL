package com.spring.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.spring.domain.Role;

@Mapper
public interface PermissionMapper {
	public List<Map<String, Role>> getAllPermission();

}
