package com.spring.repository.imp;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.Role;
import com.spring.mapper.PermissionMapper;
import com.spring.repository.PermissionRepository;

@Repository
public class PermissionRepositoryImp implements PermissionRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseRepositoryImp.class);

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public List<Map<String, Role>> getAllPermission() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Map<String, Role>> listOfPermission = Collections.emptyList();
		try {
			PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
			listOfPermission = permissionMapper.getAllPermission();

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			sqlSession.close();
		}
		return listOfPermission;
	}

}
