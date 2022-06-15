package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeptSQLExample {
	static Scanner sc = new Scanner(System.in);
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs =null;
    
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    String user = "hr";
	    String password = "hr";
	    
	    try {
			Class.forName(driver);
			System.out.println("JDBC Driver 로딩 성공");
			con = DriverManager.getConnection(url,user,password);
			System.out.println("Oracle DB 연결 성공");
			
			while(true) {
				int manuNum = printManu();
				if(manuNum == 1) {
					deptInsertManu();
				} else if(manuNum == 2) {
					deptUpdateManu();
				} else if(manuNum == 3) {
					deptSelectAll(con,rs);
				} else if(manuNum == 4) {
					deptDeleteManu();
				} else if(manuNum == 5) {
					System.out.println("종료합니다.");
					break;
				}
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("Query 실행 실패");
		} finally {
			try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static int printManu() {
		System.out.println("1. INSERT");
		System.out.println("2. UPDATE");
		System.out.println("3. SELECT");
		System.out.println("4. DELETE");
		System.out.println("5. 종료");
		System.out.print(" > ");
		return Integer.parseInt(sc.nextLine());
	}
	public static void deptInsertManu() throws SQLException {
		System.out.println("----- 부서 테이블 입력 메뉴");
		System.out.print("- 부서 ID : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("- 부서 이름 : ");
		String name = sc.nextLine();
		System.out.println("---------------");
		getManagerID(con,rs);
		System.out.print("- 부서 관리자 : ");
		int manager = Integer.parseInt(sc.nextLine());
		System.out.println("---------------");
		getLocationID(con, rs);
		System.out.print("- 부서 위치 : ");
		int location = Integer.parseInt(sc.nextLine());
		
		deptInsert(con,id,name,manager,location);
	}
	public static void deptUpdateManu() throws SQLException {
		System.out.println("----- 부서 테이블 변경 메뉴");
		System.out.print("- 부서 ID : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("- 변경할 이름 : ");
		String name = sc.nextLine();
		
		deptUpdate(con,id,name);
	}
	public static void deptDeleteManu() throws SQLException {
		System.out.println("----- 부서 테이블 삭제 메뉴");
		System.out.print("- 삭제할 부서 ID : ");
		int id = Integer.parseInt(sc.nextLine());
		
		deptDelete(con,id);
	}
	
	public static void getManagerID(Connection con, ResultSet rs) throws SQLException {
		String sql = "SELECT distint manager_id FROM employees WHERE manager_id IS NOT NULL ORDER BY manager_id";
		PreparedStatement pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		String result = "";
		while(rs.next()) {
			result += rs.getInt("manager_id") + ",";
		}
		System.out.println("입력 가능한 manager_id : " + result);
	}
	
	public static void getLocationID(Connection con, ResultSet rs) throws SQLException {
		String sql = "SELECT location_id FROM locations";
		PreparedStatement pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		String result = "";
		while(rs.next()) {
			result += rs.getInt("location_id") + ",";
		}
		System.out.println("입력 가능한 Location : " + result);
	}
	
	public static void deptInsert(Connection con, int id, String name, int manager, int location) throws SQLException {
		String sql = "INSERT INTO departments VALUES (?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setInt(3, manager);
		pstmt.setInt(4, location);
		
		int result = pstmt.executeUpdate();
		System.out.println(result + "개의 행이 추가 되었습니다.");
	}
	
	public static void deptUpdate(Connection con, int id, String name) throws SQLException {
		String sql = "UPDATE departments SET name=? WHERE department_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, id);
		
		int result = pstmt.executeUpdate();
		System.out.println(result + "개의 행이 변경 되었습니다.");
	}
	
	public static void deptSelectAll(Connection con, ResultSet rs) throws SQLException {
		String sql = "SELECT * FROM departments";
		PreparedStatement pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			String result = rs.getInt("department_id") + " | " +
					rs.getString("department_name") + " | " +
					rs.getInt("manager_id") + " | " +
					rs.getInt("location_id");
			System.out.println(result);
		}
	}
	
	public static void deptDelete(Connection con, int id) throws SQLException {
		String sql = "DELETE FROM departments WHERE department_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		int result = pstmt.executeUpdate();
		System.out.println(result + "개의 행이 삭제 되었습니다.");
	}
}
