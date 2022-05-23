/*
 * Filename: SMSRunner.java
* Author: Stefanski
* 02/25/2020 
 */
package jpa.mainrunner;

import static java.lang.System.out;

import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import jpa.service.CourseService;
import jpa.service.StudentCourseService;
import jpa.service.StudentService;

/**
 * 1
 * 
 * @author Harry
 *
 */
public class SMSRunner {

	private Scanner sin;
	private StringBuilder sb;

	private CourseService courseService;
	private StudentService studentService;
	private Student currentStudent;

	public SMSRunner() {
		sin = new Scanner(System.in);
		sb = new StringBuilder();
		courseService = new CourseService();
		studentService = new StudentService();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SMSRunner sms = new SMSRunner();
		sms.run();
	}

	private void run() {
		// Login or quit
		switch (menu1()) {
		case 1:
			if (studentLogin()) {
				registerMenu();
			}
			break;
		case 2:
			out.println("Goodbye!");
			break;

		default:

		}
	}

	private int menu1() {
		sb.append("\n1.Student Login\n2. Quit Application\nPlease Enter Selection: ");
		out.print(sb.toString());
		sb.delete(0, sb.length());

		return sin.nextInt();
	}

	private boolean studentLogin() {
		boolean retValue = false;
		out.print("Enter your email address: ");
		String email = sin.next();
		out.print("Enter your password: ");
		String password = sin.next();

		Student student = studentService.getStudentByEmail(email);
		if (student != null) {
			currentStudent = student;
		}
		if (currentStudent != null & currentStudent.getsPass().equals(password)) {
			List<Course> courses = studentService.getStudentCourses(email);
			out.println("MyClasses");
			if (courses.isEmpty()) {
				System.out.println("no registered courses");
				retValue = false;
			}
			for (Course course : courses) {
				out.println("Course Id: " + course.getcId() + " | Course instructor : " + course.getcInstructorName()
						+ " | course name: " + course.getcName());
			}
			retValue = true;
		} else {
			out.println("User Validation failed. GoodBye!");
		}
		return retValue;
	}

	private void registerMenu() {
		sb.append("\n1.Register a class\n2. Logout\nPlease Enter Selection: ");
		out.print(sb.toString());
		sb.delete(0, sb.length());

		switch (sin.nextInt()) {
		case 1:
			List<Course> allCourses = courseService.getAllCourses();
			List<Course> studentCourses = studentService.getStudentCourses(currentStudent.getsEmail());
			allCourses.removeAll(studentCourses);
			for (Course course : allCourses) {
				out.println("Course Id: " + course.getcId() + " | Course instructor : " + course.getcInstructorName()
						+ " | course name: " + course.getcName());
			}
			out.println();
			out.print("Enter Course Number: ");
			int number = sin.nextInt();
			Course newCourse = courseService.GetCourseById(number);

			if (newCourse != null) {
				studentService.registerStudentToCourse(currentStudent.getsEmail(), newCourse.getcId());
				Student temp = studentService.getStudentByEmail(currentStudent.getsEmail());

				StudentCourseService scService = new StudentCourseService();
				List<Course> sCourses = scService.getAllStudentCourses(temp.getsEmail());

				out.println("MyClasses");
				for (Course course : sCourses) {
					out.println("Course Id: " + course.getcId() + " | Course instructor : "
							+ course.getcInstructorName() + " | course name: " + course.getcName());
				}
			}
			break;
		case 2:
		default:
			out.println("Goodbye!");
		}
	}
}
