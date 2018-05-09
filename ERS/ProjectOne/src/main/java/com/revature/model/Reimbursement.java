package com.revature.model;

import java.io.Serializable;
import java.sql.Timestamp;

public abstract class Reimbursement implements Serializable{


	private static final long serialVersionUID = 1885261075979118554L;
	
	protected int id;
	protected double amount;
	protected String category;
	protected int requestor_id;
	protected int approver_id;
	protected boolean status;
	protected Timestamp timemade;
	protected Timestamp timeapproved;
	
	protected String reason;
	
	public Reimbursement() {};
	
	public Reimbursement(int id, double amount, int requestor_id, boolean status) {
		super();
		this.id = id;
		this.amount = amount;
		this.requestor_id = requestor_id;
		this.status = status;
	}

	public Reimbursement(int id, double amount, int requestor_id, int approver_id, boolean status, Timestamp timemade,
			Timestamp timeapproved, String reason) {
		super();
		this.id = id;
		this.amount = amount;
		this.requestor_id = requestor_id;
		this.approver_id = approver_id;
		this.status = status;
		this.timemade = timemade;
		this.timeapproved = timeapproved;
		this.reason = reason;
	}
	
	
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getRequestor_id() {
		return requestor_id;
	}
	public void setRequestor_id(int requestor_id) {
		this.requestor_id = requestor_id;
	}
	public int getApprover_id() {
		return approver_id;
	}
	public void setApprover_id(int approver_id) {
		this.approver_id = approver_id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Timestamp getTimemade() {
		return timemade;
	}
	public void setTimemade(Timestamp timemade) {
		this.timemade = timemade;
	}
	public Timestamp getTimeapproved() {
		return timeapproved;
	}
	public void setTimeapproved(Timestamp timeapproved) {
		this.timeapproved = timeapproved;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + approver_id;
		result = prime * result + id;
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + requestor_id;
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((timeapproved == null) ? 0 : timeapproved.hashCode());
		result = prime * result + ((timemade == null) ? 0 : timemade.hashCode());
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
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (approver_id != other.approver_id)
			return false;
		if (id != other.id)
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (requestor_id != other.requestor_id)
			return false;
		if (status != other.status)
			return false;
		if (timeapproved == null) {
			if (other.timeapproved != null)
				return false;
		} else if (!timeapproved.equals(other.timeapproved))
			return false;
		if (timemade == null) {
			if (other.timemade != null)
				return false;
		} else if (!timemade.equals(other.timemade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", requestor_id=" + requestor_id + ", approver_id="
				+ approver_id + ", status=" + status + ", timemade=" + timemade + ", timeapproved=" + timeapproved
				+ ", reason=" + reason + "]";
	}


	
	
	
	
}
