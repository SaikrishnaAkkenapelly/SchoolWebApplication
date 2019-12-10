<html>
	<head>
		<title>students data</title>
		
		<link rel="stylesheet" type="text/css" href="http://localhost:9090/StudentRegistration/css/students.css">
		<script type="text/javascript" src="http://localhost:9090/StudentRegistration/js/validations.js"></script>
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
						<div class="middledivision">
							<p>Enroll New Student</p>
						</div>
						<div class="formdivision">
								<center>
										<form method="POST" action="http://localhost:9090/StudentRegistration/StudentsServlet?action=enrollnewstudent" name="enrollmentform">
											<center>
												<table>
												<tr>
													<td class="formtd">Student Name</td><td><input type="text" name="name" class="input" required></td>
												</tr>
												<tr>
													<td class="formtd">Date Of Birth</td><td><input type="text" name="dob" class="input" required></td>
												</tr>
												<tr>
													<td class="formtd">Student Email</td><td><input type="text" name="email" class="input" required> </td>
												</tr>
												<tr>
													<td></td>
													<td  class="formtd"><input type="checkbox" name="sub1" value="maths" class="checkbox">Maths</td>
													
													<td  class="formtd"><input type="checkbox" name="sub5"  value="commerce" class="checkbox">Commerce</td>
													
												</tr>
												
												<tr>
													<td  class="formtd">Subjects to Opt:</td><td  class="formtd"><input type="checkbox" name="sub3"  value="chemistry" class="checkbox">Chemistry</td>
													<td  class="formtd"><input type="checkbox" name="sub4"  value="biology" class="checkbox">Biology</td>
												</tr>
												<tr>
													<td></td>
													<td  class="formtd"><input type="checkbox" name="sub2"  value="physics" class="checkbox">Physics</td>
													<td  class="formtd"><input type="checkbox" name="sub6"  value="economics" class="checkbox">Economics</td>
												</tr>
												<tr>
													<td class="formtd"></td>
													<td class="formtd"><input type="submit" value="Enroll" class="insertbutton" onClick="return validate();"> </td>
												</tr>
												<table>
					
				</table>
												</table>
										</form>
						
												<table>
														<%
														Object obj=request.getAttribute("rowsinserted");
														if( obj!=null)
														{
															Integer y =(Integer)obj;
														%>
														<tr>
															<td><%
															out.print(" 1 Student with");
																
															%></td>
															<td><%
															out.print(y.intValue()+" Subjects Enrolled");
														}%></td>
														</tr>
														<tr><td class="formbottomtd"> <a href="http://localhost:9090/StudentRegistration/jsp/home.jsp">Home Page</a></td></tr>
						</table>
						
					</center>
				</div>					
			</div>	
			<div class="footerdivision">
					<table class="footertable">
						<tr>
							<td  class="footertd">Copyright  2019 SHS. All rights reserved.</td>
							<td  class="footertd">Privacy Policy</td>
							<td  class="footertd">Terms of Use</td>
							<td  class="footertd">Legal</td>
						</tr>
					</table>
			</div>
	</body>
</html>