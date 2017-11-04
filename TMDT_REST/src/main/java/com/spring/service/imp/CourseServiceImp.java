package com.spring.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.Course;
import com.spring.repository.CourseRepository;
import com.spring.service.CourseService;

@Service
public class CourseServiceImp implements CourseService{
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<Course> getAllCourse() {
		return courseRepository.getAllCourse();
	}

}
