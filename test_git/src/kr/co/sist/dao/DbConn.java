package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConn {
	
	private static DbConn dbConn;
	
	private DbConn() {
		
	}//DbConn
	
	public static DbConn getInstance() {
		if(dbConn == null) {
			dbConn = new DbConn();
		}//end if
		return dbConn;
	}
	
	/**
	 * DB연결을 얻는 일
	 * @param ip - ip주소를 얻는 일
	 * @param id - id를 얻는 일
	 * @param pass - 패스워드를 얻는 일
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection(String ip, String id, String pass) throws SQLException {
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@" + ip + ":1521:orcl";
		con = DriverManager.getConnection(url,id,pass);
		
		return con;
	}
	
	/**
	 * 연결 끊기
	 * @param rs
	 * @param con
	 * @param stmt
	 * @throws SQLException
	 */
	public void dbClose(ResultSet rs, Connection con, Statement stmt) throws SQLException {
		if( rs != null) { rs.close(); }
		if( con != null) { con.close(); }
		if( stmt != null) { stmt.close(); }
	}
	
}//class
