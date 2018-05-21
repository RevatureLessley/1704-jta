window.onload = function(){
  fillReimbursementTable();
}

function fillReimbursementTable(){
  let xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4 && xhr.status === 200) {
      let reimbursementObject = JSON.parse(xhr.responseText);

      for (let reimbursement of reimbursementObject){
    	console.log(reimbursement);
        let id = reimbursement.reimbursementId;
        let category = reimbursement.category;
        let amount = reimbursement.amount;
        let status = reimbursement.status;
        let submissionDate = reimbursement.submissionDate;

        let row = document.createElement("tr");
        let tdId = document.createElement("td");
        let tdCategory = document.createElement("td");
        let tdAmount = document.createElement("td");
        let tdStatus = document.createElement("td");
        let tdSubmissionDate = document.createElement("td");

        tdId.textContent = id;
        tdCategory.textContent = category;
        tdAmount.textContent = amount;
        tdStatus.textContent = status;
        tdSubmissionDate.textContent = submissionDate;

        row.appendChild(tdId);
        row.appendChild(tdCategory);
        row.appendChild(tdAmount);
        row.appendChild(tdStatus);
        row.appendChild(tdSubmissionDate);

        document.getElementById("reimbursement").appendChild(row);
      }
    }
  }
  xhr.open("GET", "/Test/getReimbursements.ajax");

  xhr.send();
}