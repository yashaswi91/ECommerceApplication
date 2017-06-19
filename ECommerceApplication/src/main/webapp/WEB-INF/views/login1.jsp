<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

    <script type="text/javascript">
window.history.forward();
function noBack(){
	window.history.forward();
        }
    </script>

    <!--To check user credential by Rest Link-->
    <script src="js/login.js"></script>
    
    <title>ECommerce Portal</title>
</head>
<body style="background-color: teal;" onLoad="noBack();">
    <h1 align="center" style="background-color: white;">Welcome to the ECommerce Online shopping portal</h1>
    <h2 align="center">Customer Login Page:</h2>
    
    <div align="center">
        <table>
            <tr>
                <td>User Name: </td>
                <td><input type="text" id="username", name="username" placeholder="Enter username here" size="30" required="required" /><br><br></td>
            </tr>
            
            <tr>
                <td>Password: </td>
                <td><input type="password" id="pass" name="pass" placeholder="Enter password here" size="30" required="required" /><br><br></td>
            </tr>

            <tr>
                <td><input type="button" value="Login" name="login" id="login" width="40px;" /></td>
            </tr>
        </table>
    </div>
    <br>
        <h3><font>New user? <a href="/register">Click here to Register</a></font></h3>
   
</body>
</html>