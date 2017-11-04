package com.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseTest.class);

	@Autowired
	 private CourseRepository courseRepository;
	@Test
	public void testGetAllCourse() {
		assertEquals(1, courseRepository.getAllCourse().size());
		LOGGER.info(courseRepository.getAllCourse().get(0).getAuthor().getUserName());
		System.err.println(courseRepository.getAllCourse().get(0).toString());
	}
}
