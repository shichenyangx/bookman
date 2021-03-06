package cn.edu.nyist.bookmanv1.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DsUtil {
	//這個web需要一個就可以了
	private static ComboPooledDataSource cds = new ComboPooledDataSource();

	public static Connection getConn() throws SQLException {
		return cds.getConnection();
	}
	public static void free(Statement stmt, Connection conn) {
	
		/*
		 * try { stmt.close(); conn.close(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		if (stmt != null) {

			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void free(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {

			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if (stmt != null) {

			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
