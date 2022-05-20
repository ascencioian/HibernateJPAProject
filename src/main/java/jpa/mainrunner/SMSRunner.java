package jpa.mainrunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.dao.StudentDao;
import jpa.entitymodels.Course;
import jpa.entitymodels.RegisteredCourses;
import jpa.entitymodels.Student;
import jpa.service.StudentService;

public class SMSRunner {
	
	public static Scanner reader = new Scanner(System.in);
	
	



	public static void main(String[] args) {
		
		
		/*test zone
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		

			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			
			TypedQuery query = session.getNamedQuery("Select_All_Courses");
			
			 List<RegisteredCourses> registeredCourses = query.getResultList();
			 
			 System.out.println("this far");
			 System.out.println(registeredCourses);  //this works
			   Iterator<RegisteredCourses> itr = registeredCourses.iterator(); 
		          for (RegisteredCourses u : registeredCourses) {
			    	 System.out.println("courseID: " +u.getsCourses_Course_Id() + "|" + " email:" + u.getStudent_Student_Email() +"|");
			      } 
		         
		         
			 
			   factory.close();  
			   session.close(); 
			   
		
	   /*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * test zone
		 */
	
		

	}
	

}
