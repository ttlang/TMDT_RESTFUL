package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.CourseRegister;
import com.spring.service.CourseRegisterService;

@RestController
public class CourseRegisterController {
	@Autowired
	private CourseRegisterService courseRegisterService;

	@RequestMapping(value = "/course_register", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<List<CourseRegister>> getAllCourseRegister() {
		List<CourseRegister> result = courseRegisterService.getAllCourseRegister();
		if (result.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<CourseRegister>>(result, HttpStatus.OK);
		}
	}

}
