package com.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.repository.CourseTypeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseTypeTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseTypeTest.class);

	@Autowired
	CourseTypeRepository courseTypeRepository;
	@Test
	public void testGetAllCourseType() {
		assertEquals(2, courseTypeRepository.getAllCourseType().size());
	}
	@Test
	public void testGetCourseTypeByID() {
		LOGGER.info(courseTypeRepository.getCourseTypeByID("CO").toString());
	}
}
