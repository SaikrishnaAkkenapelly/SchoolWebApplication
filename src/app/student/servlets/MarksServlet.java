package app.student.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.student.dbo.impl.StudentsDaoImpl;
import app.student.pojo.Student;


/**
 * @author sakkenapelly
 *
 */
public class MarksServlet extends HttpServlet
{
    private static final Logger logger;
    private static final long serialVersionUID = 1L;
    StudentsDaoImpl studentdaoimpl;
    
    static {
        logger = Logger.getLogger("global");
    }
    
    /**
     * 
     */
    public MarksServlet() {
        this.studentdaoimpl = new StudentsDaoImpl();
    }
    
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String action = req.getParameter("action");
        MarksServlet.logger.info("Action:" + action);
        if (action.equals("LoadStudents")) {
            final HttpSession session = req.getSession();
            final RequestDispatcher requestdispatcher = req.getRequestDispatcher("jsp/marks.jsp");
            final List<Student> Studentlist = (List<Student>) this.studentdaoimpl.getAllStudents();
            session.setAttribute("Studentlist", Studentlist);
            requestdispatcher.forward((ServletRequest)req, (ServletResponse)resp);
        }
    }
    
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String action = req.getParameter("action");
        int total = 0;
        double percentage = 0.0;
        int numberofsubjects = 0;
        String grade = "";
        if (action.equals("viewmarks")) {
            final RequestDispatcher requestdispatcher = req.getRequestDispatcher("jsp/marks.jsp");
            final long id = Long.parseLong(req.getParameter("id"));
            MarksServlet.logger.info(String.valueOf(id));
            final List<String> subjectslist = (List<String>)this.studentdaoimpl.getSubjectsbyId(id);
            req.setAttribute("id", (Object)id);
            req.setAttribute("subjectslist", (Object)subjectslist);
            final HashMap<String, Integer> subjectwisemarks = new HashMap<String, Integer>();
            for (final String subjectname : subjectslist) {
                subjectwisemarks.put(subjectname, this.studentdaoimpl.getMarks(subjectname, id));
                ++numberofsubjects;
            }
            for (String string : subjectwisemarks.keySet()) {
				total = total + subjectwisemarks.get(string);
			}
			
				logger.info(String.valueOf(numberofsubjects));
				percentage=((double)total/(numberofsubjects));
				if(percentage>=75.0){
					grade="A";
				}else if(percentage<75.0 && percentage>=50.0)
				{
					grade="B";
				}else if(percentage<50.0 && percentage>=40.0)
				{
					grade="C";
				}else
				{
					grade="FAIL";
				}
				req.setAttribute("subjectwisemarks", subjectwisemarks);
				req.setAttribute("total", total);
				req.setAttribute("grade",grade);
				req.setAttribute("numberofsubjects",numberofsubjects);
				requestdispatcher.forward(req, resp);        }
    }
}
