package com.spring.repository.imp;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.LessonAttach;
import com.spring.mapper.LessonAttachMapper;
import com.spring.repository.LessonAttachRepository;

@Repository
public class LessonAttachRepositoryImp implements LessonAttachRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(LessonAttachRepositoryImp.class);

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public List<LessonAttach> getAllLesonAttach() {
		SqlSession session = sqlSessionFactory.openSession();
		List<LessonAttach> result = Collections.emptyList();
		try {
			LessonAttachMapper lessonAttachMapper = session.getMapper(LessonAttachMapper.class);
			result = lessonAttachMapper.getAllLesonAttach();

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public LessonAttach getLesonAttachByID(String lessonAttachID) {
		SqlSession session = sqlSessionFactory.openSession();
		LessonAttach result = null;
		try {
			LessonAttachMapper lessonAttachMapper = session.getMapper(LessonAttachMapper.class);
			result = lessonAttachMapper.getLesonAttachByID(lessonAttachID);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}
}
