package iss.sa54.team7.service;

import java.util.ArrayList;

import iss.sa54.team7.model.Lecturer;

public interface LecturerService {
	ArrayList<Lecturer>findAllLecturer();
	Lecturer findLecturer(Integer lecturerID);
	Lecturer createLecturer(Lecturer lecturer);
	Lecturer editLecturer(Lecturer lecturer);
	void removeLecturer(Lecturer lecturer);
	void removeLecturerbyId(Integer lecturerID);
	//ArrayList<Lecturer>findLecturersByID(Integer lecturerID);
}
