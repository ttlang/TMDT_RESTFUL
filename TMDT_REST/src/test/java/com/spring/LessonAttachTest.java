package com.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.repository.LessonAttachRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LessonAttachTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LessonAttachTest.class);

	@Autowired
	LessonAttachRepository lessonAttachRepository;
	
	@Test
	public void testGetAllLessonAttach() {
		assertEquals(1, lessonAttachRepository.getAllLesonAttach().size());
	}
	
	@Test
	public void testGetLessonAttachByID() {
		LOGGER.info(lessonAttachRepository.getLesonAttachByID("AT001").toString());
	}
}
