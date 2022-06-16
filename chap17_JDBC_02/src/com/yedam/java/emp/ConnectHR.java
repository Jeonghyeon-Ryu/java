package com.yedam.java.emp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectHR {
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
}
