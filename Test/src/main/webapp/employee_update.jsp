<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Employee Update</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<style>
h2 {
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
				<li><a href="employee_page.jsp">My Information</a></li>
				<li class="active"><a href="employee_update.jsp">Update
						Information</a></li>
				<li><a href="employee_reimbursement.jsp">Employee
						Reimbursement</a></li>
			</ul>
			<ul class="navbar-nav nav navbar-right">
				<li><a href="logout.do">Log Out<span class="glyphicon glyphicon-log-out"></span></a></li>
			</ul>
		</nav>
	</div>


	<div class="container">
		<h2>Update Information Form</h2>
		<form class="form-horizontal" action="update.do" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="fName">First
					Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="firstName"
						placeholder="Enter First Name" name="firstName">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lName">Last Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="lastName"
						placeholder="Enter Last Name" name="lastName">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Update</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>