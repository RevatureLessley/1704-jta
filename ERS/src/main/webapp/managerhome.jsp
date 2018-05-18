<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Manager" %>
<% Manager manager = (Manager) request.getSession().getAttribute("manager"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' type='text/css' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='css/home.css'>
<title>Manager: home</title>
</head>
<body>
<div id='container' class='container'>
	<h2><%= manager.getUsername() %> home</h2>
	<a class='btn btn-dark button' href='index.do'>Logout</a>
	<a class='btn btn-primary button' href='manager-create-reimbursement.do'>Create reimbursement</a>
	<a class='btn btn-primary button' href='manager-update-reimbursement.do'>Review reimbursements</a>
	<a class='btn btn-primary button' href='manager-read-employee.do'>View employees</a>
</div>

</body>
</html>