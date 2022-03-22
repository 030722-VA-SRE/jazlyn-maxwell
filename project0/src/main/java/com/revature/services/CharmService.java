package com.revature.services;

import java.util.List;
import java.util.Map;

import com.revature.daos.CharmDao;
import com.revature.daos.CharmPostgres;
import com.revature.models.Charm;

public class CharmService {

	private CharmDao cDao;
	
	public CharmService() {
		cDao = CharmPostgres.getInstance();
	}
	
	// for testing
	public CharmService(CharmDao cDao) {
		this.cDao = cDao;
	}
	
	public int createCharm(Charm charm) {
		return cDao.createCharm(charm);
	};
	
	public List<Charm> getCharms() {
		return cDao.getCharms();
	}

	public List<Charm> getCharmsByParam(Map<String, List<String>> queryParamMap) {
		return cDao.getCharmsByParam(queryParamMap);
	};
	
	public Charm getCharmById(int id) {
		return cDao.getCharmById(id);
	};

	public boolean updateCharm(Charm charm) {
		Charm charmUpdate = cDao.getCharmById(charm.getId());
		
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
		if (charm.getRegion() != null && !charm.getRegion().equals(charmUpdate.getRegion())) {
			charmUpdate.setRegion(charm.getRegion());
		}
		if (charm.getCountry() != null && !charm.getCountry().equals(charmUpdate.getCountry())) {
			charmUpdate.setCountry(charm.getCountry());
		}
		if (charm.getSeller() != null && charm.getSeller().getId() != charmUpdate.getSeller().getId()) {
			charmUpdate.getSeller().setId(charm.getSeller().getId());
		}
		
		return cDao.updateCharm(charmUpdate);
	};
	
	public boolean deleteCharm(int id) {
		return cDao.deleteCharm(id);
	}
}
