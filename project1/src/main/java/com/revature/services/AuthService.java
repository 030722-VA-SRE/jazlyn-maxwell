package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.revature.dtos.UserDto;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class AuthService {

	private UserRepository uRepo;
	private JwtTokenUtil jUtil;
	private static final Logger Log = LoggerFactory.getLogger(AuthService.class);
	
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
		Log.info("Successful login with username " + principal.getEmail());
		return new UserDto(principal);
	}
	
	public String generateToken(UserDto principal) {
		User user = uRepo.getById(principal.getId());
		return jUtil.generateToken(user);
	}
}
