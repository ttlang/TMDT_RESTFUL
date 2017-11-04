package com.spring.repository.imp;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.CourseType;
import com.spring.mapper.CourseTypeMapper;
import com.spring.repository.CourseTypeRepository;

@Repository
public class CourseTypeRepositoryImp implements CourseTypeRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseRepositoryImp.class);
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public List<CourseType> getAllCourseType() {
		SqlSession session = sqlSessionFactory.openSession();
		List<CourseType> listOfCourseType = Collections.emptyList();
		try {
			CourseTypeMapper courseTypeMapper = session.getMapper(CourseTypeMapper.class);
			listOfCourseType = courseTypeMapper.getAllCourseType();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return listOfCourseType;
	}

	@Override
	public CourseType getCourseTypeByID(String courseID) {
		SqlSession session = sqlSessionFactory.openSession();
		CourseType courseType = new CourseType();
		try {
			CourseTypeMapper courseTypeMapper = session.getMapper(CourseTypeMapper.class);
			courseType = courseTypeMapper.getCourseTypeByID(courseID);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return courseType;
	}

}
