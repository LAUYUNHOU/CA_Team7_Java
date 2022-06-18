package iss.sa54.team7.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa54.team7.model.*;

public interface CourseRepo extends JpaRepository<Course, Integer> {
	@Query(" SELECT c FROM Course c and Lecturer_Course lc WHERE lc.lecturerID = :lectID AND c.courseID = lc.courseID")
	public ArrayList<Course> findCoursesByLecturerID(@Param("lectID")Integer lectID);
	}
