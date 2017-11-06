package com.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.repository.PermissionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionTest {
	@Autowired
	PermissionRepository permissionRepository;
	@Test
	public void testGetAllPermission() {
		assertEquals(2, permissionRepository.getAllPermission().size());
		
	}
}
