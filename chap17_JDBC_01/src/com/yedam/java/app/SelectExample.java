package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectExample {

	public static void main(String[] args) throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id="hr"; String pw="hr";
		// 1. JDBC Driver 로딩
		Class.forName(driver);
		// 2. DB 서버 접속
		Connection con = DriverManager.getConnection(url,id,pw);
		// 3. Statement & PreparedStatement 생성
		Statement stmt = con.createStatement();
		// 4. Query 구성
		String sql = "SELECT * FROM employees";
		// 5. Query 실행
		ResultSet rs = stmt.executeQuery(sql);
		// 6. 결과값 이용
		while(rs.next()) {
			String name = rs.getString("first_name") + " " + rs.getString("last_name");
			System.out.println(name);
		}
		// 7. 자원 해제
		if(rs!=null) rs.close();
		if(stmt != null) stmt.close();
		if(con != null) con.close();
	}

}
