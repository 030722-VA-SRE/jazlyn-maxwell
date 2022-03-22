package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import com.revature.daos.UserDao;
import com.revature.daos.UserPostgres;
import com.revature.models.User;

public class UserService {

	private UserDao uDao;
	
	public UserService() {
		uDao = UserPostgres.getInstance();
	}
	
	// for testing
	public UserService(UserDao uDao) {
		this.uDao = uDao;
	}
	
	public int createUser(User user) {
		return uDao.createUser(user);
	}
	
	public List<User> getUsers() {
		return uDao.getUsers()
				.stream()
				.map(u -> {
					u.setPassword(null);
					u.setBalance(0);
					return u;
					})
				.collect(Collectors.toList());
	}
	
	public User getUserById(int id) {
		User user = uDao.getUserById(id);
		if (user != null) {
			user.setPassword(null);
			user.setBalance(0);
		}
		return user;
	}
	
	public User getUserByEmail(String email) {
		User user = uDao.getUserByEmail(email);
		if (user != null) {
			user.setPassword(null);
			user.setBalance(0);
		}
		return user;
	}
	
	public boolean updateUser(User user) {
		User userUpdate = uDao.getUserById(user.getId());
		
		if (user.getName() != null && !user.getName().equals(userUpdate.getName())) {
			userUpdate.setName(user.getName());
		}
		if (user.getEmail() != null && !user.getEmail().equals(userUpdate.getEmail())) {
			userUpdate.setEmail(user.getEmail());
		}
		if (user.getPassword() != null && !user.getPassword().equals(userUpdate.getPassword())) {
			userUpdate.setPassword(user.getPassword());
		}
		if (user.getBalance() != userUpdate.getBalance()) {
			userUpdate.setBalance(user.getBalance());
		}
		
		return uDao.updateUser(userUpdate);
	}
	
	public boolean deleteUser(int id) {
		return uDao.deleteUser(id);
	}
	
}
