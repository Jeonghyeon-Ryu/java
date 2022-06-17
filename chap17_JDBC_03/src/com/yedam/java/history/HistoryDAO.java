package com.yedam.java.history;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.yedam.app.common.DAO;

public class HistoryDAO extends DAO {
	private static HistoryDAO historyDAO = null;
	private HistoryDAO() {}
	public static HistoryDAO getInstance() {
		if(historyDAO == null) {
			historyDAO = new HistoryDAO();
		}
		return historyDAO;
	}
	// 등록 : 거의 변화없다. 
	public void insert(History history) {
		int result = 0;
		try {
			connect();
			String sql = "INSERT INTO product_history VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getProductId());
			pstmt.setInt(2, history.getProductCategory());
			pstmt.setInt(3, history.getProductAmount());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("오류가 발생하였습니다. : " + e.toString());
		} finally {
			disconnect();
			System.out.println(result + "개의 행이 추가되었습니다.");
		}
	}
	// 수정 : 어떤걸 수정할지에 따라 변할 수 있다. ( 여기서는 수량 수정 )
	public void update(History history) {
		int result = 0; 
		try {
			connect();
			String sql = "UPDATE product_history SET product_amount=? WHERE product_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getProductAmount());
			pstmt.setInt(2, history.getProductId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("오류가 발생하였습니다. : " + e.toString());
		} finally {
			disconnect();
			System.out.println(result + "개의 행이 수정되었습니다.");
		}
	}
	// 삭제 : 거의 변화없다.
	public void delete(History history) {
		int result = 0;
		try {
			connect();
			String sql = "DELETE FROM product_history WHERE product_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getProductId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("오류가 발생하였습니다. : " + e.toString());
		} finally{
			disconnect();
			System.out.println(result + "개의 행이 삭제되었습니다.");
		}
	}
	// 단건조회 : 각 상품에 대한 입고
	public int selectInAmount(int productId) {
		int result = 0;
		try {
			connect();
			String sql = "SELECT SUM(product_amount) FROM product_history WHERE product_id=? AND product_category=1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("오류가 발생하였습니다. : " + e.toString());
		} finally {
			disconnect();
		}
		
		return result;
	}
	// 단건조회 : 각 상품에 대한 출고
	public int selectOutAmount(int productId) {
		int result = 0;
		try {
			connect();
			String sql = "SELECT SUM(product_amount) FROM product_history WHERE product_id=? AND product_category=2";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("오류가 발생하였습니다. : " + e.toString());
		} finally {
			disconnect();
		}
		
		return result;
	}
	public History selectOne(int productId) {
		History history = new History();
		history.setProductId(productId);
		try {
			connect();
			String sql = "SELECT product_id, product_category, SUM(product_amount) FROM product_history WHERE product_id = ? GROUP BY product_id,product_category ORDER BY 1,2";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("SUM(product_amount)"));
				if(rs.getInt("product_category")==1) {
					history.setProductAmount(history.getProductAmount()+rs.getInt(3));
				} else if(rs.getInt("product_category")==2) {
					history.setProductAmount(history.getProductAmount()-rs.getInt(3));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return history;
	}
	// 전체조회 : 전체 상품의 각 재고
	public Map<Integer, Integer> selectAll() {
		Map<Integer,Integer> list = new HashMap<>();
		try {
			connect();
			String sql = "SELECT product_id, product_category, SUM(product_amount)"
					+ " FROM product_history GROUP BY product_id,product_category ORDER BY 1,2";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			Map<Integer, Integer> inList = new HashMap<>();
			Map<Integer, Integer> outList = new HashMap<>();
			while(rs.next()) {
				int category = rs.getInt("product_category");
				if(category==1) {
					inList.put(rs.getInt("product_id"), rs.getInt("SUM(product_amount)"));
				} else {
					outList.put(rs.getInt("product_id"), rs.getInt("SUM(product_amount)"));
				}
			}
			Set<Integer> keySet = inList.keySet();
			for(int key : keySet) {
				int inAmount = inList.get(key);
				Integer outAmount = outList.get(key);
				if(outAmount != null) {
					list.put(key, inAmount - outAmount);
				} else {
					list.put(key, inAmount);
				}
			}
		} catch (Exception e) {
			System.out.println("오류가 발생하였습니다. : " + e.toString());
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
	}
}
