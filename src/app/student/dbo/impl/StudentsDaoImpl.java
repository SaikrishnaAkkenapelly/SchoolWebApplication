package app.student.dbo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import app.student.pojo.Marks;
import app.student.pojo.Student;
import app.student.util.DbConnection;

/**
 * @author sakkenapelly
 *
 */
public class StudentsDaoImpl {

	private static final Logger logger = Logger.getGlobal();

	/**
	 * @param studentsobject
	 * @return student no
	 */
	public long enrollNewStudent(Student studentsobject) {
		String query = "insert into students(name,dob,email) values(?,?,?)";
		long studentId = 0;
		long milliseconds = 0;
		try (Connection connection = DbConnection.connect();
				PreparedStatement preparedStatement = connection.prepareStatement(query, new String[] { "id" });) {
			preparedStatement.setString(1, studentsobject.getName());
			milliseconds = studentsobject.getDob().getTime();
			preparedStatement.setDate(2, new java.sql.Date(milliseconds));
			preparedStatement.setString(3, studentsobject.getEmail());
			preparedStatement.executeUpdate();
			try (ResultSet resultSet = preparedStatement.getGeneratedKeys();) {
				while (resultSet.next()) {
					studentId = resultSet.getLong(1);
				}
			}
		} catch (SQLException e) {
			logger.info("SQL Exception raised");
		}
		return studentId;
	}

	/**
	 * @return student list
	 */
	public List<Student> getAllStudents() {

		List<Student> list = new ArrayList<>();
		String query = "select id,name,dob,email from students";
		try (Connection connection = DbConnection.connect();
				PreparedStatement ps = connection.prepareStatement(query);) {
			try (ResultSet resultSet = ps.executeQuery();) {
				while (resultSet.next()) {
					list.add(new Student(resultSet.getLong(1), resultSet.getString(2), resultSet.getDate(3),
							resultSet.getString(4)));
				}
			}
		} catch (SQLException e) {
			logger.info("SQL Exception raised in StudentsDaoIMp");
		}
		return list;
	}

	/**
	 * 
	 * @param id
	 * @return student ids list
	 */
	public List<String> getSubjectsbyId(long id) {
		List<String> subjectslist = new ArrayList<>();
		String query = "select subname from subjects where id = ?";
		try (Connection connection = DbConnection.connect();
				PreparedStatement ps = connection.prepareStatement(query);) {
			ps.setLong(1, id);
			try (ResultSet resultSet = ps.executeQuery();) {
				while (resultSet.next()) {
					subjectslist.add(resultSet.getString(1));
				}
			}
		} catch (SQLException e) {
			logger.info("SQL Exception raised in StudentsDaoIMp");
		}
		for (String string : subjectslist) {
			logger.fine(string);
		}
		return subjectslist;
	}

	/**
	 * 
	 * @param id
	 * @param subname
	 * @param marks
	 * @return marks
	 */
	public int insertMarks(long id, String subname, long marks) {
		String query = "insert into marks values(?,?,?)";
		int rows = 0;
		try (Connection connection = DbConnection.connect();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setLong(1, id);
			preparedStatement.setString(2, subname);
			preparedStatement.setLong(3, marks);
			rows = preparedStatement.executeUpdate();
			System.out.println(rows + " " + "row(s) inserted into students");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	/**
	 * 
	 * @param subjectname
	 * @param id
	 * @return marks
	 */
	public int getMarks(String subjectname, long id) {

		String query = "select subjectmarks from marks where subname=? and id= ?";
		int marks = 0;
		try (Connection connection = DbConnection.connect();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setString(1, subjectname);
			preparedStatement.setLong(2, id);
			try (ResultSet resultset = preparedStatement.executeQuery();) {
				if (resultset.next())
					marks = resultset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marks;
	}

	public int updateMarks(Long id, String subname, Long marks) {
		String query = "update marks set subjectmarks=? where id=? and subname=?";
		int rows = 0;
		try (Connection connection = DbConnection.connect();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setLong(1, marks);
			preparedStatement.setLong(2, id);
			preparedStatement.setString(3, subname);
			rows = preparedStatement.executeUpdate();
			System.out.println(rows + " " + "row(s) inserted into students");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	public List<Marks> getMarksById(Long id) {

		List<Marks> list = new ArrayList<Marks>();
		String query = "select id,subname,subjectmarks from Marks where id=?";
		try (Connection connection = DbConnection.connect();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setLong(1, id);
			try (ResultSet resultSet = preparedStatement.executeQuery();) {

				while (resultSet.next()) {
					list.add(new Marks(resultSet.getLong(1), resultSet.getString(2), resultSet.getLong(3)));

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
