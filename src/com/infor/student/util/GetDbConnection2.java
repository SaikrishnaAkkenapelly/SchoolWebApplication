package com.infor.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 * @author sakkenapelly
 *
 */public class GetDbConnection2 {

	/**
	 * @return connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@inhynsakkenape1:1521:trng";
			connection = DriverManager.getConnection(url, "user1", "user1");
			System.out.println("connection established successfully..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
