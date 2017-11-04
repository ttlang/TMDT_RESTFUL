package com.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.repository.TopicRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TopicTest.class);

	@Autowired
	TopicRepository topicRepository;
	@Test
	public void testGetAllTopic() {
		assertEquals(1, topicRepository.getAllTopic().get(1).getListOfCourse().size());
		LOGGER.info(topicRepository.getAllTopic().get(1).getTopicDescription());
	}
}
