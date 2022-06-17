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

public class Course {
	@Id
	@Column(name = "courseID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String courseID;
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

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(Date courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	public Date getCourseEndDate() {
		return courseEndDate;
	}

	public void setCourseEndDate(Date courseEndDate) {
		this.courseEndDate = courseEndDate;
	}

	public Student_Course getCourseStudent() {
		return CourseStudent;
	}

	public void setCourseStudent(Student_Course courseStudent) {
		CourseStudent = courseStudent;
	}

	public Lecturer_Course getCourseLecture() {
		return CourseLecture;
	}

	public void setCourseLecture(Lecturer_Course courseLecture) {
		CourseLecture = courseLecture;
	}

	public Course(String courseID, String courseName, Date courseStartDate, Date courseEndDate,
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


