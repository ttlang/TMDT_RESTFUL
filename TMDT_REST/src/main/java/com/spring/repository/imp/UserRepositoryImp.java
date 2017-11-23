package com.spring.repository.imp;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.spring.domain.User;
import com.spring.mapper.UserMapper;
import com.spring.repository.UserRepository;

@Repository
public class UserRepositoryImp implements UserRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryImp.class);
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<User> getAllUser() {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> listOfUser = Collections.emptyList();
		try {
			listOfUser = userMapper.getAllUser();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return listOfUser;
	}

	@Override
	public User getUserByUserID(String userID) {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User result = null;
		try {
			result = userMapper.getUserByUserID(userID);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public User getUserByEmail(String email) {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User result = null;
		try {
			result = userMapper.getUserByEmail(email);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int createUser(User user) {
		return 0;
	}

	@Override
	public boolean checkEmailExist(String email) {
		SqlSession session = sqlSessionFactory.openSession();
		boolean result = false;
		try {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			result = userMapper.checkEmailExist(email);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int saveUser(User user) {
		SqlSession session = sqlSessionFactory.openSession();
		int numberOfRow = 0;
		try {
			Map<String, Object> param = new HashMap<>();
			param.put("userName", user.getUserName());
			param.put("registrationDate", OffsetDateTime.now());
			param.put("email", user.getEmail());
			param.put("avatar", user.getAvatar());
			param.put("password", passwordEncoder.encode(user.getPassword().toString()));
			param.put("address", user.getAddress());
			param.put("phoneNumber", user.getPhoneNumber());
			param.put("result", 0);
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.saveUser(param);
			numberOfRow = (int) param.get("result");

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return numberOfRow;
	}

	@Override
	public int changeStatusRegister(String userId) {

		SqlSession session = sqlSessionFactory.openSession();
		int numberOfRow = 0;
		try {
			Map<String, Object> param = new HashMap<>();
			param.put("userID", userId);
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.changeStatusRegister(param);
			numberOfRow = (int) param.get("result");

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return numberOfRow;
	}
	@Override
	public int changePassWord(String userID, String newPassword) {
		SqlSession session = sqlSessionFactory.openSession();
		int numberOfRow = 0;
		try {
			Map<String, Object> param = new HashMap<>();
			param.put("userID", userID);
			param.put("newPassword",newPassword);
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.changeUserPassword(param);
			numberOfRow = (int) param.get("result");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {
			session.close();
		}
		return numberOfRow;
	}
}
