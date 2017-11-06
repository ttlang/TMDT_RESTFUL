package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.domain.Lesson;

@Mapper
public interface LessonMapper {
	public List<Lesson>getAllLesson();
	public Lesson getLessonByLessonID(String lessonID);

}
