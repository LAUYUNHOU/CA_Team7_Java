package iss.sa54.team7.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa54.team7.model.*;

public interface StudentCourseRepo extends JpaRepository<Student_Course, Integer> {
	@Query(" SELECT sc FROM Student_Course sc and Student s WHERE sc.studentID = :stuID AND sc.studentID = s.studentID")
	public ArrayList<Student_Course> findCoursesByStudentID(@Param("stuID")Integer stuID);

	public ArrayList<Student_Course> findCoursesByStuID(Integer stuID);

}
