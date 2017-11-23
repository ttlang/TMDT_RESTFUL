package com.spring.service.imp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.mail.internet.InternetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.spring.domain.User;
import com.spring.repository.UserRepository;
import com.spring.service.AES;
import com.spring.service.MailService;
import com.spring.service.UserService;

@Service
public class UserServiceImp implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImp.class);

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AES aes;
	@Autowired
	private MailService mailService;
	@Value("${email.from}")
	private String sendFrom;
	@Value("${front_end.scheme}")
	private String scheme;
	@Value("${front_end.server_name}")
	private String serverName;

	@Value("${front_end.server_port}")
	private String serverPort;

	@Override
	public List<User> getAllUser() {
		return userRepository.getAllUser();
	}

	@Override
	public User getUserByUserID(String userID) {
		return userRepository.getUserByUserID(userID);
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	}

	@Override
	public boolean saveUser(User user) {
		int n = userRepository.saveUser(user);
		return n > 0;
	}

	@Override
	public boolean checkEmailExist(String email) {
		return userRepository.checkEmailExist(email);
	}

	@Override
	public int register(User user) {
		int result = userRepository.saveUser(user);
		String userID = null;
		if (result > 0) {
			userID = userRepository.getUserByEmail(user.getEmail()).getUserID();
			String userIDEncrypt = aes.encrypt(userID);
			Collection<InternetAddress> to = new ArrayList<>();
			Map<String, Object> map = new HashMap<>();
			try {
				String linkRegister = this.scheme + "://" + this.serverName + ":" + this.serverPort
						+ "/account/register?key=" + userIDEncrypt;
				map.put("linkRegister", linkRegister);
				to.add(new InternetAddress(user.getEmail()));
				mailService.sendMail(to, "Hoàn tất đăng kí 3TPL", "/mail_template/register.html", map, "logo.png");
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}

		}

		return result;
	}

	@Override
	public boolean checkIDUserExist(String userID) {
		return this.getUserByUserID(userID) != null;
	}

	@Override
	public int changeStatusRegister(String userId) {
		return this.userRepository.changeStatusRegister(userId);
	}

	@Override
	public String createPasswordResetToken(String userID, LocalDateTime offsetDateTime) {
		String userIdEncrypt = this.aes.encrypt(userID);
		String[] dateSplit = offsetDateTime.toString().split("T");
		String date = this.aes.encrypt(dateSplit[0]);
		String time = this.aes.encrypt(dateSplit[1]);
		return userIdEncrypt + "_" + date + "_" + time;
	}

	@Override
	public Map<String, Object> decryptPasswordResetToken(String encrypt) {
		StringTokenizer stringTokenizer = new StringTokenizer(encrypt, "_");
		String userId = null;
		String dateCreateToken = null;
		String timeCreateToken = null;
		while (stringTokenizer.hasMoreTokens()) {
			userId = this.aes.decrypt(stringTokenizer.nextToken());
			dateCreateToken = this.aes.decrypt(stringTokenizer.nextToken());
			timeCreateToken = this.aes.decrypt(stringTokenizer.nextToken());

		}
		LocalDateTime localDateTime = LocalDateTime.parse(dateCreateToken + "T" + timeCreateToken);
		Map<String, Object> result = new HashMap<>();
		result.put("userId", userId);
		result.put("dateTimeCreateToken", localDateTime);
		return result;
	}

	@Override
	public boolean sendEmailResetPassword(String email) {
		User user = this.userRepository.getUserByEmail(email);
		if (user != null) {
			String userID = user.getUserID();
			try {
				String token = this.createPasswordResetToken(userID, LocalDateTime.now());
				Collection<InternetAddress> to = new ArrayList<>();
				Map<String, Object> map = new HashMap<>();
				try {
					String linkResetPassword = this.scheme + "://" + this.serverName + ":" + this.serverPort
							+ "/user/password_reset?key=" + token;
					map.put("linkResetPassword", linkResetPassword);
					to.add(new InternetAddress(user.getEmail()));
					mailService.sendMail(to, "Thay đổi mật khẩu 3TPL", "/mail_template/reset_password.html", map,
							"logo.png");
				} catch (Exception e) {
					LOGGER.error(e.getMessage());
					return false;
				}
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				return false;

			}
		}
		LOGGER.error(user.toString());
		return true;

	}

	@Override
	public int changePassWord(String userID, String newPassword) {
		return this.userRepository.changePassWord(userID, newPassword);
	}

}
