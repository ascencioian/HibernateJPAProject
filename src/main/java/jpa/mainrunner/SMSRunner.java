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
//class imports 
import jpa.entitymodels.Student;
import jpa.service.StudentService;

public class SMSRunner {
	
	public static Scanner reader = new Scanner(System.in);
	
	



	public static void main(String[] args) {
		
		String studentEmail = "aiannitti7@is.gd" ;
		String studentPassword = "TWP4hf5j";
			// TODO Auto-generated method stub
			//Only students with the right credentials can log in. Otherwise, a message is displayed stating: “Wrong Credentials”. 
			//Valid students are able to see the courses they are registered for.
			//Valid students are able to register for any course in the system as long as they are not already registered.
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			
			Transaction tx = session.beginTransaction();
			
			//Create Employee object using session.get()
	        Student student = (Student) session.get(Student.class,new String(studentEmail));
			
	        System.out.println("*** Employee Details ***");
	        System.out.println("email   : "+student.getsEmail());
	        System.out.println("Name : "+student.getsName());
	        System.out.println("pass  : "+student.getsPass());
	        
	        String validPassword = student.getsPass();
	        
	        System.out.println(validPassword);
	        
	        if(studentPassword.equalsIgnoreCase(validPassword)) {
	        	System.out.println("valid user");
	        }else {
	        	System.out.println("Wrong Credentials");
	        }
	        
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
