package com.revature.controllers;

import java.util.List;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class UserController {

	private static UserService uServ = new UserService();
	private static AuthService aServ = new AuthService();
	
	public static void createUser(Context ctx) {
		User user = ctx.bodyAsClass(User.class);

		if (uServ.createUser(user) > 0) {
			ctx.status(201);
		}
		else {
			ctx.status(400);
			ctx.result("Unable to create user.");
		}
	}
	
	public static void getUsers(Context ctx) {
		String token = ctx.header("Authorization");
		
		if (!aServ.checkPermission(token, Role.SELLER, Role.ADMIN)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}
		
		String email = ctx.queryParam("email");
		
		if (email != null) {
			User user = uServ.getUserByEmail(email);
			if (user != null) {
				ctx.json(user);
				ctx.status(HttpCode.OK);
			}
			else {
				ctx.status(HttpCode.NOT_FOUND);
			}
		}
		else {
			List<User> users = uServ.getUsers();
			ctx.json(users);
			ctx.status(HttpCode.OK);
		}
	}
	
	public static void getUserById(Context ctx) {
		String token = ctx.header("Authorization");
		
		if (!aServ.checkPermission(token, Role.USER, Role.SELLER, Role.ADMIN)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}
		
		int id = Integer.parseInt(ctx.pathParam("id"));
		User user = uServ.getUserById(id);
		if (user != null) {
			ctx.json(user);
			ctx.status(HttpCode.OK);
		}
		else {
			ctx.status(HttpCode.NOT_FOUND);
			ctx.result("No user found with id " + id);
		}
		
	}
	
	public static void updateUser(Context ctx) {
		String token = ctx.header("Authorization");
		
		if (!aServ.checkPermission(token, Role.USER, Role.SELLER, Role.ADMIN)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}
		
		int id = Integer.parseInt(ctx.pathParam("id"));
		User user = ctx.bodyAsClass(User.class);
		user.setId(id);
		if (uServ.updateUser(user)) {
			ctx.status(HttpCode.OK);
			ctx.result("Updated user with id " + id);
		}
		else {
			ctx.status(400);
			ctx.result("No user found with id " + id);
		}
	}
	
	public static void updateUserAdmin(Context ctx) {
		String token = ctx.header("Authorization");
		
		if (!aServ.checkPermission(token, Role.ADMIN)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}
		
		int id = Integer.parseInt(ctx.pathParam("id"));
		User user = ctx.bodyAsClass(User.class);
		user.setId(id);
		if (uServ.updateUserAdmin(user)) {
			ctx.status(HttpCode.OK);
			ctx.result("Updated user with id " + id);
		}
		else {
			ctx.status(400);
			ctx.result("No user found with id " + id);
		}
	}
	
	public static void deleteUser(Context ctx) {
		String token = ctx.header("Authorization");
		
		if (!aServ.checkPermission(token, Role.ADMIN)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}

		int id = Integer.parseInt(ctx.pathParam("id"));
		if (uServ.deleteUser(id)) {
			ctx.status(HttpCode.OK);
			ctx.result("Deleted user with id " + id);
		}
		else {
			ctx.status(400);
			ctx.result("No user found with id " + id);
		}
	}
}
