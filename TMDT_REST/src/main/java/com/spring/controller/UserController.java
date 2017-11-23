package com.spring.controller;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsondoc.core.annotation.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.config.api.ApiError;
import com.spring.config.security.JwtTokenUtil;
import com.spring.domain.User;
import com.spring.domain.custom.UserCustom;
import com.spring.service.AES;
import com.spring.service.UserService;

@RestController
@Api(name = "UserRest", description = "Thông tin người dùng")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private AES aes;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	@Value("${jwt.header}")
	private String tokenHeader;

	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> listUsers = userService.getAllUser();
		if (listUsers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<User>>(listUsers, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/user/{userID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserByID(@PathVariable("userID") String userID) {
		User user = userService.getUserByUserID(userID);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUser(@RequestBody UserCustom userCustom) {
		boolean resultOfCreate = userService.saveUser(userCustom.converToUserCustom());
		if (resultOfCreate) {

			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/user/register_status", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> enableUserRegister(@RequestParam("key") String key) {
		LOGGER.info(key);
		String userIDDecrypt = aes.decrypt(key);
		LOGGER.info(userIDDecrypt);
		if (!userService.checkIDUserExist(userIDDecrypt)) {
			ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, "confirmation URL does not exist",
					"cant find userID from URL");
			return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
		}
		// get old use's status
		User user = userService.getUserByUserID(userIDDecrypt);
		Integer oldStatus = user.getStatus();
		// update user's status
		int numberOfRow = this.userService.changeStatusRegister(userIDDecrypt);
		// get new user's status before updated
		User user2 = userService.getUserByUserID(userIDDecrypt);
		Integer newStatus = user2.getStatus();
		if (oldStatus != newStatus && numberOfRow > 0) {
			String msg = "{\"Message\":\"Account activation is successful\"}";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else {
			String msg = "{\"Message\":\"account has been activated before\"}";
			return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);
		}
	}

	@RequestMapping(value = "/user/token_reset_password", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getResetPasswordToken(@RequestParam("email") String email) {
		String msg = null;
		if (!this.userService.checkEmailExist(email)) {
			msg = "{\"Message\":\"email not exist\"}";
			return new ResponseEntity<Object>(msg, HttpStatus.NOT_FOUND);
		}
		try {
			this.userService.sendEmailResetPassword(email);
			msg = "{\"Message\":\"tooken has been sent\"}";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return new ResponseEntity<Object>(msg, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/password_reset", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> resetPassword(@RequestParam("new_password") String newPassword,
			@RequestParam("key") String key) {
		String msg = null;
		Map<String, Object> decryptKey = Collections.emptyMap();
		try {
			decryptKey = this.userService.decryptPasswordResetToken(key);

			String userID = (String) decryptKey.get("userId");
			// time send mail
			LocalDateTime dateTime = (LocalDateTime) decryptKey.get("dateTimeCreateToken");
			// time from sent mail and 15 minutes
			LocalDateTime newDateTime = dateTime.plusMinutes(15);
			if (LocalDateTime.now().isBefore(newDateTime)) {
				// change password
				this.userService.changePassWord(userID, this.passwordEncoder.encode(newPassword));
				msg = "{\"Message\":\" change password succeed \"}";
				return new ResponseEntity<Object>(msg, HttpStatus.OK);
			} else {
				// key has expired
				msg = "{\"Message\":\"key has expired \"}";
				return new ResponseEntity<Object>(msg, HttpStatus.FORBIDDEN);
			}
			// String dateCreateKey = decryptKey.get("dateTimeCreateToken").toString();
		} catch (Exception e) {
			e.printStackTrace();
			msg = "{\"Message\":\"reset key is invalid \"}";
			return new ResponseEntity<Object>(msg, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/user/password", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> changePassword(@RequestParam("old_password") String oldPassword,
			@RequestParam("new_password") String newPassword, HttpServletRequest request) {
		String requestHeader = request.getHeader(this.tokenHeader);
		String tooken = requestHeader.substring(7);
		String emailInToken = jwtTokenUtil.getUsernameFromToken(tooken);
		String msg = null;
		User user = null;
		try {
			user = userService.getUserByEmail(emailInToken);
			if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
				msg = "{\"Message\":\"password not match \"}";
				return new ResponseEntity<Object>(msg, HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		this.userService.changePassWord(user.getUserID(), passwordEncoder.encode(newPassword));
		msg = "{\"Message\":\"change password succeed\"}";
		return new ResponseEntity<Object>(msg, HttpStatus.OK);

	}
}
