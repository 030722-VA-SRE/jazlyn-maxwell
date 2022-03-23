package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.daos.CharmDao;
import com.revature.models.Charm;

@ExtendWith(MockitoExtension.class)
public class CharmServiceTest {

	static CharmDao cDao;
	static CharmService cServ;
	static Map<String, List<String>> queryParams;
	static List<Charm> charms = new ArrayList<>();
	static Charm charm1;
	static Charm charm2;
	
	@BeforeAll
	public static void init() {
		cDao = mock(CharmDao.class);
		cServ = new CharmService(cDao);
		queryParams = new HashMap<>();
		charm1 = new Charm(1, "test", "info", 300, "test", "test", 1);
		charm2 = new Charm(1, "test2", "info2", 50, "tes2", "test2", 2);
		charms.add(charm1);
	}
	
	@Test
	public void testCreateCharm() {
		when(cDao.createCharm(any(Charm.class))).thenReturn(1);
		assertEquals(1, cServ.createCharm(charm1));
	}
	
	@Test
	public void testGetCharms() {
		when(cDao.getCharms()).thenReturn(charms);
		assertEquals(charms, cServ.getCharms());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetCharmsByParam() {
		when(cDao.getCharmsByParam(any(Map.class))).thenReturn(charms);
		assertEquals(charms, cServ.getCharmsByParam(queryParams));
	}
	
	@Test
	public void testGetCharmById() {
		when(cDao.getCharmById(anyInt())).thenReturn(charm1);
		assertEquals(charm1, cServ.getCharmById(1));
	}

	@Test
	public void testUpdateCharm() {
		when(cDao.getCharmById(anyInt())).thenReturn(charm1);
		when(cDao.updateCharm(any(Charm.class))).thenReturn(true);
		assertEquals(true, cServ.updateCharm(charm2));
	}
	
	@Test
	public void testDeleteCharm() {
		when(cDao.deleteCharm(anyInt())).thenReturn(true);
		assertEquals(true, cServ.deleteCharm(1));
	}
}
