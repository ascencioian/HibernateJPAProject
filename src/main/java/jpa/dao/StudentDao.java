package jpa.dao;

public interface StudentDao {
	
	void getAllStudents();

	void getStudentByEmail();

	void validateStudent();

	void registerStudentToCourse();

	void getStudentCourses();
}
