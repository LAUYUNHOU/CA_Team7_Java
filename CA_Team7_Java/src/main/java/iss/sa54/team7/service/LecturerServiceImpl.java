package iss.sa54.team7.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa54.team7.model.Lecturer;
import iss.sa54.team7.repo.LecturerRepo;

@Service
public class LecturerServiceImpl implements LecturerService {
	@Resource
	private LecturerRepo lrepo;

	
	@Override  
	@Transactional public ArrayList<Lecturer> findAllLecturer() {
	  ArrayList<Lecturer>list = (ArrayList<Lecturer>)lrepo.findAll(); 
	  		return list;
	  }


	@Override
	@Transactional
	public Lecturer findLecturer(Integer lecturerID) {
		return lrepo.findById(lecturerID).orElse(null);
	}

	@Override
	@Transactional
	public Lecturer createLecturer(Lecturer lecturer) {
		return lrepo.saveAndFlush(lecturer);
	}
	
	public Lecturer editLecturer(Lecturer lecturer) {
		return lrepo.saveAndFlush(lecturer);
	}
	@Override
	@Transactional
	public void removeLecturer(Lecturer lecturer) {
		lrepo.delete(lecturer);
	}
		
	@Override
	@Transactional
	public void removeLecturerbyId(Integer lecturerID) {
		lrepo.deleteById(lecturerID);
	}

	/*
	 * @Override
	 * 
	 * @Transactional public ArrayList<Lecturer> findLecturersByID(Integer
	 * lecturerID) { return lrepo.findById(lecturerID).orElse(null); }
	 */

}
