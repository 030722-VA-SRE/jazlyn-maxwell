package com.revature;

import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.controllers.CharmController;

import io.javalin.Javalin;

public class Driver {
	
	private static Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		Javalin app = Javalin.create((config) -> {
			config.defaultContentType = "application/json";
		});
		
		app.start(8080);
		log.info("Started Javalin app");
		
		app.routes(() -> {
			path("charm", () -> {
				get(CharmController::getCharms);
				post(CharmController::createCharm);
				
				path("{id}", () -> {
					get(CharmController::getCharmById);
					put(CharmController::updateCharm);
					delete(CharmController::deleteCharm);
				});
			});
		});
	}
}
