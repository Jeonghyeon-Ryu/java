package databaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) throws SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    String user = "hr"; String password = "hr";
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
	    
	    String sql = "select * from employees";
	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()) {
	    	String id = rs.getNString("employee_id");
	    	String name = rs.getNString("last_name");
	    	
	    	System.out.println("ID : "+id+", Name : "+name);
	    }
	    rs.close();
	    stmt.close();
	    con.close();
	}

}
