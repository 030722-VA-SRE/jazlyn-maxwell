package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Charm;
import com.revature.utils.ConnectionUtil;

public class CharmPostgres implements CharmDao {

	@Override
	public int createCharm(Charm charm) {
		String sql = "insert into charms (charm_name, charm_desc, charm_price, charm_region, charm_country, user_id) values (?, ?, ?, ?, ?, ?);";
		int generated_pk = -1;
		
		try(Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, charm.getName());
			ps.setString(2,  charm.getDescription());
			ps.setInt(3, charm.getPrice());
			ps.setString(4, charm.getRegion());
			ps.setString(5, charm.getCountry());
			ps.setInt(6, charm.getSellerId());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				generated_pk = rs.getInt(1);
				System.out.println(generated_pk);
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return generated_pk;
	}

	@Override
	public List<Charm> getCharms() {
		String sql = "select * from charms as c\r\n"
				+ "join users as u on c.user_id = u.user_id\r\n"
				+ "order by charm_id;";
		List<Charm> charms = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnection()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				Charm charm = new Charm(
						rs.getInt("charm_id"),
						rs.getString("charm_name"),
						rs.getString("charm_desc"),
						rs.getInt("charm_price"),
						rs.getString("charm_region"),
						rs.getString("charm_country"),
						rs.getInt("user_id"));
				
				charms.add(charm);
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		return charms;
	}

	@Override
	public Charm getCharmById(int id) {
		String sql = "select * from charms as c\r\n"
				+ "join users as u on c.user_id = u.user_id \r\n"
				+ "where charm_id = ?;";
		Charm charm = null;
		
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				charm = new Charm(
						rs.getInt("charm_id"),
						rs.getString("charm_name"),
						rs.getString("charm_desc"),
						rs.getInt("charm_price"),
						rs.getString("charm_region"),
						rs.getString("charm_country"),
						rs.getInt("user_id"));
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		return charm;
	}

	@Override
	public boolean updateCharm(Charm charm) {
		String sql = "update charms set\r\n"
				+ "charm_name = ?, charm_desc = ?, charm_price = ?, charm_region = ?, charm_country = ?, user_id = ?\r\n"
				+ "where charm_id = ?";
		
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, charm.getName());
			ps.setString(2,  charm.getDescription());
			ps.setInt(3, charm.getPrice());
			ps.setString(4, charm.getRegion());
			ps.setString(5, charm.getCountry());
			ps.setInt(6, charm.getSellerId());
			ps.setInt(7, charm.getId());
			int row = ps.executeUpdate();
			if (row == 0) {
				return false;
			}
			return true;
		}
		catch (SQLException ex) { 
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCharm(int id) {
		String sql = "delete from charms where charm_id = ?;";
		
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
		}
		return false;
	}
	
}
