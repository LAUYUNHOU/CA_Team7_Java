package iss.sa54.team7.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Lecturer {
	@Id
	private int lecturerID;
	@Column(name="lecturername")
	private String lecturerName;
    
	@OneToOne
    private User user2;
	@OneToMany(mappedBy = "lecturer", cascade = CascadeType.ALL)
    private Set<Lecturer_Course> lecturerCourses = new HashSet<>();
	
    public Lecturer(String lecturerName, User user2, Set<Lecturer_Course> lecturerCourses) {
		super();
		this.lecturerID = user2.getUserId();
		this.lecturerName = lecturerName;
	}
	
	
}


