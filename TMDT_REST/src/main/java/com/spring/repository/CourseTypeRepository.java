package com.spring.repository;

import java.util.List;

import com.spring.domain.CourseType;

public interface CourseTypeRepository {
	public List<CourseType>getAllCourseType();
	public CourseType getCourseTypeByID(String courseID);
}
