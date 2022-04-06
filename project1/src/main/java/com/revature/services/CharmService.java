package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dtos.CharmDto;
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
	
	public List<CharmDto> getCharms() {
		List<Charm> charms = cRepo.findAll();
		return charms.stream().map(c -> new CharmDto(c)).collect(Collectors.toList());
	}
	
	public CharmDto getCharmById(int id) {
		return new CharmDto(cRepo.getById(id));
	}
	
	@Transactional
	public CharmDto createCharm(Charm charm) {
		return new CharmDto(cRepo.save(charm));
	}
	
	@Transactional
	public CharmDto updateCharm(Charm charm) {
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
			return new CharmDto(cRepo.save(charmUpdate));
	}
	
	@Transactional
	public void deleteCharm(int id) {
		Charm charm = cRepo.getById(id);
		cRepo.delete(charm);
	}
	
	
}
