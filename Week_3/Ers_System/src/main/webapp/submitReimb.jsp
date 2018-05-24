<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<h6> Submit Reimbursement</h6>
	<%@ page import="com.revature.model.Employee" %>
	<% Employee employee = (Employee) request.getSession().getAttribute("authorizedUser"); %>

	<% String eid = Integer.toString(employee.getEid());%>
	
	<div class="container">
		<div class="cod-md-6 col-md-offset-3">
			<form action= "submit.do " method="post">
			
			<div class="from-group">
						
				<div class="from-group">
					<input type="number" name="eid" class="form-control"  readonly placeholder= <%= eid %> value = <%= eid%> >		
				</div>
						
				</div>
				
				<div class="form-group">
					<input type="number" name="amount" class="form-control" placeholder="amount">
				</div>

				<div class="form-group">
				
				<select name="catetory">
					  <option value="lodging" name="category">lodging</option>
					  <option value="travel" name="category">travel</option>
					  <option value="food" name="category">food</option>
					  <option value="other" name="category">other</option>
				</select>
					<!-- <select type="text" name="category" class="form-control" placeholder="category"> -->
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