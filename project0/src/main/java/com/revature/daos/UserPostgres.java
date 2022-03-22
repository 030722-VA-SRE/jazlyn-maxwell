package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserPostgres implements UserDao {

	private static Logger log = LogManager.getLogger(UserDao.class);
	private static UserDao uDao;
	
	private UserPostgres() {}
	public static UserDao getInstance() {
		if (uDao == null) {
			uDao = new UserPostgres();
		}
		return uDao;
	}
	
	@Override
	public int createUser(User user) {
		String sql = "insert into users(user_name, user_email, user_pass, user_balance) "
				+ "values (?, ?, ?, ?);";
		int generated_pk = -1;
		
		try(Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getName());
			ps.setString(2,  user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getBalance());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				generated_pk = rs.getInt(1);
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			log.error(ex.getMessage());
		}
		return generated_pk;
	}

	@Override
	public List<User> getUsers() {
		String sql = "select *  from users order by user_id;";
		List<User> users = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnection()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				User user = new User(
						rs.getInt("user_id"),
						rs.getString("user_name"),
						rs.getString("user_email"),
						rs.getString("user_pass"),
						rs.getInt("user_balance"));
				users.add(user);
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			log.error(ex.getMessage());
		}
		return users;
	}

	@Override
	public User getUserById(int id) {
		String sql = "select *  from users "
				+ "where user_id = ? "
				+ "order by user_id;";
		User user = null;
		
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				user = new User(
						rs.getInt("user_id"),
						rs.getString("user_name"),
						rs.getString("user_email"),
						rs.getString("user_pass"),
						rs.getInt("user_balance"));
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			log.error(ex.getMessage());
		}
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		String sql = "select *  from users "
				+ "where user_email = ? "
				+ "order by user_id;";
		User user = null;
		
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				user = new User(
						rs.getInt("user_id"),
						rs.getString("user_name"),
						rs.getString("user_email"),
						rs.getString("user_email"),
						rs.getInt("user_balance"));
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			log.error(ex.getMessage());
		}
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		String sql = "update users set user_name = ?, user_email = ?, user_pass = ?, user_balance = ? "
				+ "where user_id = ?;";
		
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2,  user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getBalance());
			ps.setInt(6, user.getId());
			int row = ps.executeUpdate();
			if (row > 0) {
				return true;
			}
		}
		catch (SQLException ex) {
			ex.getStackTrace();
			log.error(ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		String sql = "delete from users where user_id = ?;";
		
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int row = ps.executeUpdate();
			if (row == 0) {
				return false;
			}
			return true;
		}
		catch (SQLException ex) { 
			ex.printStackTrace();
			log.error(ex.getMessage());
		}
		return false;
	}

}
