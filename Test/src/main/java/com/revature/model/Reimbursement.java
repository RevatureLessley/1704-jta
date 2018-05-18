package com.revature.model;

import java.io.Serializable;

public class Reimbursement implements Serializable{

	private static final long serialVersionUID = 3082336176827941428L;

	private int reimbursementId;
	private int requestorId;
	private int approverId;
	private String category;
	private String status;
	private String submissionDate;
	private String resolutionDate;
	private double amount;
	
	public Reimbursement() {}

	public Reimbursement(int reimbursementId, int requestorId, int approverId, String category, String status,
			String submissionDate, String resolutionDate, double amount) {
		super();
		this.reimbursementId = reimbursementId;
		this.requestorId = requestorId;
		this.approverId = approverId;
		this.category = category;
		this.status = status;
		this.submissionDate = submissionDate;
		this.resolutionDate = resolutionDate;
		this.amount = amount;
	}
	
	

	public Reimbursement(int requestorId, String category, double amount) {
		super();
		this.requestorId = requestorId;
		this.category = category;
		this.amount = amount;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getRequestorId() {
		return requestorId;
	}

	public void setRequestorId(int requestorId) {
		this.requestorId = requestorId;
	}

	public int getApproverId() {
		return approverId;
	}

	public void setApproverId(int approverId) {
		this.approverId = approverId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getResolutionDate() {
		return resolutionDate;
	}

	public void setResolutionDate(String resolutionDate) {
		this.resolutionDate = resolutionDate;
	}

	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + approverId;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + reimbursementId;
		result = prime * result + requestorId;
		result = prime * result + ((resolutionDate == null) ? 0 : resolutionDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submissionDate == null) ? 0 : submissionDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (approverId != other.approverId)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (requestorId != other.requestorId)
			return false;
		if (resolutionDate == null) {
			if (other.resolutionDate != null)
				return false;
		} else if (!resolutionDate.equals(other.resolutionDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submissionDate == null) {
			if (other.submissionDate != null)
				return false;
		} else if (!submissionDate.equals(other.submissionDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", requestorId=" + requestorId + ", approverId="
				+ approverId + ", category=" + category + ", status=" + status + ", submissionDate=" + submissionDate
				+ ", resolutionDate=" + resolutionDate + "]";
	}
	
	
	
	
	
	
}
