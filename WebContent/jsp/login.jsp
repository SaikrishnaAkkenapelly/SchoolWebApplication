<html>
<head>
<title>home page</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/StudentRegistration/css/login.css">
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
		<div class="welcomemessage"><p>Welcome to Infor School</p>
		</div>
	</div>
		<div class="formdivision">
								<center>
										<form method="POST" action="http://localhost:8080/StudentRegistration/LoginServlet?action=validateLogin" name="enrollmentform">
											<center>
												<table>
												<tr>
													<td class="formtd">User Name</td><td><input type="text" name="username" class="input" required></td>
												</tr>
												<tr>
													<td class="formtd">Password</td><td><input type="password" name="password" class="input" required></td>
												</tr>
											
												<tr>
													<td class="formtd"></td>
													<td class="formtd"><input type="submit" value="Login" class="insertbutton" onClick="return validate();"> </td>
													
												</tr>
												<tr></tr>
												<tr></tr>
												<tr></tr>
												<tr><td></td><td><a href="http://localhost:8080/StudentRegistration/jsp/userreg.jsp">New User? Register Here</a></td></tr>
												<%
												Object errormessage=request.getAttribute("errormessage");
												if(errormessage!=null)
												{
													String error =(String)errormessage;
													if(error.equals("Invalid Username or Password!"))
													{%>
														<tr><td></td><td class="error"><%out.print(error);%></td><tr>
													<%}
												}
												%>
											</table>
											</center>
										</form>
					</center>
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