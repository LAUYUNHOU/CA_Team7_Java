package iss.sa54.team7.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student_Course {  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	//@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//@JoinColumn(name = "courseid") 
    //private Course course;
	private int courseid;
	//@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)	  
	//@JoinColumn(name = "studentid")    
    //private Student student;
    private int studentid;	
    private String grade;   
	
	public Student_Course(int courseid, int studentid, String grade) {
	super();
	this.courseid = courseid;
	this.studentid = studentid;
	this.grade = grade;	}
        
}
