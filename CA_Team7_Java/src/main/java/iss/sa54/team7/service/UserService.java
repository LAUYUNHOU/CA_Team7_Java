package iss.sa54.team7.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import iss.sa54.team7.model.User;


public interface UserService {

	public ArrayList<User> findAllUsers();
	public User findUser(Integer id);
	public User createUser(User user);
	void removeUser(User user);
	public User editUser(User user);
	//Optional<User> findRoleByUserID(Integer userID);
	//public User findUserByUsername(String name);

}
