package iss.sa54.team7.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Student")
@NoArgsConstructor
@Data

public class Student {
	@Id
	@Column(name = "studentID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentID;
	
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

	public Student(int studentID, String lastName, String firstMidName, Date enrollmentDate, Double gpa,
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

