package com.infor.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**

 *---Begin Copyright Notice---

 * 

 *NOTICE

 * 

 *THIS SOFTWARE IS THE PROPERTY OF AND CONTAINS CONFIDENTIAL INFORMATION OF

 *INFOR AND/OR ITS AFFILIATES OR SUBSIDIARIES AND SHALL NOT BE DISCLOSED

 *WITHOUT PRIOR WRITTEN PERMISSION. LICENSED CUSTOMERS MAY COPY AND ADAPT

 *THIS SOFTWARE FOR THEIR OWN USE IN ACCORDANCE WITH THE TERMS OF THEIR

 *SOFTWARE LICENSE AGREEMENT. ALL OTHER RIGHTS RESERVED.

 * 

 *(c) COPYRIGHT 2019 INFOR. ALL RIGHTS RESERVED. THE WORD AND DESIGN MARKS

 *SET FORTH HEREIN ARE TRADEMARKS AND/OR REGISTERED TRADEMARKS OF INFOR

 *AND/OR ITS AFFILIATES AND SUBSIDIARIES. ALL RIGHTS RESERVED. ALL OTHER

 *TRADEMARKS LISTED HEREIN ARE THE PROPERTY OF THEIR RESPECTIVE OWNERS.

 * 

 *---End Copyright Notice---

 */
public class GetDbConnection2 {

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
