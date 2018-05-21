package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.services.ReimbursementService;

public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReimbursementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = (Employee) request.getSession().getAttribute("authorizedUser");
		int employeeId = employee.getEmployeeId();
		List<Reimbursement> reimbursements = ReimbursementService.getReimbursements(employeeId);
		
		ObjectMapper mapper = new ObjectMapper();
		
		// Write the POJO as JSON to the response
		response.getWriter().write(mapper.writeValueAsString(reimbursements));		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/*public static String approve(HttpServletRequest request, HttpServletResponse response) {
		
	}*/

}
