package com.spring.service;

import java.util.List;

import com.spring.domain.Lesson;

public interface LessonService {
	public List<Lesson>getAllLesson();
	public Lesson getLessonByLessonID(String lessonID);

}
