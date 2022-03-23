package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.daos.UserDao;
import com.revature.models.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	static UserDao uDao;
	static UserService uServ;
	static List<User> users = new ArrayList<>();
	static User user1;
	static User user2;
	
	@BeforeAll
	public static void init() {
		uDao = mock(UserDao.class);
		uServ = new UserService(uDao);
		user1 = new User(1, "test", "user@test.com", "user", 100);
		user2 = new User(1, "test2", "user2@test.com", "user2", 350);
		users.add(user1);
		users.add(user2);
	}
	
	@Test
	public void testCreateUser() {
		when(uDao.createUser(any(User.class))).thenReturn(1);
		assertEquals(1, uServ.createUser(user1));
	}
	
	@Test
	public void testGetUsers() {
		when(uDao.getUsers()).thenReturn(users);
		assertEquals(users, uServ.getUsers());
	}
	
	@Test
	public void testGetUserById() {
		when(uDao.getUserById(anyInt())).thenReturn(user1);
		assertEquals(user1, uServ.getUserById(1));
	}

	@Test
	public void testGetCharmsByParam() {
		when(uDao.getUserByEmail(anyString())).thenReturn(user1);
		assertEquals(user1, uServ.getUserByEmail("user@test.com"));
	}

	@Test
	public void testUpdateUser() {
		when(uDao.getUserById(anyInt())).thenReturn(user1);
		when(uDao.updateUser(any(User.class))).thenReturn(true);
		assertEquals(true, uServ.updateUser(user2));
	}
	
	@Test
	public void testDeleteUser() {
		when(uDao.deleteUser(anyInt())).thenReturn(true);
		assertEquals(true, uServ.deleteUser(1));
	}

}
