package com.spring.domain;
/**
 * <p>Domain class cho table DANG_KY_KHOA_HOC</p>
 * @author ttlang
 *
 */

import java.time.OffsetDateTime;

public class CourseRegister {
	private Course course;
	private User userRegister;
	private OffsetDateTime registerDate;

	public CourseRegister(Course course, User userRegister, OffsetDateTime registerDate) {
		super();
		this.course = course;
		this.userRegister = userRegister;
		this.registerDate = registerDate;
	}
	public CourseRegister() {
	}
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getUserRegister() {
		return userRegister;
	}

	public void setUserRegister(User userRegister) {
		this.userRegister = userRegister;
	}

	public OffsetDateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(OffsetDateTime registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "CourseRegister [course=" + course + ", userRegister=" + userRegister + ", registerDate=" + registerDate
				+ "]";
	}

}
