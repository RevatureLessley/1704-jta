<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>submitReimburstment</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>


<script type="text/javascript">
window.onload = function(){
    loadImage();
}

function loadImage() {

	let xhr = new XMLHttpRequest();

	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			<%@ page import="com.revature.dao.ReimbursementService" %>

			var tmp =	<%=request.getParameter("id") %>;
			
			if(tmp == null){
			console.log(tmp);
			test = <%= ReimbursementService.getReimbursmentByIdString(0)%>;
			}
			else{
				test = <%= ReimbursementService.getReimbursmentByIdString(request.getParameter("id"))%>;
			}
			
		}
	}
	
    xhr.open("POST", "/EmployeeReimbursementService/viewEmployeeReimburstment.jsp");
    xhr.send();
};
</script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>