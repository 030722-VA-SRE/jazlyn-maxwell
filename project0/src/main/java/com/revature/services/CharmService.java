package com.revature.services;

import java.util.List;

import com.revature.daos.CharmDao;
import com.revature.daos.CharmPostgres;
import com.revature.models.Charm;

public class CharmService {

	private CharmDao cDao;
	
	public CharmService() {
		cDao = new CharmPostgres();
	}
	
	public int createCharm(Charm charm) {
		return cDao.createCharm(charm);
	};
	
	public List<Charm> getCharms() {
		return cDao.getCharms();
	}
	
	public Charm getCharmById(int id) {
		return cDao.getCharmById(id);
	};

	public boolean updateCharm(Charm charm) {
		return cDao.updateCharm(charm);
	};
	
	public boolean deleteCharm(int id) {
		return cDao.deleteCharm(id);
	};
}
