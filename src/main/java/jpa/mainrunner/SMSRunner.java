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
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String studentEmail = "aiannitti7@is.gd"; 
		Transaction tx = session.beginTransaction();
		
		//Create Employee object
        Student student = (Student) session.get(Student.class,new String(studentEmail));
        System.out.println("*** Employee Details ***");
        System.out.println("email   : "+student.getsEmail());
        System.out.println("Name : "+student.getsName());
        System.out.println("pass  : "+student.getsPass());
        
        
//		
//		TypedQuery query = session.getNamedQuery("Select_Student_By_Email");  
//		query.setParameter("email", studentEmail); 
//		 List<Student> students = query.getSingleResult();

	    //Close resources
	     factory.close();
	     session.close();
	     
		
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
