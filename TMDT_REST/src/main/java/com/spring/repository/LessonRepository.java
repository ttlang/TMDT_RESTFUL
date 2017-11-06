package com.spring.repository;

import java.util.List;

import com.spring.domain.Lesson;

public interface LessonRepository {
	public List<Lesson>getAllLesson();
	public Lesson getLessonByLessonID(String lessonID);

}
