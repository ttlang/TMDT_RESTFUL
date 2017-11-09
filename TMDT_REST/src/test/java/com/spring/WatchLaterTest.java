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

import com.spring.domain.WatchLater;
import com.spring.repository.WatchLaterRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WatchLaterTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WatchLaterTest.class);

	@Autowired
	WatchLaterRepository watchLaterRepository;

	@Test
	public void testGetAllWatchLater() {
		List<WatchLater>result = watchLaterRepository.getAllWatchLater();
		assertEquals(2, result.size());
		LOGGER.info(result.get(0).toString());
	}

}	
