package com.revature.model;
import java.sql.Timestamp;

public class Reimbursement {
	
		private int rid;
		private int eid_fk;
		private int approvedBy;
		private int rejectedBy;
		private String status;
		private Timestamp approvateDate;
		private Timestamp rejectedDate;
		private double amount;
		private byte[] image;
		private String category;
		private Timestamp submitDate;
		
		
		
		public Reimbursement(int eid_fk, double amount, String category) {
			super();
			
			System.out.println("inside reimb cnstr");
			this.eid_fk = eid_fk;
			this.amount = amount;
			this.category = category;
		}
		
	
		public Reimbursement(int rid, String status, Double amount, Timestamp timestamp) {
			this.rid = rid;
			this.status = status;
			this.amount = amount;
			this.submitDate = timestamp;
		}

	

		public int getRid() {
			return rid;
		}
		public void setRid(int rid) {
			this.rid = rid;
		}
		public int getEid_fk() {
			return eid_fk;
		}
		public void setEid_fk(int eid_fk) {
			this.eid_fk = eid_fk;
		}
		public int getApprovedBy() {
			return approvedBy;
		}
		public void setApprovedBy(int approvedBy) {
			this.approvedBy = approvedBy;
		}
		public int getRejectedBy() {
			return rejectedBy;
		}
		public void setRejectedBy(int rejectedBy) {
			this.rejectedBy = rejectedBy;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Timestamp getApprovateDate() {
			return approvateDate;
		}
		public void setApprovateDate(Timestamp approvateDate) {
			this.approvateDate = approvateDate;
		}
		public Timestamp getRejectedDate() {
			return rejectedDate;
		}
		public void setRejectedDate(Timestamp rejectedDate) {
			this.rejectedDate = rejectedDate;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public byte[] getImage() {
			return image;
		}
		public void setImage(byte[] image) {
			this.image = image;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public Timestamp getSubmitDate() {
			return submitDate;
		}
		public void setSubmitDate(Timestamp submitDate) {
			this.submitDate = submitDate;
		}
		
		
	

		
}
