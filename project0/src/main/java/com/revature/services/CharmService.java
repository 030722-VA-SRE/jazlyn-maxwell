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
		Charm charm_update = cDao.getCharmById(charm.getId());
		
		// Validate input
		if (charm.getName() != null && !charm.getName().equals(charm_update.getName())) {
			charm_update.setName(charm.getName());
		}
		if (charm.getDescription() != null && !charm.getDescription().equals(charm_update.getDescription())) {
			charm_update.setDescription(charm.getDescription());
		}
		if (charm.getPrice() != charm_update.getPrice()) {
			charm_update.setPrice(charm.getPrice());
		}
		if (charm.getRegion() != null && !charm.getRegion().equals(charm_update.getRegion())) {
			charm_update.setRegion(charm.getRegion());
		}
		if (charm.getCountry() != null && !charm.getCountry().equals(charm_update.getCountry())) {
			charm_update.setCountry(charm.getCountry());
		}
		if (charm.getSeller() != null && charm.getSeller().getId() != charm_update.getSeller().getId()) {
			charm_update.getSeller().setId(charm.getSeller().getId());
		}
		
		return cDao.updateCharm(charm_update);
	};
	
	public boolean deleteCharm(int id) {
		return cDao.deleteCharm(id);
	}
}
