/**
 * 
 */
package com.infor.student.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

import com.infor.student.util.GetDbConnection2;

/**
 * @author sakkenapelly
 *
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger;

	static {
		logger = Logger.getLogger("global");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String action = req.getParameter("action");
		String dbPassword = "";
		boolean validationFlag = false;
		RequestDispatcher dispatcher =null; 
		

		if (action.equals("validateLogin")) {
			String query = "select password from users where username=?";
			try (Connection connection = GetDbConnection2.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(query);) {
				preparedStatement.setString(1, username);
				try (ResultSet rs = preparedStatement.executeQuery()) {
					while (rs.next()) {
						dbPassword = rs.getString(1);
					}
					if (dbPassword.equals(password)) {
						validationFlag = true;
						HttpSession session = req.getSession();
						session.setAttribute("validationFlag", validationFlag);
						dispatcher=req.getRequestDispatcher("jsp/home.jsp");
						dispatcher.forward(req, resp);
					}else
					{
						req.setAttribute("errormessage","Invalid Username or Password!");
						dispatcher=req.getRequestDispatcher("jsp/login.jsp");
						dispatcher.forward(req, resp);
					}

				}
			} catch (SQLException e) {

				logger.info("SQL Exception raised in HomePage");
				
			}
		} else if (action.equals("newuser")) {
			String firstname = req.getParameter("firstname");
			String lastname = req.getParameter("lastname");
			String gender="";
			if(req.getParameter("male")==null)
			{
				gender="female";
			}else
			{
				gender="male";
			}
			int rows=0;
			String query = "insert into users values(?,?,?,?,?)";
			try (Connection connection = GetDbConnection2.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(query);) {
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);
				preparedStatement.setString(3, firstname);
				preparedStatement.setString(4, lastname);
				preparedStatement.setString(5, gender);
				dispatcher=req.getRequestDispatcher("jsp/userreg.jsp");
				rows=preparedStatement.executeUpdate();
				req.setAttribute("rowsinserted",rows);
				dispatcher.forward(req, resp);

			} catch (SQLException e) {

				req.setAttribute("errormessage"," Username is already taken !");
				
				logger.info("SQL Exception raised in login user registration page");
				dispatcher=req.getRequestDispatcher("jsp/userreg.jsp");
				dispatcher.forward(req, resp);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		if(action.equals("Logout"))
		{	
			(req.getSession()).removeAttribute("validationFlag");
			(req.getSession()).invalidate();
			resp.sendRedirect("jsp/login.jsp");
		}
	}
	
	
	
	

}
