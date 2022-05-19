package jpa.entitymodels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Array of Courses 
	//private List<Course> sCourses = new ArrayList<Course>();
	
	//class variables
	@Id
	@Column(name = "Student_Email")
	private String sEmail;
	@Column(name = "student_FullName")
	private String sName;
	@Column(name = "student_password")
	private String sPass;
	
	
	public Student( String sEmail, String sName, String sPass) {
		
		//this.sCourses = sCourses;
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
	}

	//default constructor
	public Student(){}

	//getters setters
	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPass() {
		return sPass;
	}

	public void setsPass(String sPass) {
		this.sPass = sPass;
	}

	


}
