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

import com.revature.models.Location;
import com.revature.services.LocationService;

@RestController
@RequestMapping("/locations")
public class LocationController {

	private LocationService lServ;
	
	@Autowired
	public LocationController(LocationService lServ) {
		super();
		this.lServ = lServ;
	}
	
	@GetMapping
	public ResponseEntity<List<Location>> getLocations() {
		return new ResponseEntity<>(lServ.getLocations(), HttpStatus.OK);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Location> getLocationById(@PathVariable("id") int id) {
		return new ResponseEntity<>(lServ.getLocationById(id), HttpStatus.OK);	
	}
	
	@PostMapping
	public ResponseEntity<Location> postLocation(@RequestBody Location location) {
		Location newLocation = lServ.createLocation(location);
		return new ResponseEntity<>(newLocation, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Location> updateLocation(@PathVariable("id") int id, @RequestBody Location location) {
		location.setId(id);
		return new ResponseEntity<>(lServ.updateLocation(location), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteLocation(@PathVariable("id") int id) {
		lServ.deleteLocation(id);
		return new ResponseEntity<>("Location was deleted.", HttpStatus.OK);
	}

}
