<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h2> Employee Update</h2>
	<%@ page import="com.revature.model.Employee" %>
	<% Employee employee = (Employee) request.getSession().getAttribute("authorizedUser"); %>
	<% String eid = Integer.toString(employee.getEid());%>
	
	<div class="container">
		<div class="cod-md-6 col-md-offset-3">
			<form action= "update.do " method="post">
				
				<div class="form-group">
					<input type="text" name="firstname" class="form-control" placeholder=" New first Name">
				</div>

				<div class="form-group">
					<input type="text" name="lastname" class="form-control" placeholder=" New last Name">
				</div>
				
				<div class="from-group">
					<input type="number" name="eid" class="form-control"  readonly placeholder= <%= eid %> value = <%= eid%> >		
				</div>
			
				
				<div class="button-group">
					<input type="submit" class="btn btn-success" value="Submit">
					<input type="reset" class="btn btn-danger" value="Reset">
				</div>
			</form>
		</div>
	</div>
	
	
</body>
</html>