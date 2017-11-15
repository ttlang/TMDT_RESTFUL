package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.Topic;
import com.spring.service.TopicService;

@RestController
public class TopicController {
	@Autowired
	private TopicService topicService;

	@RequestMapping(value = "/topic", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<List<Topic>> getAllTopic() {
		List<Topic> listOfTopic = topicService.getAllTopic();
		if (listOfTopic.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Topic>>(listOfTopic, HttpStatus.OK);
	}

	@RequestMapping(value = "/topic/{topicID}", produces = "application/json")
	public ResponseEntity<Topic> getOneTopic(@PathVariable("topicID") String topicID) {
		Topic t = topicService.getTopicBytopicID(topicID);
		if (t == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Topic>(t, HttpStatus.OK);
		}

	}

}
