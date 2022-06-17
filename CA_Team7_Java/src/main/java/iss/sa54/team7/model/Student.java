package iss.sa54.team7.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Student")
@NoArgsConstructor

public class Student {
	@Id
	@Column(name = "studentID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String studentID;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "firstMidName")
	private String firstMidName;
	@Column(name = "enrollmentDate")
	private Date enrollmentDate;
	@Column(name = "gpa")
	private Double gpa;
    
    @OneToMany(mappedBy="students")
    @JoinColumn(name="studentID") 
    private Student_Course StudentCourse;

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstMidName() {
		return firstMidName;
	}

	public void setFirstMidName(String firstMidName) {
		this.firstMidName = firstMidName;
	}

	public Date getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public Student_Course getStudentCourse() {
		return StudentCourse;
	}

	public void setStudentCourse(Student_Course studentCourse) {
		StudentCourse = studentCourse;
	}

	public Student(String studentID, String lastName, String firstMidName, Date enrollmentDate, Double gpa,
			Student_Course studentCourse) {
		super();
		this.studentID = studentID;
		this.lastName = lastName;
		this.firstMidName = firstMidName;
		this.enrollmentDate = enrollmentDate;
		this.gpa = gpa;
		StudentCourse = studentCourse;
	}

    

}

