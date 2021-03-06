package jpa.service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.dao.StudentDao;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService implements StudentDao {

	// ---------------------------------show all of the students from the
	// database--------------------
	// This method reads the student table in your database and returns the data as
	// a List<Student>
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		TypedQuery query = session.getNamedQuery("Select_All_Courses");

		List<Student> students = query.getResultList();

		factory.close();
		session.close();

		return students;
	}

	// ---------------------------------Return a single student--------------------
	// This method takes a Student’s email as a String and parses the student list
	// for a Student with that email and returns a Student Object.
	public Student getStudentByEmail(String studentEmail) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// Create Employee object using session.get()
		Student student = (Student) session.get(Student.class, new String(studentEmail));

		factory.close();
		session.close();

		return student;
	}

	// ---------------------------------Validate Credentials--------------------
	// This method takes two parameters: the first one is the user email and the
	// second one is the password from the user input. Return whether or not a
	// student was found.
	public boolean validateStudent(String studentEmail, String studentPassword) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// Create Employee object using session.get()
		Student student = (Student) session.get(Student.class, new String(studentEmail));

		String validPassword = student.getsPass();

		if (studentPassword.equalsIgnoreCase(validPassword)) {

			factory.close();
			session.close();

			return true;
		} else {

			factory.close();
			session.close();
		}

		return false;
	}

	// ---------------------------------registering a course to a
	// student--------------------
	// After a successful student validation, this method takes a Student’s email
	// and a Course ID.
	// It checks in the join table (i.e. Student_Course) generated by JPA to find if
	// a Student with that Email is currently attending a Course with that ID.
	// If the Student is not attending that Course, register the student for that
	// course; otherwise not.
	public void registerStudentToCourse(String studentEmail, int courseId) {
		// TODO Auto-generated method stub

		boolean temp = false;

		// open session factory
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session2 = factory.openSession();

		Transaction tx = session2.beginTransaction();

		// Create student object using session.get()
		Student student = (Student) session2.get(Student.class, new String(studentEmail));

		// create course list
		List<Course> coursesBeingTaken = student.getsCourses();

		if (coursesBeingTaken.isEmpty()) {
			// add to course
			// create the course object
			Course course = (Course) session2.get(Course.class, new Integer(courseId));

			// insert the course object
			coursesBeingTaken.add(course);

			// set attribute
			student.setsCourses(coursesBeingTaken);

			session2.merge(student);
			session2.getTransaction().commit();
		}

		if (coursesBeingTaken.size() >= 1) {
			// compare each course in the course list
			Iterator<Course> itr = coursesBeingTaken.iterator();
			for (Course u : coursesBeingTaken) {
				int id = u.getcId();
				if (id == courseId) {
					System.out.println("course already being taken");
					temp = true;
				}
			}

			if (temp == false) {

				// create the course object
				Course course = (Course) session2.get(Course.class, new Integer(courseId));

				// insert the course object
				coursesBeingTaken.add(course);

				// set attribute
				student.setsCourses(coursesBeingTaken);

				session2.merge(student);
				session2.getTransaction().commit();
			}

		}
		// reset booleanSwitch
		temp = false;

		factory.close();
		session2.close();

	}

	// ----------------------------------------gets the courses the student is
	// registered to-------------------------------------------------
	// This method takes a Student’s Email as a parameter and would find all the
	// courses a student is registered for.
	// should this pull the students course attribute or reference studentCourse
	// table
	public List<Course> getStudentCourses(String studentEmail) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// Create Employee object using session.get()
		Student student = (Student) session.get(Student.class, new String(studentEmail));

		List<Course> studentClassList = student.getsCourses();

		// how are you going to get student courses of a student?
		// being provided an email
		// generate that object from database
		// return its course attribute

		factory.close();
		session.close();

		return studentClassList;
	}

}
