package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.Lesson;
import com.spring.service.LessonService;

@RestController
public class LessonController {
	@Autowired
	private LessonService lessonService;

	@GetMapping(value = "/lesson", produces = "application/json")
	public ResponseEntity<List<Lesson>> getAllLession() {
		List<Lesson> result = lessonService.getAllLesson();
		if (result.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Lesson>>(result, HttpStatus.OK);
		}
	}
}
