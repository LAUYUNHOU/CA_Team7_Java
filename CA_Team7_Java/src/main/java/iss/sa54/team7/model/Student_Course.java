package iss.sa54.team7.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student_Course {  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int scid;
	
	//@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //private Course course;
	private int courseid;
   //private Student student;	
	//@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)	  
 
    private int studentid;	
    private String grade; 
	
	public Student_Course(int courseid, int studentid, String grade) {
	super();
	
	this.courseid=courseid;
	this.studentid=studentid;
	this.grade = grade;	}
	
	public Student_Course(int courseid,int studentid){
        super();
        this.courseid=courseid;
        this.studentid=studentid;
        grade = "";
    }
        
}
