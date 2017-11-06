package com.spring.repository.imp;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.Lesson;
import com.spring.mapper.LessonMapper;
import com.spring.repository.LessonRepository;

@Repository
public class LessonRepositoryImp implements LessonRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(LessonRepositoryImp.class);
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public List<Lesson> getAllLesson() {
		SqlSession session = sqlSessionFactory.openSession();
		List<Lesson> result = Collections.emptyList();
		try {
			LessonMapper lessionMapper = session.getMapper(LessonMapper.class);
			result = lessionMapper.getAllLesson();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public Lesson getLessonByLessonID(String lessonID) {
		SqlSession session = sqlSessionFactory.openSession();
		Lesson result = null;
		try {
			LessonMapper lessionMapper = session.getMapper(LessonMapper.class);
			result = lessionMapper.getLessonByLessonID(lessonID);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

}
