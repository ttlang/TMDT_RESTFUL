package com.spring.mapper;

import java.util.List;

import com.spring.domain.LessonAttach;

public interface LessonAttachMapper {
	public List<LessonAttach>getAllLesonAttach();
	public LessonAttach getLesonAttachByID(String lessonAttachID);
}
