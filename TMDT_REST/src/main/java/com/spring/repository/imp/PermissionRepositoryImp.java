package com.spring.repository.imp;

import java.util.Collections;
import java.util.List;

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
	public List<Role> getPermissionByUserID(String userID) {
		SqlSession session = sqlSessionFactory.openSession();
		List<Role> result = Collections.emptyList();
		try {
			PermissionMapper permissionMapper = session.getMapper(PermissionMapper.class);
			result = permissionMapper.getPermissionByUserID(userID);

		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

}
