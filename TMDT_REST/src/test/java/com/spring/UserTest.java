package com.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.config.security.JwtTokenUtil;
import com.spring.domain.User;
import com.spring.repository.UserRepository;
import com.spring.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;
	@Autowired
	JwtTokenUtil jwt;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	HttpServletRequest h;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserTest.class);

	@Test
	public void testGetAllNguoiDung() {
		assertEquals(7, userRepository.getAllUser().size());
		LOGGER.info(userRepository.getAllUser().get(0).toString());
	}

	@Test
	public void getUserByUserID() {
		User user = userRepository.getUserByUserID("ND001");
		assertEquals(2, user.getPermission().size());
		LOGGER.info(userRepository.getUserByUserID("ND001").getRegistrationDate().toString());

	}

	@Test
	public void testGetUserByEmail() {
		LOGGER.info(userRepository.getUserByEmail("lang.tt16@gmail.com").toString());

	}

	@Test
	public void testRole() {

		// User user = userRepository.getUserByUserID("ND001");
		try {

			String name = jwt.getUsernameFromToken(
					"BearereyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsYW5nLnR0MTZAZ21haWwuY29tIiwiYXVkIjoid2ViIiwiZXhwIjoxNTExMzQxMDQyLCJpYXQiOjE1MTA3MzYyNDJ9.OYV20lw_P4EjaDE8ia0110D0NSWgYfhAjWI4asUIUXCRHUW_Ekw9A8DxpnnWmC7rbjk_8nJ99tM-6PzN8cRCqQ");
			LOGGER.info(name);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

	}

	@Test
	public void testCheckUserExist() {
		boolean result = userRepository.checkEmailExist("lang.tt16@gmail.com");
		boolean result2 = userRepository.checkEmailExist("lang@gmail.com");
		assertTrue(result);
		assertFalse(result2);
	}

	@Test
	public void testSaveUser() {
		User user = new User("Nguyễn Tấn Phát", "ttlang162@gmail.com",
				"https://drive.google.com/open?id=0B27mfRY62YKZRDNxWWZHdl9aUjA", "1234", "Đồng Tháp", "123456789");
		int userID = userRepository.saveUser(user);
		LOGGER.info(String.valueOf(userID));
	}

	@Test
	public void getURL() {
		String linkRegister = h.getScheme() + "://" + h.getServerName() + ":" + h.getServerPort()
				+ "/account/register?id=";
		LOGGER.info(linkRegister);
	}

	@Test
	public void testRegister() {
		User user = new User("Nguyễn Tấn Phát", "lang.tt16@gmail.com",
				"https://drive.google.com/open?id=0B27mfRY62YKZRDNxWWZHdl9aUjA", "1234", "Đồng Tháp", "123456789");
		userService.register(user);
		
	}
	
	@Test
	public void testChangeStatus() {
//		assertEquals(1, userRepository.changeStatusRegister("ND33"));
		assertEquals(1, userService.changeStatusRegister("ND33"));
	}
	@Test
	public void testCreateResetPasswordToken() {
		assertTrue(this.userService.sendEmailResetPassword("lang.tt16@gmail.com"));
	}
	@Test
	public void testChangePassword() {
		String password = this.passwordEncoder.encode("12345");
		assertEquals(1, this.userService.changePassWord("ND33", password));
	}
	
}
