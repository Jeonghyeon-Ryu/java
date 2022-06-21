package com.yedam.app.deal;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class TakeOutGoodsDAO extends DAO {
	private static TakeOutGoodsDAO tDAO = null;
	private TakeOutGoodsDAO() {	}
	public static TakeOutGoodsDAO getInstance() {
		if(tDAO == null) {
			tDAO = new TakeOutGoodsDAO();
		}
		return tDAO;
	}
	// 등록
	public void insert(DealInfo info) {
		int result = 0;
		try {
			connect();
			String sql = "INSERT INTO take_out_goods(product_id,product_amount) VALUES(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getProductId());
			pstmt.setInt(2, info.getProductAmount());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("등록에 실패하였습니다 : " + e.toString());
		} finally {
			disconnect();
			System.out.println(result + "개의 행이 추가되었습니다.");
		}
	}
	// 조회 - 입고 내역 존재 유무 필요
	public boolean selectInfo(int productId) {
		boolean isSelected = false;
		try {
			connect();
			String sql = "SELECT COUNT(*) AS COUNT FROM take_out_goods WHERE product_id = " + productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				if(rs.getInt("COUNT")>0) {
					isSelected = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("입고내역 존재 확인 조회가 실패하였습니다. : " + e.toString());
		} finally {
			disconnect();
		}
		return isSelected;
	}
	// 조회 - 입고 수량
	public int selectAmount(int productId) {
		int amount = 0;
		try {
			connect();
			String sql = "SELECT SUM(product_amount) AS SUM FROM take_out_goods WHERE product_id = " + productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				amount = rs.getInt("SUM");
			}
		} catch (SQLException e) {
			System.out.println("입고수량 확인 조회가 실패하였습니다. : " + e.toString());
		} finally {
			disconnect();
		}
		return amount;
	}
	// 전체조회 - 현재까지 입고된 내역
	public List<DealInfo> SelectAll(){
		List<DealInfo> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id, p.product_name, r.product_amount FROM take_out_goods r JOIN products p ON r.product_id=p.product_id ORDER BY 1,2";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				info.setProductAmount(rs.getInt("product_amount"));
				list.add(info);
			}
		} catch (Exception e) {
			System.out.println("전체 조회가 실패하였습니다 : " + e.toString());
		} finally {
			disconnect();
		}
		return list;
	}
	// 전체조회 - 해당 날짜에 입고된 내역
	public List<DealInfo> SelectAll(Date dealDate){
		List<DealInfo> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id, p.product_name, r.product_amount FROM take_out_goods r JOIN products p ON r.product_id=p.product_id WHERE deal_date = ? ORDER BY 1,2";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, dealDate);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				info.setProductAmount(rs.getInt("product_amount"));
				list.add(info);
			}
		} catch (Exception e) {
			System.out.println("전체 조회가 실패하였습니다 : " + e.toString());
		} finally {
			disconnect();
		}
		return list;
	}
	// 전체조회 - 해당 제품의 입고된 내역
	public List<DealInfo> SelectAll(int productId){
		List<DealInfo> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id, p.product_name, r.product_amount FROM take_out_goods r JOIN products p ON r.product_id=p.product_id WHERE product_id = ? ORDER BY 1,2";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				info.setProductAmount(rs.getInt("product_amount"));
				list.add(info);
			}
		} catch (Exception e) {
			System.out.println("전체 조회가 실패하였습니다 : " + e.toString());
			} finally {
				disconnect();
			}
			return list;
		}
}
