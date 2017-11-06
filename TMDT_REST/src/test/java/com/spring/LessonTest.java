package com.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.repository.LessonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LessonTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LessonTest.class);

	@Autowired
	LessonRepository lessonRepository;
	@Test
	public void testGetAllLession() {
		assertEquals(6, lessonRepository.getAllLesson().size());
		LOGGER.info(lessonRepository.getAllLesson().get(0).toString());
	}
	@Test
	public void getLessonByID() {
		LOGGER.info(lessonRepository.getLessonByLessonID("BH001").toString());
	}
}
