<!DOCTYPE html>

<head>
  <meta charset="utf-8">
  <title>View Employees</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <style>
    h2{
      margin: auto;
      text-align: center;
    }
  </style>
</head>
<body>
  <!--The navbar-->
  <div class="container">
      <nav class="navbar navbar-inverse">
          <div class="navbar-header col-md-4">
              <a href="./index.html" class="navbar-brand">ECorp</a>
          </div>
          <ul class="navbar-nav nav col-md-4">
              <li class="active"><a href="view_employees.jsp">View Employees</a></li>
              <li><a href="employee_reimbursement.jsp">Employee Reimbursement</a></li>
          </ul>
          <ul class="navbar-nav nav navbar-right">
            <li> <a href="logout.do">Log Out <span class ="glyphicon glyphicon-log-out"></span></a></li>
          </ul>
      </nav>
  </div>

  <div class="container">
    <h2>Employees</h2>
    <br>
    <div class="table-responsive">
      <table class="table">
        <thead>
          <tr>
            <th>Employee ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Position</th>
            <th>Salary</th>
          </tr>
        </thead>
        <tbody id="employees">

        </tbody>
      </table>
    </div>
  </div>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="./view_employee.js"></script>
</body>
</html>