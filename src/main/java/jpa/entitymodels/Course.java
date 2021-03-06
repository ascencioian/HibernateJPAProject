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
@NamedQueries({ @NamedQuery(name = "Select_All_Courses", query = "from Course"), })
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	// Select_All_Courses
	// class variables
	@Id
	@Column(name = "Course_Id", nullable = false)
	private int cId;
	@Column(name = "Course_Name", nullable = false, length = 50)
	private String cName;
	@Column(name = "Course_Instructor", nullable = false, length = 50)
	private String cInstructorName;

	public Course(int cId, String cName, String cInstructorName) {
		this.cId = cId;
		this.cName = cName;
		this.cInstructorName = cInstructorName;
	}

	// default constructor
	public Course() {
	}

	// generate getters setters
	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcInstructorName() {
		return cInstructorName;
	}

	public void setcInstructorName(String cInstructorName) {
		this.cInstructorName = cInstructorName;
	}

}
