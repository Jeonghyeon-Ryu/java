package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLExample {

	public static void main(String[] args) throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    String user = "hr";
	    String password = "hr";
	   
	    // 1. JDBC Driver 로딩
	    // 2. DB서버 접속
	    // 3. CRUD 실행
	    Connection con = null;
	    try { 
	    	Class.forName(driver);
	    	System.out.println("jdbc driver 로딩 성공");
	    	con = DriverManager.getConnection(url, user, password);
	    	System.out.println("오라클 연결 성공"); 
	    } catch (ClassNotFoundException e) {
	      	System.out.println("jdbc driver 로딩 실패"); 
	    } catch (SQLException e) {
	    	System.out.println("오라클 연결 실패");
	    }
	   
	    
	    // ----------- INSERT ------------- executeUpdate()
	    //-1. Statement or PreparedStatement 생성
	    String insert = "INSERT INTO employees VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	    PreparedStatement pstmt = con.prepareStatement(insert);
	    //-2. SQL 구성 후 실행
	    pstmt.setInt(1, 1000);
	    pstmt.setString(2, "Gil-Dong");
	    pstmt.setString(3, "Hong");
	    pstmt.setString(4, "vxxv123");
	    pstmt.setString(5, "82.10.1234.1234");
	    pstmt.setString(6, "20/11/05");
	    pstmt.setString(7, "SA_REP");
	    pstmt.setInt(8, 30000);
	    pstmt.setDouble(9, 0.15);
	    pstmt.setInt(10, 101);
	    pstmt.setInt(11, 80);
	    //-3. 결과출력
	    int result = pstmt.executeUpdate();
	    System.out.println("INSERT 실행 결과 : " + result);
	    
	    // ----------- UPDATE ------------- executeUpdate()
	    //-1. Statement or PreparedStatement 생성
	    String update = "UPDATE employees Set employee_id = ? WHERE last_name = ?";
	    pstmt = con.prepareStatement(update);
	    //-2. SQL 구성 후 실행
	    pstmt.setInt(1, 999);
	    pstmt.setString(2, "Hong");
	    //-3. 결과출력
	    result = pstmt.executeUpdate();
	    System.out.println("UPDATE 실행 결과 : " + result);
	    // ----------- SELECT ------------- executeQuery()
	    //-1. Statement or PreparedStatement 생성
	    String select = "SELECT * FROM employees WHERE last_name=?";
	    pstmt = con.prepareStatement(select);
	    //-2. SQL 구성 후 실행
	    pstmt.setString(1, "'Hong'");
	    //-3. 결과출력
	    ResultSet rs = pstmt.executeQuery();
	    while(rs.next()) {
	    	String info = rs.getInt("employee_id") + " | " +
	    			rs.getString("first_name") + " | " +
	    			rs.getString("last_name") + " | " +
	    			rs.getString("email") + " | " +
	    			rs.getString("phone_number");
	    	System.out.println(info);
	    }
	    // ----------- DELETE ------------- executeUpdate()
	    //-1. Statement or PreparedStatement 생성
	    String delete = "DELETE FROM employees WHERE employee_id=?";
	    pstmt = con.prepareStatement(delete);
	    //-2. SQL 구성 후 실행
	    pstmt.setInt(1, 999);
	    //-3. 결과출력
	    result = pstmt.executeUpdate();
	    System.out.println("DELETE 결과 : " + result);
	    
	    
	    //---------- 자원 반환 -----------
	    rs.close();
	    pstmt.close();
	    con.close();
	}

}
