package jpa.entitymodels;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery( name="Select_Registered_Courses_by_Student", query="Select c from RegisteredCourse c where c.Student_Student_Email = :email"),
})
public class RegisteredCourse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//class variables
	@Id
	@Column(name = "Student_Student_Email", nullable = false)
	private String Student_Student_Email;
	@Id
	@Column(name = "sCourses_Course_Id", nullable = false)
	private int sCourses_Course_Id;
	
	public RegisteredCourse(String student_Student_Email, Integer sCourses_Course_Id) {
		this.Student_Student_Email = student_Student_Email;
		this.sCourses_Course_Id = sCourses_Course_Id;
	}
	
	//default constructor
	public RegisteredCourse() {}

	//Getters Setters
	public String getStudent_Student_Email() {
		return Student_Student_Email;
	}

	public void setStudent_Student_Email(String student_Student_Email) {
		Student_Student_Email = student_Student_Email;
	}

	public Integer getsCourses_Course_Id() {
		return sCourses_Course_Id;
	}

	public void setsCourses_Course_Id(Integer sCourses_Course_Id) {
		this.sCourses_Course_Id = sCourses_Course_Id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
