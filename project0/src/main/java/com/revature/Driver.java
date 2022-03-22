package com.revature;

import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.controllers.AuthController;
import com.revature.controllers.CharmController;
import com.revature.controllers.UserController;

import io.javalin.Javalin;

public class Driver {
	
	private static Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		Javalin app = Javalin.create((config) -> {
			config.enableCorsForAllOrigins();
			config.defaultContentType = "application/json";
		});
		
		app.start(8080);
		log.info("Started Javalin app");
		
		app.before(ctx -> {
			ctx.header("Access-Control-Allow-Headers", "Authorization");
			ctx.header("Access-Control-Expose-Headers", "Authorization");
		});
		
		app.routes(() -> {
			path("charms", () -> {
				get(CharmController::getCharms);
				post(CharmController::createCharm);
				
				path("{id}", () -> {
					get(CharmController::getCharmById);
					put(CharmController::updateCharm);
					delete(CharmController::deleteCharm);
				});
			});
			path("users", () -> {
				get(UserController::getUsers);
				post(UserController::createUser);
				
				path("{id}", () -> {
					get(UserController::getUserById);
					put(UserController::updateUser);
					delete(UserController::deleteUser);
					
					path("admin", () -> {
						put(UserController::updateUserAdmin);
					});
				});
				path("login", () -> {
					post(AuthController::login);
				});
			});
		});
	}
}
