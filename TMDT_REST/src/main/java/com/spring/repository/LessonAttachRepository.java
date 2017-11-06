package com.spring.repository;

import java.util.List;

import com.spring.domain.LessonAttach;

public interface LessonAttachRepository {
	public List<LessonAttach>getAllLesonAttach();
	public LessonAttach getLesonAttachByID(String lessonAttachID);
}
