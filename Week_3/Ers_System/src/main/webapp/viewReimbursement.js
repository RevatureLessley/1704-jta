window.onload = function() {
    populateTodosTable();
}

function populateTodosTable() {
    // Step 1: Create an XMLHttpRequest object
    let xhr = new XMLHttpRequest();

    // Step 2: Define a callback function to onreadystatechange
    xhr.onreadystatechange = function() {
        //Step 5: Handle the response
        if (xhr.readyState === 4 && xhr.status === 200) {
            let reimbursementList = JSON.parse(xhr.responseText);
            // for...of iterates similiar to Java's enhanced for loop
            for (let Reimbursement of reimbursementList) {
                // Get the properties of each element in the JSON Response
                let id = Reimbursement.rid;
                let status = Reimbursement.status;
                let reimbursementAmount = Reimbursement.amount;
             
                // Dynamically create the HTML tags
                let row = document.createElement("tr");
                
                let tdId = document.createElement("td");
                let tdStatus = document.createElement("td");
                let tdReimbursementAmount = document.createElement("td");
              
                // We assign each td their corresponding value
                tdId.textContent = id;
                tdStatus.textContent = status;
                tdReimbursementAmount.textContent = reimbursementAmount;
               


                // We add each td to the tr
                row.appendChild(tdId);
                console.log(tdId);
                
                row.appendChild(tdStatus);
                console.log(tdStatus);
                
                row.appendChild(tdReimbursementAmount);
                console.log(tdReimbursementAmount);
            
                
              

                // Append the row to the tbody
                document.getElementById("reimbursementTable").appendChild(row);
            }
        }
    }

    // Step 3: Call the open() method
    xhr.open("POST", "http://localhost:8080/Ers_System/viewReimbursement.ajax");

    // Step 4: Call the send() method
    xhr.send();
}