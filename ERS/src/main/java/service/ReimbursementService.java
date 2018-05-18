package service;

import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import daoimpl.ReimbursementDaoImpl;
import model.Reimbursement;
import model.ReimbursementImage;

public class ReimbursementService {
	private static Logger logger = Logger.getLogger(ReimbursementService.class);
	private static ReimbursementDaoImpl dao = ReimbursementDaoImpl.getInstance(logger);
	
	public static boolean createReimbursement(String inUsername, String inStatus, InputStream inImage, String inCategory) {
		return dao.createReimbursement(inUsername, inStatus, inImage, inCategory);
	}
	public static Reimbursement readReimbursement(int reimbursementid) {
		return dao.readReimbursement(reimbursementid);
	}
	public static List<Reimbursement> readReimbursements() {
		return dao.readReimbursements();
	}
	public static List<Reimbursement> readReimbursements(String inUsername){
		return dao.readReimbursements(inUsername);
	}
	public static boolean updateReimbursement(int reimbursementid, String inStatus, String inManager) {
		return dao.updateReimbursement(reimbursementid, inStatus, inManager);
	}
	public static boolean deleteReimbursement(String inUsername) {
		return dao.deleteReimbursement(inUsername);
	}
}
