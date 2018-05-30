<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.revature.entity.Employee" %>
<%@ page import="com.revature.entity.Information" %>
<% 	Employee employee = (Employee) request.getSession().getAttribute("employee");
	Information information = (Information) request.getSession().getAttribute("information");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' type='text/css' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='css/information.css'>
<title>Employee: information</title>
</head>
<body>
<div id='container' class='container'>
	<h2><%= employee.getUsername() %> view information</h2>
	<div id='form'>
		<a id='button' class='btn btn-primary' href='employee-home.do'>Home</a>
		<p>First name: <%= information.getFirstname() %></p>
		<p>Middle name: <%= information.getMiddlename() %></p>
		<p>Last name: <%= information.getLastname() %></p>
	</div>
	
</div>

</body>
</html>