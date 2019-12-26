/**
 * 
 */
package app.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author sakkenapelly
 *
 */
public class DbConnection {

	public static Connection connect() {

		Connection connection = null;
		
		String connectionUrl = "jdbc:sqlserver://INHYNSAKKENAPE1:1433;databaseName=SCHOOL_APPLICATION;"
				+ "user=auto;password=Infor2020";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(connectionUrl);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;

	}

}
