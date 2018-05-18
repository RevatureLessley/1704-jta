<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Manager" %>
<% 
	Manager manager = (Manager) request.getSession().getAttribute("manager");
	if(manager == null){
		request.setAttribute("message", "lost session; relogin");
		request.getRequestDispatcher("manager-login.do").forward(request, response);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager: create reimbursement</title>
<link rel='stylesheet' type='text/css' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='css/index.css'>
<link rel='stylesheet' type='text/css' href='css/updateinformation.css'>
<link rel='stylesheet' type='text/css' href='css/createreimbursement.css'>
</head>
<body>
<div id='container' class='container'>	
	<h2><%= manager.getUsername() %> create reimbursement</h2>
	<form id='form' action='ManagerReimbursementServlet' enctype='multipart/form-data' method='post'>
		<a id='button' class='btn btn-primary' href='manager-home.do'>Home</a>
		<div class='radio'>
			<input type='radio' name='category' value='lodging'>
			<label for='lodging'>lodging</label>
		</div>
		
		<div class='radio'>
			<input type='radio' name='category' value='travel'>
			<label for='travel'>travel</label>
		</div>
		
		<div class='radio'>
			<input type='radio' name='category' value='food'>
			<label for='food'>food</label>
		</div>
		
		<div class='radio'>
			<input type='radio' name='category' value='other'>
			<label for='other'>other</label>
		</div>
		
		<input class='btn btn-primary' type='file' name='image' value='image'>
		<input class='btn btn-primary' type='submit' value='submit'>
	</form>
</div>

</body>
</html>