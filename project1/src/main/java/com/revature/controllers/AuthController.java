package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.UserDto;
import com.revature.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private AuthService aServ;
	
	@Autowired
	public AuthController(AuthService aServ) {
		super();
		this.aServ = aServ;
	}
	
	@PostMapping
	public ResponseEntity<UserDto> login(@RequestParam("email") String email, @RequestParam("password") String password) {
		UserDto principal = aServ.login(email, password);
		
		if (principal == null) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		String token = aServ.generateToken(principal);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		
		return new ResponseEntity<>(principal, headers, HttpStatus.ACCEPTED);
	}
}
