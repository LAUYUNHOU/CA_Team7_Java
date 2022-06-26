package iss.sa54.team7.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa54.team7.model.RoleType;
import iss.sa54.team7.model.User;
import iss.sa54.team7.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo urepo;
	
	
	  @Override
	  @Transactional 
	  public ArrayList<User> findAllUsers() { 
		  ArrayList<User>list = (ArrayList<User>) urepo.findAll(); 
		  return list; 
		  }
		  
	@Override
	@Transactional 
	 public User findUserByUsername(String name) {
		User user = urepo.findUserByUsername(name);
		if (user == null)
			return null;
		 return user;
		 }

	@Override
	@Transactional
	public User findUser(Integer id) {
		return urepo.findById(id).orElse(null);
		}

	@Override
	@Transactional
	public User createUser(User user) {
		return urepo.saveAndFlush(user);
	}

	@Override
	@Transactional
	public void removeUser(User user) {
		urepo.delete(user);
	}

	@Override
	@Transactional
	public User editUser(User user) {
		SCryptPasswordEncoder encoder = new SCryptPasswordEncoder();
        String hashedPassword = encoder.encode(user.getPassword());
        User u1 = user;
        u1.setPassword(hashedPassword);
		return urepo.saveAndFlush(u1);
	}
	@Override
	@Transactional
	public void removeUserById(Integer userID){
		urepo.deleteById(userID);		
	};
	/*
	 * @Override
	 * 
	 * @Transactional public ArrayList<User> findUsersByRole(RoleType role){
	 * ArrayList<User> list = urepo.findUsersByRoleType(role); return list; }
	 */

}
