<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h6> General Employee Info</h6>
	<%@ page import="com.revature.model.Employee" %>
	<% Employee employee = (Employee) request.getSession().getAttribute("authorizedUser"); %>
 	
 	<div>
 	<h5> Employee id : <%=employee.getEid() %> </h5>
 	<h5> First Name  : <%=employee.getFirstName() %> </h5>
 	<h5> Last Name   : <%=employee.getLastName() %></h5>
 	</div>
 	
		<div>
			<a href="logOut.jsp"> Click here to logout</a>
		</div>

</body>
</html>