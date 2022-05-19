/*
 * Filename: StudentCourses.java
* Author: Stefanski
* 02/25/2020 
 */
package jpa.entitymodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Harry
 *
 */
@Entity
@Table( name="courses")
@IdClass( StudentCoursesID.class)
@NamedQueries({
	@NamedQuery( name="CoursesByStudent", query="Select c from StudentCourses c where c.eMail = :email")
})
public class StudentCourses {
	@Id
	@Column(name="student_email")
	private String eMail;
	
	public StudentCourses() {}
	
	/**
	 * @param eMail
	 * @param courseID
	 */
	public StudentCourses(String eMail, int courseID) {
		this.eMail = eMail;
		this.courseID = courseID;
	}

	@Id
	@Column(name="course_id")
	private int courseID;

	/**
	 * @return the eMail
	 */
	public String geteMail() {
		return eMail;
	}

	/**
	 * @param eMail the eMail to set
	 */
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	/**
	 * @return the courseID
	 */
	public int getCourseID() {
		return courseID;
	}

	/**
	 * @param courseID the courseID to set
	 */
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseID;
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		StudentCourses other = (StudentCourses) obj;
		if (courseID != other.courseID)
			return false;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		return true;
	}

}
