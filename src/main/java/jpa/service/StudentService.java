package jpa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import jpa.dao.StudentDao;


public class StudentService implements StudentDao {

	public void getAllStudents() {
		// TODO Auto-generated method stub
		
	}

	public void getStudentByEmail() {
		// TODO Auto-generated method stub
		
	}

	public void validateStudent() {
		// TODO Auto-generated method stub
		//Only students with the right credentials can log in. Otherwise, a message is displayed stating: “Wrong Credentials”. 
		//Valid students are able to see the courses they are registered for.
		//Valid students are able to register for any course in the system as long as they are not already registered.
		
	}

	public void registerStudentToCourse() {
		// TODO Auto-generated method stub
		
	}

	public void getStudentCourses() {
		// TODO Auto-generated method stub
		
	}

}
