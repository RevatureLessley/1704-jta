<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.revature.entity.Employee"%>
<%@ page import="com.revature.entity.Information"%>
<%@ page import="com.revature.entity.Reimbursement"%>
<%@ page import="java.util.List"%>
<%	Employee employee = (Employee) request.getSession().getAttribute("employee");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee: reimbursement</title>
<link rel='stylesheet' type='text/css' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='css/readreimbursement.css'>
</head>
<body>
<div id='container' class='container'>
	<h2><%=employee.getUsername()%>	read reimbursement </h2>
	<div>
		<a class='btn btn-primary' href='employee-home.do'>Home</a>
		<button class='btn btn-secondary' id='pending'>pending</button>
		<button class='btn btn-secondary' id='resolved'>resolved</button>
		<button class='btn btn-secondary' id='all'>all</button>
	</div>
	<table class='table'>
		<thead class='thead'>
			<tr>
				<th scope='col'>id</th>
				<th scope='col'>status</th>
				<th scope='col'>image</th>
				<th scope='col'>category</th>
			</tr>
		</thead>
		<tbody>				
		</tbody>
	</table>
</div>
<script
  src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
  integrity="sha256-3edrmyuQ0w65f8gfBsqowzjJe2iM6n0nKciPUp8y+7E="
  crossorigin="anonymous"></script>
<script type='text/javascript' src='js/employeereadreimbursement.js'></script>
</body>
</html>