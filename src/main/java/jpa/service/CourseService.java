package jpa.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.dao.CourseDao;
import jpa.entitymodels.Course;

public class CourseService implements CourseDao {

	// This method takes no parameter and returns every Course in the table.
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		TypedQuery query = session.getNamedQuery("Select_All_Courses");

		List<Course> courses = query.getResultList();

		for (Course o : courses) {
			System.out.println("Course instructor : " + o.getcInstructorName() + " | course name: " + o.getcName());
		}

		factory.close();
		session.close();
		return courses;
	}

	// gets a course by Id
	public Course GetCourseById(int courseId) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Course course = (Course) session.get(Course.class, new Integer(courseId));

		return course;
	}

}
