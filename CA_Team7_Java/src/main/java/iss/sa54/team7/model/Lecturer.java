package iss.sa54.team7.controller;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Lecturer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lecturerID;
	@Column(name="lecturername")
	private String lecturerName;
    
	@OneToMany(mappedBy = "lecturer", cascade = CascadeType.ALL)
    private Set<Lecturer_Course> lecturerCourses = new HashSet<>();
	
	public Lecturer(String lecturerName) {
		super();
		this.lecturerName = lecturerName;
		
	}
}


