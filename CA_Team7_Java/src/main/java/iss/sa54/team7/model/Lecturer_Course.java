package iss.sa54.team7.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Lecturer_Course")
@NoArgsConstructor

public class Lecturer_Course {
	@Id
	@Column(name = "lecturerID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String lecturerID;
	@Column(name = "courseID")
	private int courseID;
	@Column(name = "Size")
	private int Size;
    
    @ManyToOne
    @JoinColumn(name="lectureID")
    private Collection<Lecturer> lecturers;
    
    @ManyToOne
    @JoinColumn(name="courseID")
    private Collection<Course> courses;

	public String getLecturerID() {
		return lecturerID;
	}

	public void setLecturerID(String lecturerID) {
		this.lecturerID = lecturerID;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public int getSize() {
		return Size;
	}

	public void setSize(int size) {
		Size = size;
	}

	public Collection<Lecturer> getLecturers() {
		return lecturers;
	}

	public void setLecturers(Collection<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}

	public Collection<Course> getCourses() {
		return courses;
	}

	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}

	public Lecturer_Course(String lecturerID, int courseID, int size, Collection<Lecturer> lecturers,
			Collection<Course> courses) {
		super();
		this.lecturerID = lecturerID;
		this.courseID = courseID;
		Size = size;
		this.lecturers = lecturers;
		this.courses = courses;
	}
    
    
}


