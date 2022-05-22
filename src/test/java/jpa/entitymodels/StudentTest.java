package jpa.entitymodels;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StudentTest {

	

	@Test
	public void testGetsEmail() {
		Student student = new Student();
		student.setsEmail("aiannitti7@is.gd");
		student.setsName("Alexandra Iannitti");
		
		
		assertEquals("Alexandra Iannitti", student.getsName());
		assertEquals("Ian Ascencio", student.getsName());
	}
	
	

}
