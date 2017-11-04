package com.spring.service;

import java.util.List;

import com.spring.domain.Topic;

public interface TopicService {
	public List<Topic>getAllTopic();
	public Topic getTopicBytopicID(String topicID);

}
