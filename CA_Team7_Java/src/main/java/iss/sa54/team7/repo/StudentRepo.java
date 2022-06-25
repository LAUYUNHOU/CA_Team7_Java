package iss.sa54.team7.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import iss.sa54.team7.model.*;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	public Student findByStudentid (Integer id);
	//@Query("SELECT sc FROM Student_Course sc WHERE sc.courseID = :cID AND s.studentID = :sID")
	//public Student_Course getCourseGradeByStudentAndCourseID(@Param("cID")Integer courseID, @Param("sID")Integer studentID);
	
}
