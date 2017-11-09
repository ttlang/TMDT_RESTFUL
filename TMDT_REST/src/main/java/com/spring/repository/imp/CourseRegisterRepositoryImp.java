package com.spring.repository.imp;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.CourseRegister;
import com.spring.mapper.CourseRegisterMapper;
import com.spring.repository.CourseRegisterRepository;

@Repository
public class CourseRegisterRepositoryImp implements CourseRegisterRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(CourseRegisterRepositoryImp.class);

	@Autowired
	private SqlSessionFactory sessionFactory;

	@Override
	public List<CourseRegister> getAllCourseRegister() {
		SqlSession session = sessionFactory.openSession();
		List<CourseRegister> result = Collections.emptyList();
		try {
			CourseRegisterMapper courseRegisterMapper = session.getMapper(CourseRegisterMapper.class);
			result = courseRegisterMapper.getAllCourseRegister();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

}
