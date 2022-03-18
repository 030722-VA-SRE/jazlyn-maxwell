package com.revature.controllers;

import com.revature.services.CharmService;

import io.javalin.http.Context;

public class CharmController {

	private static CharmService cServ = new CharmService();
	
	public static void createCharm(Context ctx) {
		//TODO
	}
	
	public static void getCharms(Context ctx) {
		ctx.json(cServ.getCharms());
	}
	
	public static void getCharmById(Context ctx) {
		//TODO
	}
	
	public static void updateCharm(Context ctx) {
		//TODO
	}
	
	public static void deleteCharm(Context ctx) {
		//TODO
	}
}
