package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;

public interface ReimbursementDao {

	public abstract List<Reimbursement> getAllReimbursements(int employeeId);
	public abstract List<Reimbursement> getReimbursements(int employeeId);
	public abstract boolean insertReimbursement(Reimbursement reimbursement);
	public abstract boolean updateReimbursement(int reimbursementId, int approverId, String status);
	
}
