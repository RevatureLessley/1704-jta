package com.revature.dao;

import java.util.List;

import com.revature.model.Reimbursement;

public interface ReimbursementDAO {
	
	public boolean submitReimbursement(Reimbursement reimbursement);
	public Reimbursement getReimbursement(int eid);
	public List<Reimbursement> viewAllReimbursment();
}



