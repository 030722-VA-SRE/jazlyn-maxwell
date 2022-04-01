package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepository;


@Service
public class UserService {

	private UserRepository uRepo;
	private static final Logger Log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	public UserService(UserRepository uRepo) {
		super();
		this.uRepo = uRepo;
	}
	
	public List<User> getUsers() {
		return uRepo.findAll();
	}
	
	public User getUserById(int id) {
		return uRepo.getById(id);
	}
	
	@Transactional
	public User createUser(User user) {
		Log.info("User created ", user);
		return uRepo.save(user);
	}
	
	@Transactional
	public User updateUser(User user) {
		 User userUpdate = uRepo.getById(user.getId());
		// Validate input
			if (user.getName() != null && !user.getName().equals(userUpdate.getName())) {
				userUpdate.setName(user.getName());
			}
			if (user.getEmail() != null && !user.getEmail().equals(userUpdate.getEmail())) {
				userUpdate.setEmail(user.getEmail());
			}
			if (user.getPassword() != null && !user.getPassword().equals(userUpdate.getPassword())) {
				userUpdate.setPassword(user.getPassword());
			}
			if (user.getRole() != null && !user.getRole().equals(userUpdate.getRole())) {
				userUpdate.setRole(user.getRole());
			}
			Log.info("User updated ", userUpdate);
			return uRepo.save(userUpdate);
	}
	
	@Transactional
	public void deleteUser(int id) {
		User user = uRepo.getById(id);
		Log.info("User deleted ", user);
		uRepo.delete(user);
	}

}
