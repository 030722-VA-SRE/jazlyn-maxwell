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
	
	public List<Charm> getCharms() {
		return cDao.getCharms();
	}
}
