package com.revature.services;

import java.util.Arrays;

import com.revature.daos.UserDao;
import com.revature.daos.UserPostgres;
import com.revature.models.Role;
import com.revature.models.User;

public class AuthService {

	private UserDao uDao;
	
	public AuthService() {
		uDao = UserPostgres.getInstance();
	}
	
	// for testing
	public AuthService(UserDao uDao) {
		this.uDao = uDao;
	}
	
	public String login(String email, String password) {
		String token = null;
		
		User principal = uDao.getUserByEmail(email);
		if (principal != null && principal.getPassword().equals(password)) {
			token = principal.getRole() + ":" + principal.getId();
		}
		
		return token;
	}
	
	public boolean checkPermission(String token, Role... allowedRoles) {
		if (token == null) {
			return false;
		}
		
		String[] info = token.split(":");
		Role token_role = Role.valueOf(info[0]);
		int token_id = Integer.parseInt(info[1]);
		User principal = uDao.getUserById(token_id);
		
		if (principal != null && token_role.equals(principal.getRole()) && Arrays.asList(allowedRoles).contains(token_role)) {
			return true;
		}
		
		return false;
	}
}
