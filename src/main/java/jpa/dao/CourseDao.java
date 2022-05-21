package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;

public interface CourseDao {
	List<Course> getAllCourses();
	
	Course GetCourseById(int courseId);
}
