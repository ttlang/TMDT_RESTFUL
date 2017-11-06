package com.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.repository.UserRepository;
import com.spring.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserTest.class);

	@Test
	public void testGetAllNguoiDung() {
		assertEquals(1, userRepository.getAllUser().size());
		LOGGER.info(userRepository.getAllUser().get(0).toString());
	}

	@Test
	public void getUserByUserID() {
		LOGGER.info(userRepository.getUserByUserID("ND001").getRegistrationDate().toString());
	}

	@Test
	public void testGetUser() {
	}
}
