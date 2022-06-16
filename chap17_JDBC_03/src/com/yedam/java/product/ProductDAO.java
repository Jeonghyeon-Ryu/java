package com.yedam.java.product;

import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class ProductDAO extends DAO {
	private static ProductDAO productDAO = null;
	private ProductDAO() {}
	public static ProductDAO getInstance() {
		if(productDAO == null) {
			productDAO = new ProductDAO();
		}
		return productDAO;			
	}
	//등록
	public void insert(Product product) {
		int result = 0;
		try {
			connect();
			String sql = "INSERT INTO product VALUES (product_seq.nextval, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("" + e.toString());
		} finally {
			disconnect();
			System.out.println(result + "개의 행이 추가되었습니다.");
		}
	}
	//수정 - 가격
	public void update(Product product) {
		int result = 0;
		try {
			connect();
			String sql = "UPDATE product SET product_price =? WHERE product_id= ?";
			pstmt.setInt(1, product.getProductPrice());
			pstmt.setInt(2, product.getProductId());
			result = pstmt.executeUpdate();					
		} catch (Exception e) {
			System.out.println("" + e.toString());
		} finally {
			disconnect();
			System.out.println(result + "개의 행이 변경되었습니다.");
		}
	}
	//삭제
	public void delete(int productId) {
		int result = 0;
		try {
			connect();
			String sql = "DELETE FROM product WHERE product_id = "+productId;
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("" + e.toString());
		} finally {
			disconnect();
			System.out.println(result + "개의 행이 삭제되었습니다.");
		}
	}
	//단건조회 - 제품번호
	public Product selectOne(String productName) {
		Product product = null;
		try {
			connect();
			String sql = "SELECT * FROM product WHERE product_name = "+productName;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
			}
		} catch (Exception e) {
			System.out.println("" + e.toString());
		} finally {
			disconnect();
		}
		return product;
	}
	//단건조회 - 제품이름
	public Product selectOne(int productId) {
		Product product = null;
		try {
			connect();
			String sql = "SELECT * FROM product WHERE product_id = " + productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
			}
		} catch (Exception e) {
			System.out.println("" + e.toString());
		} finally {
			disconnect();
		}
		return product;
	}
	//전체조회
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM product";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				list.add(product);
			}
		} catch (Exception e) {
			System.out.println("" + e.toString());
		} finally {
			disconnect();
		}
		return list;
	}
}
