<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Employee" %>
<% 
	Employee employee = (Employee) request.getSession().getAttribute("employee");
	if(employee == null){
		request.setAttribute("message", "lost session; relogin");
		request.getRequestDispatcher("employee-login.do").forward(request, response);
		
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' type='text/css' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='css/home.css'>
<title>Employee: home</title>
</head>
<body>
<div id='container' class='container'>
	<h1><%= employee.getUsername() %> home</h1>
	<div id='form' class='container'>
		<a class='btn btn-dark button' href='employee-logout.do'>Logout</a>
		<a class='btn btn-primary button' href='employee-read-information.do'>View information</a>
		<a class='btn btn-primary button' href='employee-update-information.do'>Update information</a>
		<a class='btn btn-primary button' href='employee-create-reimbursement.do'>Submit reimbursement</a>
		<a class='btn btn-primary button' href='employee-read-reimbursement.do'>View reimbursement</a>
	</div>
</div>
</body>
</html>