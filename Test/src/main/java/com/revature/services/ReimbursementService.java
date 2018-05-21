package com.revature.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.servlets.AjaxDispatcher;

public class ReimbursementService {

	private static ReimbursementDao dao = ReimbursementDaoImpl.getInstance();
	
	private ReimbursementService() {}
	
	public static boolean updateReimbursement(int reimbursementId, int approverId, String status) {
		return dao.updateReimbursement(reimbursementId, approverId, status);
	}
	
	public static List<Reimbursement> getAllReimbursements(int employeeId){
		return dao.getAllReimbursements(employeeId);
	}
	
	public static List<Reimbursement> getReimbursements(int employeeId){
		return dao.getReimbursements(employeeId);
	}
	
	public static boolean insertReimbursement(Reimbursement reimbursement) {
		return dao.insertReimbursement(reimbursement);
	}
	
	public static String submitReimbursement(HttpServletRequest request, HttpServletResponse response) {
		
		Employee employee = (Employee) request.getSession().getAttribute("authorizedUser");
		String amount = request.getParameter("amount");
		String category = request.getParameter("category");
		
		Reimbursement reimbursement = new Reimbursement(employee.getEmployeeId(), category, Double.parseDouble(amount));
		boolean result = insertReimbursement(reimbursement);
		
		/*if(result)
			return "manager_page.jsp";
		else
			return "employee_reimbursement.jsp";*/
		
		if (employee.getPosition().equals("Financial Manager")) {
			return "/manager_page.jsp";
		}
		else {
			return "/employee_reimbursement.jsp";
		}
		
		
	}
	
	public static String resolve(HttpServletRequest request, HttpServletResponse response) {
		
		String approve = request.getParameter("approve");
		String reject = request.getParameter("reject");
		int reimbursementId = Integer.parseInt(request.getParameter("reimbursement"));
		Employee fManager = (Employee) request.getSession().getAttribute("authorizedUser");
		int approverId = fManager.getEmployeeId();
		String resolve = (approve == null) ? reject : approve;
		
		updateReimbursement(reimbursementId, approverId, resolve);
		// System.out.println("inside resolve ");
		return "/manager_page.jsp";
	}
	
	/*public static void getReimbursements(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		
		Employee employee = (Employee) request.getSession().getAttribute("authorizedUser");
		int employeeId = employee.getEmployeeId();
		
		// Get a reference to the ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		
		List<Reimbursement> reimbursements = ReimbursementService.getReimbursements(employeeId);
		System.out.println(reimbursements);
		
		// Write the POJO as JSON to the response
		response.getWriter().write(mapper.writeValueAsString(reimbursements));
	
	}*/
	
}
