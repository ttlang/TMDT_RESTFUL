package com.spring.domain;
/**
 * <p>Domain class cho table DANG_KI_XEM_SAU</p>
 * @author ttlang
 *
 */
public class WatchLater {
		private User user;
		private Course course;
		public WatchLater(User user, Course course) {
			super();
			this.user = user;
			this.course = course;
		}
		
		public WatchLater() {
			super();
		}
		
		

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
		}

		@Override
		public String toString() {
			return "WatchLater [user=" + user + ", course=" + course + "]";
		}
		
	
}
