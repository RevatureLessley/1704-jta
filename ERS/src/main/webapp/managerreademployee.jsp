<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.revature.entity.Manager" %>
<% Manager manager = (Manager) request.getSession().getAttribute("manager"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager: employees</title>
<link rel='stylesheet' type='text/css' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='css/information.css'>
</head>
<body>
<div id='container' class='container'>
	<h2><%= manager.getUsername() %> view employees</h2>
	<a id='button' class='btn btn-primary' href='manager-home.do'>Home</a>
	<table id='employee' class='table'>
		<thead class='thead'>
			<tr scope='col'>
				<th>id</th>
				<th>Username</th>
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
<script type='text/javascript' src='js/managerreademployee.js'></script>
</body>
</html>