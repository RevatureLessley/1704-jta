window.onload = function(){
  fillEmployeesTable();
}

function fillEmployeesTable(){
  let xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4 && xhr.status === 200) {
      let employeeObject = JSON.parse(xhr.responseText);

      for (let employee of employeeObject){
        let id = employee.id;
        let firstName = employee.firstName;
        let lastName = employee.lastName;
        let position = employee.position;
        let salary = employee.salary;

        let row = document.createElement("tr");
        let tdId = document.createElement("td");
        let tdfirstName = document.createElement("td");
        let tdlastName = document.createElement("td");
        let tdPosition = document.createElement("td");
        let tdSalary = document.createElement("td");

        tdId.textContent = id;
        tdFirstName.textContent = firstName;
        tdLastName.textContent = lastName;
        tdPosition.textContent = position;
        tdSalary.textContent = salary;

        row.appendChild(tdId);
        row.appendChild(tdCategory);
        row.appendChild(tdAmount);
        row.appendChild(tdStatus);
        row.appendChild(tdSubmissionDate);

        document.getElementById("employees").appendChild(row);
      }
    }
  }
  xhr.open("GET", "/Test/getEmployees.ajax");

  xhr.send();
}
