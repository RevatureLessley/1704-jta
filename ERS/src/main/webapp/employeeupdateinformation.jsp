<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Employee" %>
<%@ page import="model.Information" %>
<%@ page import="model.Reimbursement" %>
<% Employee employee = (Employee) request.getSession().getAttribute("employee"); %>
<% Information information = (Information) request.getSession().getAttribute("information"); %>
<% Reimbursement reimbursement = (Reimbursement) request.getSession().getAttribute("reimbursement"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' type='text/css' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='css/updateinformation.css'>
<title>Employee: information</title>
</head>
<body>
<div id='container' class='container'>	
	<h2><%= employee.getUsername() %> update information</h2>
	<a class='btn btn-primary button' href='employee-home.do'>Home</a>
	
	<form id='form' action='EmployeeInformationServlet' method='post'>
		<input type='text' name='first' placeholder='<%= information.getFirstname() %>'>
		<input type='text' name='middle' placeholder='<%= information.getMiddlename() %>'>
		<input type='text' name='last' placeholder='<%= information.getLastname() %>'>
		<input class='btn btn-primary button' type='submit' value='Submit'>
	
	</form>

	
</div>

</body>
</html>