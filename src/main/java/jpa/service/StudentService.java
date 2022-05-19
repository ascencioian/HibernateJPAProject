package jpa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.dao.StudentDao;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;


public class StudentService implements StudentDao {

	//---------------------------------show all of the students from the database--------------------
	//This method reads the student table in your database and returns the data as a List<Student>
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
	    Session session = factory.openSession();
	    
		TypedQuery query = session.getNamedQuery("Select_All_Students");    
     
        List<Student> students = query.getResultList();   
          
		
        //testing
        /*  Iterator<Student> itr = students.iterator(); 
         *  for (Student u : students) {
	    	 System.out.println("Email: " +u.getsEmail() + "|" + " Full name:" + u.getsName() +"|"+ "password: " + u.getsPass() +"|");
	      } 
         
         * */

	   factory.close();  
	   session.close();  
	   
	   return students;
	}

	//---------------------------------Return a single student--------------------
	//This method takes a Student’s email as a String and parses the student list for a Student with that email and returns a Student Object.
	public Student getStudentByEmail(String studentEmail) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//Create Employee object using session.get()
        Student student = (Student) session.get(Student.class,new String(studentEmail));
        
        //testing
        /*
        System.out.println("*** Employee Details ***");
        System.out.println("email   : "+student.getsEmail());
        System.out.println("Name : "+student.getsName());
        System.out.println("pass  : "+student.getsPass());
        
         * */
        
		//using namedQuery and getSingleResult, have to handle the NonUniqueResultException 
       /*
        TypedQuery query = session.getNamedQuery("Select_Student_By_Email");  
        query.setParameter("email", studentEmail); 
        Object students = query.getSingleResult();
        * */

	    //Close resources
	     factory.close();
	     session.close();
		
		
		
		return student;
	}
	
	//named query
	public void findEmployeeById(){
			 
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		       
        TypedQuery query = session.getNamedQuery("get_Emp_name_by_id");    
        query.setParameter("id",3);   
		 List<Object[]> emName=  query.getResultList();
		for(Object[] o: emName)
				{
		System.out.println("Employee name: " +o[0] +" | Employee Salary: "+ o[1] +" | Emp Job Title: "+ o[2]);
		         }
			factory.close();  
		     session.close();    
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
