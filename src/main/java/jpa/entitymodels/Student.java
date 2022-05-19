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
	
	//class variables
	@Id
	@Column(name = "Student_Email", nullable = false)
	private String sEmail;
	@Column(name = "student_FullName", nullable = false)
	private String sName;
	@Column(name = "student_password", nullable = false)
	private String sPass;
	
	//relationship
	@ManyToMany(targetEntity=Course.class, cascade = {CascadeType.ALL})
	private List<Course> sCourses = new ArrayList<Course>();
	

	public Student(String sEmail, String sName, String sPass, List<Course> sCourses) {
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourses = sCourses;
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

	public List<Course> getsCourses() {
		return sCourses;
	}

	public void setsCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
