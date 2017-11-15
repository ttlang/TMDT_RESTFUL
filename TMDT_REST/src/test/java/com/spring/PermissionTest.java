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

import com.spring.domain.Role;
import com.spring.repository.PermissionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PermissionTest.class);

	@Autowired
	PermissionRepository permissionRepository;

	@Test
	public void testGetAllPermission() {
		List<Role> result = permissionRepository.getPermissionByUserID("ND002");
		assertEquals(1, result.size());
		LOGGER.info(result.get(0).toString());
		

	}
}
