package com.infor.student.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 * @author sakkenapelly
 *
 */public class CloseDbConnection2 {
	
	/**
	 * @param connection
	 * @param preparedStatement
	 * @throws SQLException
	 */
	public static void closeConnection(Connection connection,
			PreparedStatement preparedStatement)throws SQLException {
		try {
			connection.close();
			preparedStatement.close();
			System.out.println("connection closed successfully..");
		} catch (SQLException e) {
			System.out.println("connection closed successfully..");
			e.printStackTrace();
		}
	}

}
