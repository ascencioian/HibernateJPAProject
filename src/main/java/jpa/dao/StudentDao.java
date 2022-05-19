package jpa.dao;

import java.util.List;

import jpa.entitymodels.Student;

public interface StudentDao {
	
	List<Student> getAllStudents();

	Student getStudentByEmail(String studentEmail);

	void validateStudent();

	void registerStudentToCourse();

	void getStudentCourses();
}
