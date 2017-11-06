package com.spring.repository.imp;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.Chapter;
import com.spring.mapper.ChapterMapper;
import com.spring.repository.ChapterRepository;

@Repository
public class ChapterRepositoryImp implements ChapterRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChapterRepositoryImp.class);

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public List<Chapter> getAllChapter() {
		SqlSession session = sqlSessionFactory.openSession();
		List<Chapter> result = Collections.emptyList();
		try {
			ChapterMapper chapterMapper = session.getMapper(ChapterMapper.class);
			result = chapterMapper.getAllChapter();

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public Chapter getChapterByChapterID(String chapterID) {
		SqlSession session = sqlSessionFactory.openSession();
		Chapter result = null;
		try {
			ChapterMapper chapterMapper = session.getMapper(ChapterMapper.class);
			result = chapterMapper.getChapterByChapterID(chapterID);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}
}
