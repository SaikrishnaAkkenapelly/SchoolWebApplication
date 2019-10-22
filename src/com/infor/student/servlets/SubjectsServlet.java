/**
 * 
 */
package com.infor.student.servlets;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infor.student.dbo.impl.StudentsDaoImpl;
import com.infor.student.pojo.Marks;
import com.infor.student.pojo.Student;

/**
 * @author sakkenapelly
 *
 */
public class SubjectsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StudentsDaoImpl studentsdaoimpl = new StudentsDaoImpl();
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String action = req.getParameter("action");
		RequestDispatcher requestdispatcher=null;
		List<Student> studentslist=null;
		if (action.equals("getmarks")) {
			HttpSession session=req.getSession();
			studentslist = studentsdaoimpl.getAllStudents();
			session.setAttribute("studentslist", studentslist);
			
			requestdispatcher = req.getRequestDispatcher("jsp/subjects.jsp");
			requestdispatcher.forward(req, resp);
		}

		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String action = req.getParameter("action");
		
		HashMap<String, Integer> subjectwisemarks;
		List<String> subjectslist=null;;
		RequestDispatcher requestdispatcher=null;
		List<Marks> updatedlist=null;
		
		if (action.equals("viewsubjects")) {
			long id = Long.parseLong(req.getParameter("id"));
			HttpSession session=req.getSession();
			session.setAttribute("id",id);
			subjectwisemarks = new HashMap<String, Integer>();
			subjectslist = studentsdaoimpl.getSubjectsbyId(id);
			for (String string : subjectslist) {
				System.out.println(string);
			}
			for (String subjectname : subjectslist) {
				subjectwisemarks.put(subjectname,
						studentsdaoimpl.getMarks(subjectname, id));
				
			}
			req.setAttribute("subjectslist", subjectslist);
			req.setAttribute("subjectwisemarks", subjectwisemarks);
			requestdispatcher = req.getRequestDispatcher("jsp/subjects.jsp");
			requestdispatcher.forward(req, resp);

		}
		
		if (action.equals("updatemarks")) {
			int rows = 0;
			StudentsDaoImpl studentsdaoimpl = new StudentsDaoImpl();
			Long sid = (Long)(req.getSession()).getAttribute("id");
			subjectslist = studentsdaoimpl.getSubjectsbyId((sid));
			RequestDispatcher dispatch;
			for (String string : subjectslist) {
				Long marks = Long.parseLong(req.getParameter(string));
				rows = rows + studentsdaoimpl.updateMarks((sid), string,
						(marks));
			}
			
			req.setAttribute("rowsinserted", rows);
			updatedlist = studentsdaoimpl.getMarksById(sid);
			req.setAttribute("updatedlist", updatedlist);
			dispatch = req.getRequestDispatcher("jsp/subjects.jsp");
			dispatch.forward(req, resp);

		}
	}
}
