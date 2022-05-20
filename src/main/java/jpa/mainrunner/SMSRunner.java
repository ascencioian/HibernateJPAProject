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
//class imports 
import jpa.entitymodels.Student;
import jpa.service.StudentService;

public class SMSRunner {
	
	public static Scanner reader = new Scanner(System.in);
	
	



	public static void main(String[] args) {
		
		
			// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
	    Session session = factory.openSession();
	    
	    TypedQuery query = session.getNamedQuery("Select_All_Courses");
	    
	    List<Course> courses = query.getResultList();
	    
	    
	   
   
	    
	    factory.close();  
		session.close();
	
	
			//how are you going to validate a student?
			//i am going to be provided a student password
			//i need to grab from the database my student
			//i need to save the password attribute to a local variable
			//i need to run a comparison between the input and the local variable,
			//return true if correct
			//return an error message if false
			
		
	     
		
		// TODO Auto-generated method stub
	
		
		
		/*test zone
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		

	}
	
	
	//display menu
	public static void menu() {
		System.out.println("Are you a(n)");
		System.out.println("1. Student");
		System.out.println("2. quit");
		System.out.println("Please enter 1 or 2.");
	}

}
