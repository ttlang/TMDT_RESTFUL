package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.Course;
import com.spring.service.CourseService;

@RestController
public class CoureController {
	@Autowired
	private CourseService courseService;

	@GetMapping(value = "/course", produces = "application/json")
	public ResponseEntity<List<Course>> getAllCourse() {
		List<Course> result = courseService.getAllCourse();
		if (result.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Course>>(result, HttpStatus.OK);
		}
	}
}
