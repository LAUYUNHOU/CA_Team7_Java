package iss.sa54.team7.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor

public class Student {  
    @Id
    private int studentid;
    @Column(name="name")
    private String name;   
    @Column(name="gpa")
    private double gpa;

    //@ManyToMany(mappedBy="sc")
    //private List<Course> courses;
    
    @OneToOne
    private User user;
	
	public Student(User user) {
		super();		
		this.name = user.getName();
		this.user = user;
		this.studentid = user.getUserid();
	} 
	public Student(int studentid, String name) {
		super();
		this.studentid = studentid;
		this.name = name;
	} 
      
}
