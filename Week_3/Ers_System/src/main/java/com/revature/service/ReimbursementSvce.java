package com.revature.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementImpl;
import com.revature.model.Reimbursement;

public class ReimbursementSvce {

private static ReimbursementDAO reimdao = ReimbursementImpl.getInstance(); 
	
	public static String submitReimbursement(HttpServletRequest request, HttpServletResponse response) {
		
		
		System.out.println("inside submit reimbursement");
		
		String eid = request.getParameter("eid");
		String amount = request.getParameter("amount");
		String category= request.getParameter("category");
		
		int newEid= Integer.parseInt(eid);
		double newAmount = Double.parseDouble(amount);
		
		System.out.println("eid : " + newEid);
		System.out.println("amount: " + newAmount);
		System.out.println("category " + category);
		
		
		Reimbursement reimbursement = new Reimbursement(newEid, newAmount, category);
		
		Reimbursement temp = reimdao.getReimbursement(newEid); //to get all the object values
		
				
		if(	reimdao.submitReimbursement(reimbursement)==true) {
			System.out.println("successfully submitted employee reimbursement");  //logger
			/*request.getSession().setAttribute("authorizedUser",reimbursement);*/
		return "/generalEmployeeHome.jsp";	
		}
	
		return "/index.jsp";
		
		
	}
	
	
}
