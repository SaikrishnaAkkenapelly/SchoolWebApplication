<html>
<head>
<title>home page</title>
<link rel="stylesheet" type="text/css" href="http://localhost:9090/StudentRegistration/css/home.css">
</head>
<body>
		<%
		Object validation =session.getAttribute("validationFlag");
		if(validation==null)
		{
			response.sendRedirect("jsp/login.jsp");
		}
		%>
	<div class="headerdivision">
			<table class="headertable">
				<tr>
					<td class="logo"><img src="http://localhost:9090/StudentRegistration/images/SchoolLogo.png" height=29px;"></td>
					<td><a href="http://localhost:9090/StudentRegistration/jsp/students.jsp">Enroll New Student</a></td>
					<td><a href="http://localhost:9090/StudentRegistration/SubjectsServlet?action=getmarks">Update Marks</a></td>
					<td><a href="http://localhost:9090/StudentRegistration/MarksServlet?action=LoadStudents">View Grades</a></td>
					<td><a href="http://localhost:9090/StudentRegistration/LoginServlet?action=Logout">Log Out</a></td>
				</tr>
			</table>
	</div>
	<div class="bodydivision">
		<img src="http://localhost:9090/StudentRegistration/images/schoolimage.png" width=100%;>
		<div class="welcomemessage"><p>Welcome to G School</p>
		</div>
	</div>
		<div class="footerdivision">
		<table class="footertable">
			<tr>
				<td  class="footertd">Copyright  2019 INFOR. All rights reserved.</td>
				<td  class="footertd">Privacy Policy</td>
				<td  class="footertd">Terms of Use</td>
				<td  class="footertd">Legal</td>
			</tr>
		</table>
	</div>
</body>
</html>