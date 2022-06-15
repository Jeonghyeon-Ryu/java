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

public class EmpDAO {
	private static EmpDAO empDAO = null;
	private EmpDAO() {}
	public static EmpDAO getInstance() {
		if(empDAO==null) {
			empDAO = new EmpDAO();
		}
		return empDAO;
	}
	/******************** 필드 ********************/
	// Oracle 연결 정보
	String jdbc_driver;
	String oracle_url;
	String connectedId;
	String connectedPwd;
	// 각 메소드에서 공통적으로 사용하는 필드
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	/******************** 메소드 ********************/
	// 1. JDBC Driver 로딩
	// 2. DB 접속
	public void connect() {
		if(jdbc_driver==null && oracle_url==null && connectedId==null && connectedPwd==null)
			dbConfig();
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(oracle_url, connectedId, connectedPwd);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패 : " + e.toString() );
		} catch (SQLException e) {
			System.out.println("Oracle DB 연결 실패 : " + e.toString() );
		}
	}
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
	
	// 3. CRUD 실행 - 기본 5개 메소드를 만듬. - 모두 Return 이 있어야함.
	// 전체조회, 단건조회, 등록, 수정, 삭제
	// 전체조회
	public List<Employee> selectAll() {
		List<Employee> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM employees";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setDepartmentId(rs.getInt("department_id"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setSalary(rs.getDouble("salary"));
				list.add(emp);
			}
		} catch (SQLException e) {
			System.out.println("SELECT ALL 실패 : " + e.toString());
		} finally {
			disconnect();
		}
		return list;
	}
	// 단건조회
	public Employee selectOne(int empId) {
		Employee emp = null;
		try {
			connect();
			String sql = "SELECT * FROM employees WHERE employee_id="+empId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				emp=new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setDepartmentId(rs.getInt("department_id"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setSalary(rs.getDouble("salary"));
			}
		} catch (Exception e) {
			System.out.println("SELECT One 실패 : " + e.toString());
		} finally {
			disconnect();
		}
		return emp;
	}
	// 등록
	public boolean insert(Employee emp) {
		int result=0;
		try {
			connect();
			String sql = "INSERT INTO employees VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmployeeId());
		    pstmt.setString(2, emp.getFirstName());
		    pstmt.setString(3, emp.getLastName());
		    pstmt.setString(4, emp.getEmail());
		    pstmt.setString(5, emp.getPhoneNumber());
		    pstmt.setDate(6, emp.getHireDate());
		    pstmt.setString(7, emp.getJobId());
		    pstmt.setDouble(8, emp.getSalary());
		    pstmt.setDouble(9, emp.getCommissionPct());
		    pstmt.setInt(10, emp.getManagerId());
		    pstmt.setInt(11, emp.getDepartmentId());
		    result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("INSERT 실패 : " + e.toString());
			return false;
		} finally {
			disconnect();
			System.out.println(result + "개의 행이 추가되었습니다.");
		}
		return true;
	}
	// 수정
	public boolean update(Employee emp) {
		int result=0;
		try {
			connect();
			// Preparedstatement
			String sql = "UPDATE employees SET salary=? WHERE employee_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(2, emp.getEmployeeId());
		    pstmt.setDouble(1, emp.getSalary());
		    result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("UPDATE 실패 : " + e.toString());
			return false;
		} finally {
			disconnect();
			System.out.println(result + "개의 행이 수정되었습니다.");
		}
		return true;
	}
	
	// 삭제
	public boolean delete(int empId) {
		int result=0;
		try {
			connect();
			String sql = "DELETE FROM employees WHERE employee_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
		    result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("DELETE 실패 : " + e.toString());
			return false;
		} finally {
			disconnect();
			System.out.println(result + "개의 행이 삭제되었습니다.");
		}
		return true;
	}
	// 4. 자원 해제
	public void disconnect() {
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
