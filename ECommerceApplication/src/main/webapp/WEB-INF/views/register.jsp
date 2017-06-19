<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
 <script type= "text/javascript" src="js/register.js"></script>
<title>RegistrationPage</title>
</head>
<body style="background-color: teal;">

<h1 style="background-color: white;" align="center">Welcome to Registration Page</h1>



	<div align="center" style="font: medium;">
		<table>
		<tr>
			<td style="font-size: 30">Username:</td>
			<td><input type="text" name="username" id="username" placeholder="enter username"/><br>
			<br></td>
		</tr>
		
		<tr>
			<td style="font: medium; font-size: medium;">Password:</td>
			<td><input type="password" name="pwd" id="pwd" placeholder="enter password" /><br>
			<br></td>
		</tr>
		
		<tr>
			<td style="font: medium; font-size: medium; ">Email:</td>
			<td><input type="text" name="email" id="email" placeholder="enter email"/><br>
			<br></td>
		</tr>
		
		
			</table>
		<button type="button" value="Register" id="register" style="color: green;">Submit</button><br>
		<a href="/login1">Already Registered? Click here</a>
</div>
	<br>
	<br>



</body>
</html>