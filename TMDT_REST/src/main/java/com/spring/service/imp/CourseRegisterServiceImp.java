package com.spring.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.CourseRegister;
import com.spring.repository.CourseRegisterRepository;
import com.spring.service.CourseRegisterService;

@Service
public class CourseRegisterServiceImp implements CourseRegisterService {
	@Autowired
	private CourseRegisterRepository courseRegisterRepository;

	@Override
	public List<CourseRegister> getAllCourseRegister() {
		return courseRegisterRepository.getAllCourseRegister();
	}
}
