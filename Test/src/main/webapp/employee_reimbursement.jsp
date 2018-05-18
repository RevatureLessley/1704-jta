<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Employee Reimbursement</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style>
    h2,h3{
        margin:auto;
        text-align: center;
    }
    .radioheader{
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
                <li class="active"><a href="employee_update.jsp">Update Information</a></li>
                <li><a href="employee_reimbursement.jsp">Employee Reimbursement</a></li>
            </ul>
            <ul class="navbar-nav nav navbar-right">
              <li> <a href="logout.do">Log Out <span class ="glyphicon glyphicon-log-out"></span></a></li>
            </ul>
        </nav>
    </div>

<div class="container">
  <h2>Reimbursements</h2>
  <div class="table-responsive">
    <table class="table">
    <thead>
      <tr>
        <th>Reimbursement ID</th>
        <th>Category</th>
        <th>Amount</th>
        <th>Status</th>
        <th>Submission Date</th>
      </tr>
    </thead>
    <tbody id="reimbursement">

    </tbody>
  </table>
</div>
</div>
<br><br><br><br>
<h3>New Reimbursement Form</h3><br><br>
<div class="container">
  <form class="form-horizontal" action="submitReimbursement.do" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="amount">Amount: </label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="amount" placeholder="Enter Reimbursement Amount" name="amount">
      </div>
    </div>
    <div class="col-sm-offset-4 col-sm-10>"
      <label for="category">Category</label><br>
    </div>
    <div class="col-sm-offset-2 col-sm-10">
    <label class="radio-inline">
      <input type="radio" name="optradio">lodging
    </label>
    <label class="radio-inline">
      <input type="radio" name="optradio">travel
    </label>
    <label class="radio-inline">
      <input type="radio" name="optradio">food
    </label>
    <label class="radio-inline">
      <input type="radio" name="optradio">other
    </label>
    </div>
    <br><br>
    <div class="form-group">
      <div class="col-sm-offset-4 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="./employee_reimbursement.js"></script>
</body>
</html>

