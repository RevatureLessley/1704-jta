<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Employee Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<style>
#einfo {
	margin: auto;
	text-align: center;
}
</style>
</head>
<body>
	<!--The navbar-->
	<div class="container">
		<nav class="navbar navbar-inverse">
			<div class="navbar-header col-md-2">
				<a href="./index.html" class="navbar-brand">ECorp</a>
			</div>
			<ul class="navbar-nav nav col-md-8">
				<li><a href="employee_page.jsp">My Information</a>
				<li><a href="employee_update.jsp">Update
						Information</a></li>
				<li><a href="employee_reimbursement.jsp">Employee
						Reimbursement</a></li>
			</ul>
			<ul class="navbar-nav nav navbar-right">
				<li><a href="logout.do">Log Out<span class="glyphicon glyphicon-log-out"></span></a></li>
			</ul>
		</nav>
	</div>
	<%@ page import="com.revature.model.Employee" %>
	<%Employee employee = (Employee) request.getSession().getAttribute("authorizedUser"); %>

	<h2 id="einfo">Employee Information</h2>
	<br>

	<div class="container">
		<div class="col-md-7">
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Date Of Birth</th>
						<th>Salary</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=employee.getFirstName() %></td>
						<td><%=employee.getLastName() %></td>
						<td><%=employee.getDOB() %></td>
						<td><%=employee.getSalary() %></td>
					</tr> 
				</tbody>
				
			</table>
		</div>
	</div>


</html>
