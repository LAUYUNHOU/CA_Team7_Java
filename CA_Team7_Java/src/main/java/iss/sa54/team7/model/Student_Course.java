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
@Table(name = "Student_Course")
@Data
@NoArgsConstructor

public class Student_Course {
	@Id
	@Column(name = "studentID")
	private String studentID;
	@Column(name = "courseID")
	private int courseID;
	@Column(name = "Size")
	private int Size;
	@Column(name = "grade")
	private String grade;
	@Column(name = "score")
	private int score;

    @ManyToOne
    @JoinColumn(name="studentID") 
    private Collection<Student> students;
    
    @ManyToOne
    @JoinColumn(name="courseID") 
    private Collection<Course> courses;

    
    
	public Student_Course(String studentID, int courseID, int size, String grade, int score,
			Collection<Student> students, Collection<Course> courses) {
		super();
		this.studentID = studentID;
		this.courseID = courseID;
		Size = size;
		this.grade = grade;
		this.score = score;
		this.students = students;
		this.courses = courses;
	}
        
    
    
}


