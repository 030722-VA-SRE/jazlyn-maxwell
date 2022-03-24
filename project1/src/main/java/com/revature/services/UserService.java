package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repositories.UserRepository;


@Service
public class UserService {

	private UserRepository uRepo;
	
	@Autowired
	public UserService(UserRepository uRepo) {
		super();
		this.uRepo = uRepo;
	}

}
