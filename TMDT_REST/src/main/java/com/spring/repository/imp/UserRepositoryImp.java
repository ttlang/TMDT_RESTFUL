package com.spring.repository.imp;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.User;
import com.spring.mapper.UserMapper;
import com.spring.repository.UserRepository;

@Repository
public class UserRepositoryImp implements UserRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(TopicRepositoryImp.class);
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

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

}
