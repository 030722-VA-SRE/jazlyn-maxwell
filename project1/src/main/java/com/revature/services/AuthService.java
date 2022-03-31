package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.config.JwtTokenUtil;
import com.revature.dtos.UserDto;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class AuthService {

	private UserRepository uRepo;
	private JwtTokenUtil jUtil;
	
	public AuthService(UserRepository uRepo, JwtTokenUtil jUtil) {
		super();
		this.uRepo = uRepo;
		this.jUtil = jUtil;
	}
	
	public UserDto login(String email, String password) {
		User principal = uRepo.findUserByEmail(email);
		
		if (principal == null || !password.equals(principal.getPassword())) {
			return null;
		}
		return new UserDto(principal);
	}
	
	public String generateToken(UserDto principal) {
		User user = uRepo.getById(principal.getId());
		return jUtil.generateToken(user);
	}
}
