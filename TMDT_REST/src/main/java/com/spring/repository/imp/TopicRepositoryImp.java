package com.spring.repository.imp;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.Topic;
import com.spring.mapper.TopicMapper;
import com.spring.repository.TopicRepository;

@Repository
public class TopicRepositoryImp implements TopicRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(TopicRepositoryImp.class);
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public List<Topic> getAllTopic() {
		SqlSession session = sqlSessionFactory.openSession();
		List<Topic> topics = Collections.emptyList();
		try {
			TopicMapper topicMapper = session.getMapper(TopicMapper.class);
			topics = topicMapper.getAllTopic();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return topics;
	}

	@Override
	public Topic getTopicBytopicID(String topicID) {
		SqlSession session = sqlSessionFactory.openSession();
		Topic topics = new Topic();
		try {
			TopicMapper topicMapper = session.getMapper(TopicMapper.class);
			topics = topicMapper.getTopicBytopicID(topicID);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return topics;
	}

}
