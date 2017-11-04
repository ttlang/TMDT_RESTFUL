package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.domain.CourseType;

@Mapper
public interface CourseTypeMapper {
	public List<CourseType>getAllCourseType();
	public CourseType getCourseTypeByID(String courseID);

}
