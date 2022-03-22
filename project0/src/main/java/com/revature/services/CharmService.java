package com.revature.services;

import java.util.List;
import java.util.Map;

import com.revature.daos.CharmDao;
import com.revature.daos.CharmPostgres;
import com.revature.models.Charm;

public class CharmService {

	private CharmDao cDao;
	
	public CharmService() {
		cDao = new CharmPostgres();
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
		return cDao.updateCharm(charm);
	};
	
	public boolean deleteCharm(int id) {
		return cDao.deleteCharm(id);
	}
}
