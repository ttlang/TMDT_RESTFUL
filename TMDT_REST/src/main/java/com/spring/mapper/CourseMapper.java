package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.domain.Course;

@Mapper
public interface CourseMapper {
	public List<Course>getAllCourse();
	
	

}
