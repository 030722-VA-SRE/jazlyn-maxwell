package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Charm;
import com.revature.services.CharmService;

@RestController
@RequestMapping("/charms")
public class CharmController {

	private CharmService cServ;
	
	@Autowired
	public CharmController(CharmService cServ) {
		super();
		this.cServ = cServ;
	}
	
	@GetMapping
	public ResponseEntity<List<Charm>> getUsers() {
		return new ResponseEntity<>(cServ.getCharms(), HttpStatus.OK);	
	}
}
