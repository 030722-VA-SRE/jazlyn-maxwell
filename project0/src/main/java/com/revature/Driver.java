package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Charm;

import io.javalin.Javalin;

public class Driver {
	
	private static List<Charm> charms = new ArrayList<>();

	public static void main(String[] args) {
//		Javalin app = Javalin.create((config) -> {
//			
//		});
//		
//		app.start();
//		
//		Charm c1 = new Charm("Horseshoe", 
//				"Purple object that increases luck by 15% found in the forests of the South.", 
//				500);
//		Charm c2 = new Charm("Medal of Devastation",
//				"Increases the attack power of the wearer by over 9000.",
//				1200);
//		
//		charms.add(c1);
//		
//		app.get("charms", (ctx) -> {
//			ctx.json(charms);
//		});
//		
//		app.get("charms/{id}", (ctx) -> {
//			int id = Integer.parseInt(ctx.pathParam("id"));
//			Charm c = null;
//			
//			for (Charm charm : charms) {
//				if (charm.getId() == id) {
//					c = charm;
//				}
//			}
//			
//			if (c == null) {
//				ctx.status(404);
//			}
//			else {
//				ctx.json(c);
//			}
//		});
		
	}
}
