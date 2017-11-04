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
import com.spring.mapper.RoleMapper;
import com.spring.repository.RoleRepository;
@Repository
public class RoleRepositoryImp implements RoleRepository{

	private static final Logger LOGGER = LoggerFactory.getLogger(CourseRepositoryImp.class);

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Override
	public List<Role> getAllRole() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Role>listOfRole = Collections.emptyList();
		try {
			RoleMapper roleMapper  = sqlSession.getMapper(RoleMapper.class);
			listOfRole  = roleMapper.getAllRole();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}finally {
			sqlSession.close();
		}
		return listOfRole;
	}

}
