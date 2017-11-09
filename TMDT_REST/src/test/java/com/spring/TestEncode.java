package com.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEncode {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestEncode.class);

	@Autowired
	PasswordEncoder passwordEncoder;
	@Test
	public void testEncodePassworld() {
		LOGGER.info(passwordEncoder.encode("1234"));
		String a = passwordEncoder.encode("1234");
		assertEquals(true, passwordEncoder.matches("1234", a));
	}
	

}
