package com.yedam.app.products;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class ProductDAO extends DAO {
	private static ProductDAO pDAO = null;
	private ProductDAO() {}
	public static ProductDAO getInstance() {
		if(pDAO==null) {
			pDAO = new ProductDAO();
		}
		return pDAO;
	}
	// 등록
	public void insert(Product product) {
		int result = 0; 
		try {
			connect();
			if(search(product.getProductName())>0) {
				throw new Exception("동일한 상품이 등록되어 있습니다.");
			}
			String sql = "INSERT INTO products(product_id,product_name,product_price) VALUES(products_seq.nextval,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("등록이 실패하였습니다 : " + e.toString());
		} catch (Exception e) {
			System.out.println("등록이 실패하였습니다 : " + e.toString());
		} finally {
			disconnect();
			System.out.println(result + "개의 행이 추가 되었습니다.");
		}
	}
	// 수정 - 재고
	public void updateStock(Product product) {
		int result = 0; 
		try {
			connect();
			String sql = "UPDATE products SET product_stock = ? WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getProductStock());
			pstmt.setInt(2, product.getProductId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("수정이 실패하였습니다. : " +e.toString());
		} finally {
			disconnect();
			System.out.println(result + "개의 행이 수정 되었습니다.");
		}
	}
	// 수정 - 이름, 가격
	public void updateInfo(Product product) {
		int result =0;
		try {
			connect();
			String sql = "UPDATE products SET product_name=?,product_price=? WHERE product_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			pstmt.setInt(3, product.getProductId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("수정이 실패하였습니다. : " +e.toString());
		} finally {
			disconnect();
			System.out.println(result + "개의 행이 수정 되었습니다.");
		}
	}
	// 삭제
	public void delete(int productId) {
		int result = 0; 
		try {
			connect();
			String sql = "DELETE FROM products WHERE product_id = " + productId;
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("삭제가 실패하였습니다. : " + e.toString());
		} finally {
			disconnect();
			System.out.println(result + "개의 행이 삭제 되었습니다.");
		}
	}
	// 단건조회 - 상품이름
	public Product selectOne(String productName) {
		Product product = null;
		try {
			connect();
			String sql = "SELECT * FROM products WHERE product_id = " + productName;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductStock(rs.getInt("product_stock"));
			}
		} catch (SQLException e) {
			System.out.println("조회가 실패하였습니다. : " +e.toString());
		} finally {
			disconnect();
		}
		return product;
	}
	// 상품이름 비교 확인.
	public int search(String productName) {
		int count = 0;
		try {
			connect();
			String sql = "SELECT count(*) FROM products WHERE product_id = " + productName;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			System.out.println("조회가 실패하였습니다. : " + e.toString());
		} finally {
			disconnect();
		}
		return count;
	}
	
	// 전체조회
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM products ORDER BY product_id";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductStock(rs.getInt("product_stock"));
				list.add(product);
			}
		} catch (SQLException e) {
			System.out.println("조회가 실패하였습니다. : " +e.toString());
		} finally {
			disconnect();
		}
		
		return list;
	}
}
