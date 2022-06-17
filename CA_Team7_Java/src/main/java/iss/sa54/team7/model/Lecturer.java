package iss.sa54.team7.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Lecturer")
@NoArgsConstructor
@Data
public class Lecturer {
	@Id
	@Column(name = "lecturerID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lecturerID;
	@Column(name = "lecturerName")
	private String lecturerName;
    
    @OneToMany(mappedBy="lecturers")  
    private Lecturer_Course LecturerCourse;
	
	public Lecturer(String lecturerName, Lecturer_Course lecturerCourse) {
		super();
		this.lecturerName = lecturerName;
		LecturerCourse = lecturerCourse;
	}
    
    
    
}


