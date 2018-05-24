package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementImpl;
import com.revature.model.Reimbursement;

public class ReimbSvce {
	
	private static ReimbursementDAO dao = ReimbursementImpl.getInstance();
	
	private ReimbSvce() {
		
	}
	
	public static List<Reimbursement> getAllReimbursement(){
		System.out.println("inside reimbsvce");
		return dao.viewAllReimbursment();
	}

}
