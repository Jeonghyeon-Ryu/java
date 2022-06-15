package com.yedam.java.emp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DeptDAO {
	private static DeptDAO deptDAO = null;
	private DeptDAO() {}
	public static DeptDAO getInstance() {
		if(deptDAO != null) {
			deptDAO = new DeptDAO();
		}
		return deptDAO;
	}
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String jdbc_driver;
	String oracle_url;
	String connectedId;
	String connectedPwd;
	
	private void dbConfig() {
		String resource = "config/db.properties";
		Properties properties = new Properties();
		
		try {
			String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			properties.load(new FileInputStream(filePath));
		} catch (IOException e) {
			System.out.println("DB Config 실패 : " + e.toString());
		}
		jdbc_driver = properties.getProperty("driver");
		oracle_url = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("pw");
	}
	
	void connect() {
		if(jdbc_driver==null && oracle_url==null && connectedId==null && connectedPwd==null)
			dbConfig();
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(oracle_url, connectedId, connectedPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void disconnect() {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			System.out.println("연결해제 실패 : " + e.toString());
		}
	}
	
	public boolean updateDB(Department dept) {
		String sql = "UPDATE departments SET" 
				+ "location_id=?,manager_id=?,department_name=?"
				+ "WHERE department_id=?";
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getLocationId());
			pstmt.setInt(2, dept.getManagerId());
			pstmt.setString(3, dept.getDepartmentName());
			pstmt.setInt(4, dept.getDepartmentId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}

	public boolean deleteDB(int gb_id) {
		String sql = "DELETE FROM departments WHERE department_id=?";
		try {
			connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gb_id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		return true;
	}
	
	public boolean insertDB(Department dept) {
		String sql_seq = "SELECT MAX(department_id)+10 FROM departments";
		String sql = "INSERT INTO departments VALUES(?,?,?,?)";
		int seq = 0;
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql_seq);
			if(rs.next())
				seq = rs.getInt(1);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.setString(2, dept.getDepartmentName());
			pstmt.setInt(3, dept.getManagerId());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	
	public List<Department> selectAll(){
		List<Department> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM departments";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Department dept = new Department();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setLocationId(rs.getInt("location_id"));
				dept.setManagerId(rs.getInt("manager_id"));
				list.add(dept);
			}
		} catch (Exception e) {
			System.out.println("Select All 실패 : " + e.toString());
		} finally {
			disconnect();
		}
		
		return list;
	}
	
	public Department selectOne(int deptId) {
		Department dept = new Department();
		try {
			connect();
			String sql = "SELECT * FROM departments WHERE department_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptId);
			rs = pstmt.executeQuery();
			dept.setDepartmentId(rs.getInt("department_id"));
			dept.setDepartmentName(rs.getString("department_name"));
			dept.setLocationId(rs.getInt("location_id"));
			dept.setManagerId(rs.getInt("manager_id"));
		} catch (Exception e) {
			System.out.println("SELECT One 실패 : " + e.toString());
		} finally {
			disconnect();
		}
		return dept;
	}
}
