<html>
<head>
<link rel="stylesheet"
	href="webjars/bootstrap/3.3.7-1/css/bootstrap.css">
</head>
<body>
	<h2>ERS SYSTEM!</h2>

	<!-- <form action="HelloWorldServlet" method="get">
		<input type="submit" value="service()">
	</form> -->

 <!-- <div class="container">
		<div class="col=md-6">
			<form action="SecondServlet" method="GET">
				<input type="text" name="getInput" placeholder="Enter some text!">
				<input type="submit" class="btn btn-success" value="GET">
			</form>
		</div>
		<div class="col-md-6">
			<form action="SecondServlet" method="POST">
				<input type="text" name="postInput" placeholder="Enter some text!">
				<input type="submit" class="btn btn-danger" value="POST">
			</form>

		</div>
	</div>  -->

	<div class="container">
		<div class="cod-md-6 col-md-offset-3">
			<form action="login.do" method="post">
				<div class="form-group">
					<input type="text" name="username" class="form-control" required
						placeholder="Username">
				</div>

				<div class="form-group">
					<input type="password" name="password" class="form-control"
						required placeholder="Password">
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


