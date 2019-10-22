<html>
	<head>
		<title>students data</title>
		
		<link rel="stylesheet" type="text/css" href="http://localhost:8080/StudentRegistration/css/students.css">
		<script type="text/javascript" src="http://localhost:8080/StudentRegistration/js/validations.js"></script>
	</head>
	<body>
			<div class="headerdivision">
					<table class="headertable">
						<tr>
							<td class="logo"><img src="http://localhost:8080/StudentRegistration/images/SchoolLogo.png" height=29px;"></td>
						
						</tr>
					</table>
			</div>
			<div class="bodydivision">
					<img src="http://localhost:8080/StudentRegistration/images/schoolimage.png" width=100%;>
						<div class="middledivision">
							<p>New User Registration</p>
						</div>
						<div class="formdivision">
								<center>
										<form method="POST" action="http://localhost:8080/StudentRegistration/LoginServlet?action=newuser" name="enrollmentform">
											
												<table>
												<tr>
													<td class="formtd">First Name</td><td><input type="text" name="firstname" class="input" required></td>
												</tr>
												<tr>
												<td class="formtd">Last Name</td><td><input type="text" name="lastname" class="input" required></td>
												</tr>
												<tr>
												<td></td>
												<td  class="formtd"><input type="checkbox" name="male" value="male" class="checkbox">Male</td>
												</tr>
												<tr>
													<td class="formtd">Gender</td><td  class="formtd"><input type="checkbox" name="female" value="female" class="checkbox">Female</td>
												</tr>
												<tr>
													<td class="formtd">User Name</td><td><input type="text" name="username" class="input" required></td>
												</tr>
												<tr>
													<td class="formtd">Password</td><td><input type="text" name="password" class="input" required></td>
												</tr>
												<tr><tr>
													<td class="formtd"></td>
													<td class="formtd"><input type="submit" value="Register" class="insertbutton" onClick="return validate();"> </td>
												</tr>
												<tr></tr><tr></tr>
												
												<tr><td></td><td><a href="http://localhost:8080/StudentRegistration/jsp/login.jsp">Already Registred ? Sign In</a></td></tr>
												<tr></tr><tr></tr>
												<tr></tr><tr></tr>
												<%
														Object obj=request.getAttribute("rowsinserted");
														if( obj!=null)
														{
															Integer y =(Integer)obj;
															if(y.intValue()==1)
															{
														%>
														<tr>
															<td></td>
															<td>You have successfully registered</td>
														</tr>
														<% }}%>
														<%
												Object errormessage=request.getAttribute("errormessage");
												if(errormessage!=null)
												{
													String error =(String)errormessage;
													%><tr><td></td><td class="error"><%out.print(error);%></td><tr>
												<%}
												%>
												</table>
										</form>
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