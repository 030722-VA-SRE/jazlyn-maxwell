package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Charm;
import com.revature.models.Region;
import com.revature.utils.ConnectionUtil;

public class CharmPostgres implements CharmDao {

	@Override
	public int createCharm(Charm charm) {
		String sql = "";
		return 0;
	}

	@Override
	public List<Charm> getCharms() {
		String sql = "select * from charms as c\r\n"
				+ "join users as u on c.user_id = u.user_id \r\n"
				+ "join regions as r on c.region_id = r.region_id;";
		List<Charm> charms = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnection()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				Region region = new Region(
						rs.getInt("region_id"),
						rs.getString("region_name"),
						rs.getString("region_country"));
				Charm charm = new Charm(
						rs.getInt("charm_id"),
						rs.getString("charm_name"),
						rs.getString("charm_desc"),
						rs.getInt("charm_price"),
						region,
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
				+ "join regions as r on c.region_id = r.region_id \r\n"
				+ "where charm_id = ?;";
		Charm charm = null;
		
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Region region = new Region(
						rs.getInt("region_id"),
						rs.getString("region_name"),
						rs.getString("region_country"));
				charm = new Charm(
						rs.getInt("charm_id"),
						rs.getString("charm_name"),
						rs.getString("charm_desc"),
						rs.getInt("charm_price"),
						region,
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCharm(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
