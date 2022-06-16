package com.yedam.java.emp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocDAO extends ConnectHR {
	private static LocDAO locDAO = null;
	private LocDAO() {}
	public static LocDAO getInstance() {
		if(locDAO == null) {
			locDAO = new LocDAO();
		}
		return locDAO;
	}
	
	void insert(Location loc) {
		String sql = "INSERT INTO locations VALUE(?,?,?,?,?,?)";
		int result = 0;
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, loc.getLocationId());
			pstmt.setString(2, loc.getStreetAddress());
			pstmt.setString(3, loc.getPostalCode());
			pstmt.setString(4, loc.getCity());
			pstmt.setString(5, loc.getStateProvince());
			pstmt.setString(6, loc.getCountryId());
			result = pstmt.executeUpdate();			
		} catch (SQLException e) {
			System.out.println("");
		} finally {
			disconnect();
			System.out.println(result + "개의 행이 추가되었습니다.");
		}
	}
	
	void update(Location loc) {
		String sql = "UPDATE locations SET street_address = ? WHERE location_id=?";
		int result = 0;
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loc.getStreetAddress());
			pstmt.setInt(2, loc.getLocationId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("");
		} finally {
			disconnect();
			System.out.println(result + "개의 행이 변경되었습니다.");
		}
	}
	
	void delete(int locId) {
		String sql = "DELETE FROM locations WHERE location_id=" + locId;
		int result=0;
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				result++;
			}
		} catch (Exception e) {
			System.out.println("");
		} finally {
			disconnect();
			System.out.println( result + "개의 행이 삭제되었습니다.");
		}
	}
	
	List<Location> selectAll() {
		List<Location> list = new ArrayList<>();
		String sql = "SELECT * FROM locations";
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Location loc = new Location();
				loc.setCity(rs.getString("city"));
				loc.setCountryId(rs.getString("country_id"));
				loc.setLocationId(rs.getInt("location_id"));
				loc.setPostalCode(rs.getString("postal_code"));
				loc.setStateProvince(rs.getString("state_province"));
				loc.setStreetAddress(rs.getString("street_address"));
				list.add(loc);
			}
		} catch (Exception e) {
			System.out.println("전체보기에서 오류가 발생하였습니다.");
		} finally {
			disconnect();
		}
		return list;
	}
	
	Location selectOne(int locId) {
		Location loc = new Location();
		String sql = "SELECT * FROM locations WHERE location_id=?";
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, locId);
			rs = pstmt.executeQuery();
			rs.next();			
			loc.setCity(rs.getString("city"));
			loc.setCountryId(rs.getString("country_id"));
			loc.setLocationId(rs.getInt("location_id"));
			loc.setPostalCode(rs.getString("postal_code"));
			loc.setStateProvince(rs.getString("state_province"));
			loc.setStreetAddress(rs.getString("street_address"));
		} catch (Exception e) {
			System.out.println("단건보기에서 오류가 발생하였습니다.");
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return loc;
	}
}
