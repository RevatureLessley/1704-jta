window.onload = function(){
  fillEmployeesTable();
}

function fillEmployeesTable(){
  let xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4 && xhr.status === 200) {
      let employeeObject = JSON.parse(xhr.responseText);

      for (let employee of employeeObject){
        let id = employee.employeeId;
        let firstName = employee.firstName;
        let lastName = employee.lastName;
        let position = employee.position;
        let salary = employee.salary;
        let dob = employee.DOB;

        let row = document.createElement("tr");
        let tdId = document.createElement("td");
        let tdFirstName = document.createElement("td");
        let tdLastName = document.createElement("td");
        let tdPosition = document.createElement("td");
        let tdSalary = document.createElement("td");
        let tdDOB = document.createElement("td");

        tdId.textContent = id;
        tdFirstName.textContent = firstName;
        tdLastName.textContent = lastName;
        tdPosition.textContent = position;
        tdSalary.textContent = salary;
        tdDOB.textContent = dob;

        row.appendChild(tdId);
        row.appendChild(tdFirstName);
        row.appendChild(tdLastName);
        row.appendChild(tdPosition);
        row.appendChild(tdSalary);
        row.appendChild(tdDOB);

        document.getElementById("employees").appendChild(row);
      }
    }
  }
  xhr.open("GET", "/Test/getEmployees.ajax");

  xhr.send();
}
