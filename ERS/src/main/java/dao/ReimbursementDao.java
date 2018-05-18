package dao;

import java.io.InputStream;
import java.util.List;

import model.Reimbursement;

public interface ReimbursementDao {
	boolean createReimbursement(String inUsername, String inStatus, InputStream inImage, String inCategory);
	Reimbursement readReimbursement(int inReimbursementid);
	List<Reimbursement> readReimbursements();
	List<Reimbursement> readReimbursements(String inUsername);
	boolean updateReimbursement(int inReimbursementid, String inStatus, String inManager);
	boolean deleteReimbursement(String inUsername);
}
