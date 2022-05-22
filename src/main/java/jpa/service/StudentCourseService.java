package jpa.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.dao.StudentCourseServiceDao;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentCourseService implements StudentCourseServiceDao {

	//return all student courses
	public List<Course> getAllStudentCourses(String studentEmail) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
    	//Create student object using session.get()
          Student student = (Student) session.get(Student.class,new String(studentEmail));
          //create course list
    	  List<Course> coursesBeingTaken = student.getsCourses();
    	  
    	  factory.close();
    	  session.close();
    	
		//return all courses of a particular student
		return coursesBeingTaken;
	}

}
