package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;

public interface StudentCourseServiceDao {

	List<Course> getAllStudentCourses(String studentEmail);
}
