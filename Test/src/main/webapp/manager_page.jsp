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
          <!-- The navbar class creates the Navbar styling -->
          <nav class="navbar navbar-inverse">
              <div class="navbar-header col-md-4">
                  <!-- Must use navbar-brand to make the style work -->
                  <a href="./index.html" class="navbar-brand">ECorp</a>
              </div>
              <ul class="navbar-nav nav col-md-4">
                  <!-- to make the items appear as you want, put an <a> inside a <li>-->
                  <li class="active"><a href="view_employees.jsp">View Employees</a></li>
                  <li><a href="employee_reimbursement.jsp">Employee Reimbursement</a></li>
              </ul>
              <ul class="navbar-nav nav navbar-right">
                <li> <a href="logout.do">Log Out <span class ="glyphicon glyphicon-log-out"></span></a></li>
              </ul>
          </nav>
      </div>
      
      <%@ page import="com.revature.model.Employee" %>
	  <%Employee employee = (Employee) request.getSession().getAttribute("authorizedUser"); %>
      

      <div class="container">
  <h2>Reimbursements</h2>
  <div class="table-responsive">
    <table class="table">
    <thead>
      <tr>
        <th>Reimbursement ID</th>
        <th>Requestor Name</th>
        <th>Approver Namer</th>
        <th>Category</th>
        <th>Amount</th>
        <th>Status</th>
        <th>Submission Date</th>
        <th>Approval Date</th>
      </tr>
    </thead>
    <tbody id="reimbursement">

    </tbody>
  </table>
</div>
</div>
  </body>
</html>
