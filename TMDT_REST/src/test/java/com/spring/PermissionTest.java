package com.spring;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.domain.Role;
import com.spring.repository.PermissionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionTest {
	@Autowired
	PermissionRepository permissionRepository;
	@Test
	public void testGetAllPermission() {
		assertEquals(2, permissionRepository.getAllPermission().size());
		Map<String, Role> map =permissionRepository.getAllPermission().get(0);
		for (Map.Entry<String, Role> iterable : map.entrySet()) {
			System.err.println(iterable.getKey().length());
			
		}
	}
}
