package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDao {
	public int createUser(User user);
	public List<User> getUsers();
	public User getUserById(int id);
	public User getUserByEmail(String email);
	public boolean updateUser(User user);
	public boolean deleteUser(int id);
}
