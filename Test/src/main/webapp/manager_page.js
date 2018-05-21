window.onload = function(){
  fillReimbursementTable();
}

function fillReimbursementTable(){
  let xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4 && xhr.status === 200) {
      let reimbursementObject = JSON.parse(xhr.responseText);

      for (let reimbursement of reimbursementObject){
    	
        let id = reimbursement.reimbursementId;
        let requestorId = reimbursement.requestorId;
        let approverId = reimbursement.approverId; 
        let category = reimbursement.category;
        let amount = reimbursement.amount;
        let status = reimbursement.status;
        let submissionDate = reimbursement.submissionDate;
        let resolutionDate = reimbursement.resolutionDate;
        /*let form = document.createElement("form");
        form.setAttribute("method", "POST");
        form.setAttribute("action", "resolve.do");*/
        
        
        let row = document.createElement("tr");
        let tdId = document.createElement("td");
        let tdRequestorId = document.createElement("td");
        let tdApproverId = document.createElement("td");
        let tdCategory = document.createElement("td");
        let tdAmount = document.createElement("td");
        let tdStatus = document.createElement("td");
        let tdSubmissionDate = document.createElement("td");
        let tdResolutionDate = document.createElement("td");
        let form = document.createElement("form");
        form.setAttribute("method", "POST");
        form.setAttribute("action", "resolve.do");
        let tdButton = document.createElement("button");
        let approve = document.createElement("button");
        let reject = document.createElement("button")
        
        approve.setAttribute("type", "submit");
        approve.setAttribute("class", "btn btn-primary");
        approve.setAttribute("value", "Approved");
        approve.setAttribute("name", "approve");
        approve.textContent = "Approve";
        
        reject.setAttribute("type","submit");
        reject.setAttribute("class","btn btn-primary");
        reject.setAttribute("value","Rejected");
        reject.setAttribute("name","reject");
        reject.textContent = "Reject";
        
        tdButton.appendChild(approve);
        tdButton.appendChild(reject);

        tdId.textContent = id;
        tdRequestorId.textContent = requestorId;
        tdApproverId.textContent = approverId;
        tdCategory.textContent = category;
        tdAmount.textContent = amount;
        tdStatus.textContent = status;
        tdSubmissionDate.textContent = submissionDate;
        tdResolutionDate.textContent = resolutionDate;

        row.appendChild(tdRequestorId);
        row.appendChild(tdId);
        row.appendChild(tdApproverId);
        row.appendChild(tdCategory);
        row.appendChild(tdAmount);
        row.appendChild(tdStatus);
        row.appendChild(tdSubmissionDate);
        row.appendChild(tdResolutionDate);
        
        let input = document.createElement("input");
        input.setAttribute("name", "reimbursement");
        input.setAttribute("type", "hidden");
        input.setAttribute("value", id);
        
        form.appendChild(input);
        form.appendChild(tdButton);
        if (status == "pending")
        	row.appendChild(form);

        document.getElementById("reimbursement").appendChild(row);
      }
    }
  }
  xhr.open("GET", "http://localhost:8080/Test/getAllReimbursements.ajax");

  xhr.send();
}