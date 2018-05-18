package com.revature.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;

public class ReimbursementService {

	private static ReimbursementDao dao = ReimbursementDaoImpl.getInstance();
	
	private ReimbursementService() {}
	
	public static boolean updateReimbursement(int reimbursementId, int approverId, String status) {
		return dao.updateReimbursement(reimbursementId, approverId, status);
	}
	
	public static List<Reimbursement> getAllReimbursements(){
		return dao.getAllReimbursements();
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
		insertReimbursement(reimbursement);
		
		if (employee.getPosition().equals("Financial Manager")) {
			return "/manager_page.jsp";
		}
		else {
			return "/employee_reimbursement.jsp";
		}
	}
	
}
