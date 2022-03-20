package com.revature;

import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import com.revature.controllers.CharmController;

import io.javalin.Javalin;

public class Driver {
	
	public static void main(String[] args) {
		Javalin app = Javalin.create((config) -> {
			config.defaultContentType = "application/json";
		});
		
		app.start(8080);
		
		app.routes(() -> {
			path("charm", () -> {
				get(CharmController::getCharms);
				post(CharmController::createCharm);
				put(CharmController::updateCharm);
				
				path("{id}", () -> {
					get(CharmController::getCharmById);
					delete(CharmController::deleteCharm);
				});
			});
		});
	}
}
