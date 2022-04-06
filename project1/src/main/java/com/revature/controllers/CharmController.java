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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.CharmDto;
import com.revature.models.Charm;
import com.revature.models.Role;
import com.revature.services.AuthService;
import com.revature.services.CharmService;

@RestController
@RequestMapping("/charms")
public class CharmController {

	private CharmService cServ;
	private AuthService aServ;
	
	@Autowired
	public CharmController(CharmService cServ, AuthService aServ) {
		super();
		this.cServ = cServ;
		this.aServ = aServ;
	}
	
	@GetMapping
	public ResponseEntity<List<CharmDto>> getCharms() {
		return new ResponseEntity<>(cServ.getCharms(), HttpStatus.OK);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CharmDto> getCharmById(@PathVariable("id") int id) {
		return new ResponseEntity<>(cServ.getCharmById(id), HttpStatus.OK);	
	}
	
	@PostMapping
	public ResponseEntity<CharmDto> postCharm(@RequestHeader(value = "Authorization", required = false) String token, @RequestBody Charm charm) {
		if (!aServ.checkPermission(token, Role.SELLER, Role.ADMIN)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		CharmDto newCharm = cServ.createCharm(charm);
		return new ResponseEntity<>(newCharm, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CharmDto> updateCharm(@RequestHeader(value = "Authorization", required = false) String token, @PathVariable("id") int id, @RequestBody Charm charm) {
		if (!aServ.checkPermission(token, Role.SELLER, Role.ADMIN)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		charm.setId(id);
		return new ResponseEntity<>(cServ.updateCharm(charm), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCharm(@RequestHeader(value = "Authorization", required = false) String token, @PathVariable("id") int id) {
		if (!aServ.checkPermission(token, Role.SELLER, Role.ADMIN)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		cServ.deleteCharm(id);
		return new ResponseEntity<>("Charm was deleted.", HttpStatus.OK);
	}
}
