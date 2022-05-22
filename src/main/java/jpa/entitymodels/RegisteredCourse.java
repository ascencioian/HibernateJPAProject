package jpa.entitymodels;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name ="student_course")
@NamedQueries({
	@NamedQuery( name="Select_All_Registered_Courses", query="from RegisteredCourse"),
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sCourses_Course_Id;
		result = prime * result + ((Student_Student_Email == null) ? 0 : Student_Student_Email.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisteredCourse other = (RegisteredCourse) obj;
		
		if (sCourses_Course_Id != other.sCourses_Course_Id)
			return false;
		if (Student_Student_Email == null) {
			if (other.Student_Student_Email != null)
				return false;
		} else if (!Student_Student_Email.equals(other.Student_Student_Email))
			return false;
		return true;
	}
	
}
