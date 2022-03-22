package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Charm;
import com.revature.utils.ConnectionUtil;

public class CharmPostgres implements CharmDao {
	
	private static Logger log = LogManager.getLogger(CharmDao.class);

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
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			log.error(ex.getMessage());
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
			log.error(ex.getMessage());
		}
		return charms;
	}
	
	@Override
	public List<Charm> getCharmsByParam(Map<String, List<String>> queryParamMap) {
		String sql = "select * from charms as c\r\n"
				+ "join users as u on c.user_id = u.user_id where ";
		Map<Integer, String> statementParams = new HashMap<Integer, String>();
		int paramKey = 1;
		
		for (Map.Entry<String, List<String>> queryParam : queryParamMap.entrySet()) {
			String key = queryParam.getKey();
			String value = queryParam.getValue().get(0);
			
			switch (key) {
			case "id":
				sql += "charm_id = ? and ";
				break;
			case "name":
				sql += "charm_name like ? and ";
				break;
			case "description":
				sql += "charm_desc like ? and ";
				break;
			case "price":
				sql += "charm_price = ? and ";
				break;
			case "region":
				sql += "charm_region like ? and ";
				break;
			case "country":
				sql += "charm_country like ? and ";
				break;
			case "sellerId":
				sql += "c.user_id = ? and ";
				break;
			default:
				break;
			}
			statementParams.put(paramKey, value);
			paramKey++;
		}
		
		sql += "true;";
		
		List<Charm> charms = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			for (Map.Entry<Integer, String> statementParam : statementParams.entrySet()) {
				if (isInteger(statementParam.getValue())) {
					ps.setInt(statementParam.getKey(), Integer.parseInt(statementParam.getValue()));
				}
				else {
					ps.setString(statementParam.getKey(), "%" + statementParam.getValue() + "%");
				}
			}
			
			ResultSet rs = ps.executeQuery();
			
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
			log.error(ex.getMessage());
		}
		return charms;
	}

	@Override
	public Charm getCharmById(int id) {
		String sql = "select * from charms as c "
				+ "join users as u on c.user_id = u.user_id "
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
			log.error(ex.getMessage());
		}
		return charm;
	}

	@Override
	public boolean updateCharm(Charm charm) {
		String sql = "update charms set "
				+ "charm_name = ?, charm_desc = ?, charm_price = ?, charm_region = ?, charm_country = ?, user_id = ? "
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
			if (row > 0) {
				return true;
			}
		}
		catch (SQLException ex) { 
			ex.printStackTrace();
			log.error(ex.getMessage());
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
			log.error(ex.getMessage());
		}
		return false;
	}
	
	// Helper function
	public static boolean isInteger(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        Integer.parseInt(strNum);
	    } catch (NumberFormatException ex) {
	        return false;
	    }
	    return true;
	}
	
}
