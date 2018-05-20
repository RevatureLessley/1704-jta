<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' type='text/css' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='css/login.css'>
<title>Employee: login</title>
</head>
<body>
<div id='container' class='container'>
	<h2>Employee login</h2>
	<div class='form-group forms'>
		<form id='form' action='EmployeeServlet' method='post'>
			<input type='text' name='username' placeholder='Enter username'>
			<input type='password' name='password' placeholder='Enter password'>
			<input class='btn btn-dark' type='submit' value='submit'>
			<p class='text-danger'><%=(String)request.getAttribute("message")%><p>
		</form>
	</div>	
</div>
</body>
</html>
