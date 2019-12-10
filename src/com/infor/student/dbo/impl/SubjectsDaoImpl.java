/**
 * 
 */
package com.infor.student.dbo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;

import com.infor.student.util.DbConnection;

/**
 * @author sakkenapelly
 *
 */
public class SubjectsDaoImpl extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger;
	
	 static {
	        logger = Logger.getLogger("global");
	    }
	
	public int insertSubjects(Long id,List<String> subjectsList)
	{
		String query = "insert into subjects(id,subname) values(?,?)";
		int rows=0;
		try (Connection connection = DbConnection.connect();
				PreparedStatement ps = connection.prepareStatement(query);)
				{
					for (String subjectname : subjectsList) {
						if(subjectname!=null){
							ps.setLong(1, id);
							ps.setString(2, subjectname);
							rows = rows + ps.executeUpdate();
						}
					}
				}
		catch (SQLException e)
		{
			logger.info("SQL Exception raised in StudentsDaoIMp");
		}
		for (String string : subjectsList) {
			logger.fine(string);
		}
		return rows;
	}

}
