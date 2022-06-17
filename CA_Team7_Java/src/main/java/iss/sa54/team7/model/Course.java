package iss.sa54.team7.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Course")
@NoArgsConstructor
@Data

public class Course {
	@Id
	@Column(name = "courseID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseID;
	@Column(name = "courseName")
	private String courseName;
	@Column(name = "courseStartDate")
	private Date courseStartDate;
	@Column(name = "courseEndDate")
	private Date courseEndDate;
    
    @OneToMany(mappedBy="courses")
    private Student_Course CourseStudent;
    
    @OneToMany(mappedBy="lecturers") 
    private Lecturer_Course CourseLecture;

	
	public Course(int courseID, String courseName, Date courseStartDate, Date courseEndDate,
			Student_Course courseStudent, Lecturer_Course courseLecture) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseStartDate = courseStartDate;
		this.courseEndDate = courseEndDate;
		CourseStudent = courseStudent;
		CourseLecture = courseLecture;
	}

    
}


