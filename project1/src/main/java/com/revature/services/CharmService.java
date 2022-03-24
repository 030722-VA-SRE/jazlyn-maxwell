package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Charm;
import com.revature.repositories.CharmRepository;

@Service
public class CharmService {

	private CharmRepository cRepo;
	
	@Autowired
	public CharmService(CharmRepository cRepo) {
		super();
		this.cRepo = cRepo;
	}
	
	public List<Charm> getCharms() {
		return cRepo.findAll();
	}
	
	public Charm getCharmById(int id) {
		return cRepo.getById(id);
	}
	
	public Charm createCharm(Charm charm) {
		return cRepo.save(charm);
	}
	
	public Charm updateCharm(Charm charm) {
		//TODO
		return null;
	}
	
	public boolean deleteCharm(Charm charm) {
		//TODO
		return false;
	}
	
	
}
