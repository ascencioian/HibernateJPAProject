package com.test.project.controller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//class imports
import jpa.entitymodels.Course;

public class CreateCourses {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction t = session.beginTransaction();   
    	
    	Course cOne = new Course();
    	cOne.setcId(1);
    	cOne.setcName("English");
    	cOne.setcInstructorName("Anderea Scamaden");
    	
    	Course cTwo = new Course();
    	cTwo.setcId(2);
    	cTwo.setcName("Mathematics");
    	cTwo.setcInstructorName("Eustace Niemetz");
    	
    	Course cThree = new Course();
    	cThree.setcId(3);
    	cThree.setcName("Anatomy");
    	cThree.setcInstructorName("Reynolds Pastor");
    	
    	Course cFour = new Course();
    	cFour.setcId(4);
    	cFour.setcName("Organic Chemistry");
    	cFour.setcInstructorName("Odessa Belcher");
    	
    	Course cFive = new Course();
    	cFive.setcId(5);
    	cFive.setcName("Physics");
    	cFive.setcInstructorName("Dani Swallow");

    	Course cSix = new Course();
    	cSix.setcId(6);
    	cSix.setcName("Digital Logic");
    	cSix.setcInstructorName("Glenden Reilingen");
    	
    	Course cSeven = new Course();
    	cSeven.setcId(7);
    	cSeven.setcName("Object Oriented Programming");
    	cSeven.setcInstructorName("Giselle Ardy");

    	Course cEight = new Course();
    	cEight.setcId(8);
    	cEight.setcName("Data Structures");
    	cEight.setcInstructorName("Carolan Stoller");
    	
    	Course cNine= new Course();
    	cNine.setcId(9);
    	cNine.setcName("Politics");
    	cNine.setcInstructorName("Carmita De Maine");
    	
    	Course cTen = new Course();
    	cTen.setcId(10);
    	cTen.setcName("Art");
    	cTen.setcInstructorName("Kingsly Doxsey");
    
    	
  

    	session.save(cOne); 
    	session.save(cTwo); 
    	session.save(cThree); 
    	session.save(cFour); 
    	session.save(cFive);
    	session.save(cSix); 
    	session.save(cSeven); 
    	session.save(cEight); 
    	session.save(cNine); 
    	session.save(cTen);
    	  
        t.commit();
        System.out.println("successfully saved courses");   
        factory.close();  
        session.close(); 
        
        
	}
}


  
