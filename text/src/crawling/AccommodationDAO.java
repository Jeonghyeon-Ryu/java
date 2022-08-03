package crawling;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AccommodationDAO extends DAO {
	public void insert(Accommodation acc) {
		connect();
		String sql = "INSERT INTO accommodation VALUES(?,?,?,0,?,1,?,?,sysdate,?)"; 
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acc.getAccId());
			pstmt.setString(2, acc.getName());
			pstmt.setString(3, acc.getAddress());
			pstmt.setString(4, acc.getPhone());
			pstmt.setDouble(5, acc.getPointX());
			pstmt.setDouble(6, acc.getPointY());
			pstmt.setString(7, acc.getImgUrl());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	// 전체 조회
	public List<Accommodation> selectAll() {
		List<Accommodation> list = new ArrayList<>();
		try {
			connect();
			System.out.println("aaa");
			String sql = "SELECT * FROM accommodation ORDER BY 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Accommodation vo = new Accommodation();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setAddress(rs.getString("ADDRESS"));
				vo.setName(rs.getString("NAME"));
				vo.setPhone(rs.getString("PHONE"));
				vo.setPointX(rs.getDouble("POINT_X"));
				vo.setPointY(rs.getDouble("POINT_Y"));
				vo.setRenewalTime(rs.getDate("RENEWAL_TIME"));
				vo.setStatus(rs.getInt("STATUS"));
				vo.setZipcode(rs.getString("ZIPCODE"));
				vo.setImgUrl(rs.getString("IMG_URL"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	// 단건 조회 - ADDRESS 
	public List<Accommodation> selectOneAddress(String city) {
		List<Accommodation> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM accommodation WHERE address LIKE '%"+city+"%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				Accommodation vo = new Accommodation();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setAddress(rs.getString("ADDRESS"));
				vo.setName(rs.getString("NAME"));
				vo.setPhone(rs.getString("PHONE"));
				vo.setPointX(rs.getDouble("POINT_X"));
				vo.setPointY(rs.getDouble("POINT_Y"));
				vo.setRenewalTime(rs.getDate("RENEWAL_TIME"));
				vo.setStatus(rs.getInt("STATUS"));
				vo.setZipcode(rs.getString("ZIPCODE"));
				vo.setImgUrl(rs.getString("IMG_URL"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	public List<Accommodation> selectOneAddress(String city, String region) {
		List<Accommodation> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM accommodation WHERE address LIKE '%"+city+"%' AND address LIKE '%"+region+"%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				Accommodation vo = new Accommodation();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setAddress(rs.getString("ADDRESS"));
				vo.setName(rs.getString("NAME"));
				vo.setPhone(rs.getString("PHONE"));
				vo.setPointX(rs.getDouble("POINT_X"));
				vo.setPointY(rs.getDouble("POINT_Y"));
				vo.setRenewalTime(rs.getDate("RENEWAL_TIME"));
				vo.setStatus(rs.getInt("STATUS"));
				vo.setZipcode(rs.getString("ZIPCODE"));
				vo.setImgUrl(rs.getString("IMG_URL"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	// 단건 조회 - ACC_ID
	public Accommodation selectOne(int accId) {
		String sql = "SELECT * FROM accommodation WHERE acc_id =?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Accommodation vo = new Accommodation();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setAddress(rs.getString("ADDRESS"));
				vo.setName(rs.getString("NAME"));
				vo.setPhone(rs.getString("PHONE"));
				vo.setPointX(rs.getDouble("POINT_X"));
				vo.setPointY(rs.getDouble("POINT_Y"));
				vo.setRenewalTime(rs.getDate("RENEWAL_TIME"));
				vo.setStatus(rs.getInt("STATUS"));
				vo.setZipcode(rs.getString("ZIPCODE"));
				vo.setImgUrl(rs.getString("IMG_URL"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 삭제 - QNA_ID
	public void delete(int accId) {
		String sql = "DELETE FROM accommodation WHERE ACC_ID=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accId);
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 업데이트.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
