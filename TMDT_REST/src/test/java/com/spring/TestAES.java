package com.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.service.AES;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAES {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestAES.class);

	@Autowired
	AES aes;

	@Test
	public void testAES() {
		String original = "truongtamlang";
		String encode = aes.encrypt(original);
		String decode = aes.decrypt(encode);
		LOGGER.info(encode);
		LOGGER.info(decode);
		
	}
	
	@Test
	public void testDecode() {
		System.err.println(aes.decrypt("fT5uv20/N+27IRchgttNAQ"));
	}

}
