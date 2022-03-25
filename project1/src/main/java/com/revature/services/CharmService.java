package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

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
	
	@Transactional
	public Charm createCharm(Charm charm) {
		return cRepo.save(charm);
	}
	
	@Transactional
	public Charm updateCharm(Charm charm) {
		 Charm charmUpdate = cRepo.getById(charm.getId());
		// Validate input
			if (charm.getName() != null && !charm.getName().equals(charmUpdate.getName())) {
				charmUpdate.setName(charm.getName());
			}
			if (charm.getDescription() != null && !charm.getDescription().equals(charmUpdate.getDescription())) {
				charmUpdate.setDescription(charm.getDescription());
			}
			if (charm.getPrice() != charmUpdate.getPrice()) {
				charmUpdate.setPrice(charm.getPrice());
			}
			if (charm.getLocation() != null && charm.getLocation().getId() != charmUpdate.getLocation().getId()) {
				charmUpdate.setLocation(charm.getLocation());
			}
			if (charm.getSeller() != null && charm.getSeller().getId() != charmUpdate.getSeller().getId()) {
				charmUpdate.getSeller().setId(charm.getSeller().getId());
			}
			return cRepo.save(charmUpdate);
	}
	
	@Transactional
	public void deleteCharm(int id) {
		Charm charm = cRepo.getById(id);
		cRepo.delete(charm);
	}
	
	
}
