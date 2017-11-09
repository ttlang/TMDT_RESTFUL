package com.spring.repository.imp;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.WatchLater;
import com.spring.mapper.WatchLaterMapper;
import com.spring.repository.WatchLaterRepository;

@Repository
public class WatchLaterRepositoryImp implements WatchLaterRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(WatchLaterRepositoryImp.class);

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public List<WatchLater> getAllWatchLater() {
		SqlSession session = sqlSessionFactory.openSession();
		List<WatchLater> result = Collections.emptyList();
		try {
			WatchLaterMapper watchLaterMapper = session.getMapper(WatchLaterMapper.class);
			result = watchLaterMapper.getAllWatchLater();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

}
