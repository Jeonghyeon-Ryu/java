package crawling;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO extends DAO {
	public void insert(Room room) {
		try {
			connect();
			String sql = "INSERT INTO room(room_id,acc_id,name,price,is_reservation,info) VALUES(?,?,?,?,0,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, room.getAccId());
			pstmt.setInt(2, room.getRoomId());
			pstmt.setString(3, room.getName());
			pstmt.setString(4, room.getPrice());
			pstmt.setString(5, room.getInfo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	// 전체 조회
	public List<Room> selectAll() {
		connect();
		String sql = "select * from room order by 1";
		List<Room> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Room vo = new Room();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setRoomId(rs.getInt("ROOM_ID"));
				vo.setIsReservation(rs.getInt("IS_RESERVATION"));
				vo.setName(rs.getString("NAME"));
				vo.setPrice(rs.getString("PRICE"));
				vo.setReservationTime(rs.getDate("RESERVATION_TIME"));
				vo.setInfo(rs.getString("INFO"));
				list.add(vo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	// 단건 조회 - roomId
	public Room selectOne(Room room) {
		String sql = "select * from room where room_id =?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, room.getRoomId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Room vo = new Room();
				vo.setAccId(rs.getInt("ACC_ID"));
				vo.setInfo(rs.getString("INFO"));
				vo.setIsReservation(rs.getInt("IS_RESERVATION"));
				vo.setName(rs.getString("NAME"));
				vo.setPrice(rs.getString("PRICE"));
				vo.setReservationTime(rs.getDate("RESERVATION_TIME"));
				vo.setRoomId(rs.getInt("ROOM_ID"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	//삭제
	public void delete(Room room) {
		String sql = "delete room where room_id=?";
		connect(); 
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, room.getRoomId());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 업데이트.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
}
