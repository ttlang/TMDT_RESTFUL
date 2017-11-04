package com.spring.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.Topic;
import com.spring.repository.TopicRepository;
import com.spring.service.TopicService;

@Service
public class TopicServiceImp implements TopicService {
	@Autowired
	private TopicRepository topicRepository;

	@Override
	public List<Topic> getAllTopic() {
		return topicRepository.getAllTopic();
	}
	
	@Override
	public Topic getTopicBytopicID(String topicID) {
		return topicRepository.getTopicBytopicID(topicID);
	}
}
