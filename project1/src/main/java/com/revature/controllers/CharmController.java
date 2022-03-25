package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<List<Charm>> getCharms() {
		return new ResponseEntity<>(cServ.getCharms(), HttpStatus.OK);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Charm> getCharmById(@PathVariable("id") int id) {
		return new ResponseEntity<>(cServ.getCharmById(id), HttpStatus.OK);	
	}
	
	@PostMapping
	public ResponseEntity<Charm> postCharm(@RequestBody Charm charm) {
		Charm newCharm = cServ.createCharm(charm);
		return new ResponseEntity<>(newCharm, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Charm> updateCharm(@PathVariable("id") int id, @RequestBody Charm charm) {
		charm.setId(id);
		return new ResponseEntity<>(cServ.updateCharm(charm), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCharm(@PathVariable("id") int id) {
		cServ.deleteCharm(id);
		return new ResponseEntity<>("Charm was deleted.", HttpStatus.OK);
	}
}
