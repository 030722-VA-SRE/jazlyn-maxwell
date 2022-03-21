package com.revature.daos;

import java.util.List;
import java.util.Map;

import com.revature.models.Charm;

public interface CharmDao {
	public int createCharm(Charm charm);
	public List<Charm> getCharms();
	public List<Charm> getChamsByParam(Map<String, List<String>> queryParamMap);
	public Charm getCharmById(int id);
	public boolean updateCharm(Charm charm);
	public boolean deleteCharm(int id);
}
