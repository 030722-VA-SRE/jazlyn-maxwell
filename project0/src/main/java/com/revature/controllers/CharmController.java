package com.revature.controllers;

import org.eclipse.jetty.http.HttpStatus;

import com.revature.models.Charm;
import com.revature.services.CharmService;

import io.javalin.http.Context;

public class CharmController {

	private static CharmService cServ = new CharmService();
	
	public static void createCharm(Context ctx) {
		Charm charm = ctx.bodyAsClass(Charm.class);
		
		if (cServ.createCharm(charm) > 0) {
			ctx.status(201);
		}
		else {
			ctx.status(400);
			ctx.result("Unable to create charm.");
		}
	}
	
	public static void getCharms(Context ctx) {
		System.out.println(ctx.queryParamMap().getClass());
		ctx.json(cServ.getCharms());
	}
	
	public static void getCharmById(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		ctx.json(cServ.getCharmById(id));
	}
	
	public static void updateCharm(Context ctx) {
		Charm charm = ctx.bodyAsClass(Charm.class);
		
		if (cServ.updateCharm(charm)) {
			ctx.status(201);
			ctx.result("Updated charm with id " + charm.getId());
		}
		else {
			ctx.status(400);
			ctx.result("No charm found with id " + charm.getId());
		}
	}
	
	public static void deleteCharm(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		if(cServ.deleteCharm(id)) {
			ctx.status(200);
			ctx.result("Deleted charm with id " + id);
		}
		else {
			ctx.status(400);
			ctx.result("No charm found with id " + id);
		}
	}
}
