package jpa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

class StudentCourseServiceTest {

	@Before
	public void setUpBeforeClass() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Session session2 = factory.openSession();
		Transaction t = session.beginTransaction();   
		
		//create test course and insert into database
		Course testCourse = new Course();
		testCourse.setcId(1000);
		testCourse.setcName("testCourse");
		testCourse.setcInstructorName("Test Instructor");
		session.save(testCourse); 
		t.commit();
    	
		//create test student and insert into database
		Transaction x = session.beginTransaction();
		Student testStudent = new Student();

		testStudent.setsName("test user");
		testStudent.setsEmail("testuser@email.com");
		testStudent.setsPass("12345678");
		session.save(testStudent); 
		x.commit();
		
		//add course to student	
		//create the course object  
		//create course list
  	  	List<Course> coursesBeingTaken = testStudent.getsCourses(); 
    	//insert the course object 
    	  coursesBeingTaken.add(testCourse);
    	 //set attribute
    	  testStudent.setsCourses(coursesBeingTaken);
    	  
    	 session2.merge(testStudent);
    	 session2.getTransaction().commit(); 

		System.out.println("successfully saved testUser");   
        factory.close();  
        session.close();   
	}
	


	@After
	public void tearDownAfterClass() throws Exception {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		//delete test student
		Transaction tx = session.beginTransaction();
		Student testStudent = new Student();
		testStudent.setsEmail("testuser@email.com");
		testStudent.setsName("test user");
		testStudent.setsPass("12345678");
	    session.delete(testStudent);
	    tx.commit();
	    session.close();
	    factory.close();
	    

	}

	@Test
	@Disabled
	public void testGetAllStudentCourses() {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		
		Student testStudent = (Student) session.get(Student.class,new String("testuser@email.com"));
		 
		 session.close();
		 factory.close();
		
		//FIRST CREATE CLASS OBJECT
		StudentCourseService studentCourseService = new StudentCourseService();
		
		//call the method you want to test
		//Assert
		assertEquals(testStudent.getsCourses(), studentCourseService.getAllStudentCourses("testuser@email.com"));
		


	}

}
