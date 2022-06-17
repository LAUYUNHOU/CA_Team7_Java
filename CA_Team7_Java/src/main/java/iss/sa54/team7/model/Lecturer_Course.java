package iss.sa54.team7.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Lecturer_Course")
@NoArgsConstructor
@Data

public class Lecturer_Course {
	@Id
	@Column(name = "lecturerID")
	private int lecturerID;
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

	public Lecturer_Course(int lecturerID, int courseID, int size, Collection<Lecturer> lecturers,
			Collection<Course> courses) {
		super();
		this.lecturerID = lecturerID;
		this.courseID = courseID;
		Size = size;
		this.lecturers = lecturers;
		this.courses = courses;
	}
    
    
}


