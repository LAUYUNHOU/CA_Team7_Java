package iss.sa54.team7.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

    //@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)	  
	//@JoinColumn(name = "studentid")
    //private Student_Course studentCourses;
    
    @OneToOne
    private User user;
	
	public Student(String name, User user) {
		super();		
		this.name = name;
		this.user = user;
		this.studentid = user.getUserid();
	} 
      
}
