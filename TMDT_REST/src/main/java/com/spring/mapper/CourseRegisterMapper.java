package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.domain.CourseRegister;

@Mapper
public interface CourseRegisterMapper {
	public List<CourseRegister>getAllCourseRegister();

}
