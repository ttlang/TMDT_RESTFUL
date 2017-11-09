package com.spring;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.domain.CourseRegister;
import com.spring.repository.CourseRegisterRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRegisterTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseRegisterTest.class);

	@Autowired
	CourseRegisterRepository courseRegisterRepository;
	@Test
	public void testGetAllRegisterRepository() {
		List<CourseRegister>result =courseRegisterRepository.getAllCourseRegister();
		assertEquals(2, result.size());
		LOGGER.info(result.get(0).toString());
	}
}
