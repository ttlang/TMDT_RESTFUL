package com.spring.repository;

import java.util.List;

import com.spring.domain.Topic;

public interface TopicRepository {
	public List<Topic>getAllTopic();
	public Topic getTopicBytopicID(String topicID);

}
