package com.spring.repository.imp;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.Course;
import com.spring.mapper.CourseMapper;
import com.spring.repository.CourseRepository;
@Repository
public class CourseRepositoryImp implements CourseRepository {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseRepositoryImp.class);

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Override
	public List<Course> getAllCourse() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Course>listOfCourse = Collections.emptyList();
		try {
			CourseMapper courseMapper  = sqlSession.getMapper(CourseMapper.class);
			listOfCourse = courseMapper.getAllCourse();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}finally {
			sqlSession.close();
		}
		return listOfCourse;
	}
}
