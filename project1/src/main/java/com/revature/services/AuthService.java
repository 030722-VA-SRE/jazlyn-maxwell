package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.dtos.UserDto;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class AuthService {

	private UserRepository uRepo;
	
	public AuthService(UserRepository uRepo) {
		super();
		this.uRepo = uRepo;
	}
	
	public UserDto login(String email, String password) {
		User principal = uRepo.findUserByEmail(email);
		
		if (principal == null || !password.equals(principal.getPassword())) {
			return null;
		}
		return new UserDto(principal);
	}
	
	public String generateToken(UserDto principal) {
		return "token:" + principal.getId();
	}
}
