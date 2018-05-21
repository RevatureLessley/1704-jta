<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Manager Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  </head>
  <body>
      <!--The navbar-->
      <div class="container">
          <nav class="navbar navbar-inverse">
              <div class="navbar-header col-md-2">
                  <a href="./index.html" class="navbar-brand">ECorp</a>
              </div>
              <ul class="navbar-nav nav col-md-8">
                  <li><a href="manager_page.jsp">View Reimbursements</a></li>
                  <li><a href="view_employees.jsp">View Employees</a></li>
                  <li><a href="manager_reimbursement.jsp">My Reimbursements</a></li>
              </ul>
              <ul class="navbar-nav nav navbar-right">
                <li> <a href="logout.do">Log Out <span class ="glyphicon glyphicon-log-out"></span></a></li>
              </ul>
          </nav>
      </div>
      
      <%@ page import="com.revature.model.Employee" %>
	  <%Employee fManager = (Employee) request.getSession().getAttribute("authorizedUser"); %>
      
 <div class="container">  
   <input type="text" id="myInput" onkeyup="searchFunction()" placeholder="Search by Employee ID" title="Type in a ID">   
</div>


 <div class="container">
  <h2>Reimbursements</h2>
  <div class="table-responsive">
    <table class="table" id="reimbursementTable">
    <thead>
      <tr>
        <th>Requestor ID</th>
        <th>Reimbursement Id</th>
        <th>Approver Id</th>
        <th>Category</th>
        <th>Amount</th>
        <th>Status</th>
        <th>Submission Date</th>
        <th>Resolution Date</th>
        <th>Resolve</th>
      </tr>
    </thead>
    <tbody id="reimbursement">

    </tbody>
  </table>
</div>
</div>


<script>
function searchFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("reimbursementTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="./manager_page.js"></script>
  </body>
</html>
