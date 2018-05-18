package design;

public abstract class AbstractReimbursement{
	private int reimbursementid;
	private String employee;
	private String manager;
	private String status;
	private String category;
	
	public AbstractReimbursement(int reimbursementid, String employee, String manager, String status, String category) {
		super();
		this.reimbursementid = reimbursementid;
		this.employee = employee;
		this.manager = manager;
		this.status = status;
		this.category = category;
	}

	public int getReimbursementid() {
		return reimbursementid;
	}

	public void setReimbursementid(int reimbursementid) {
		this.reimbursementid = reimbursementid;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + reimbursementid;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		AbstractReimbursement other = (AbstractReimbursement) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (reimbursementid != other.reimbursementid)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AbstractReimbursement [reimbursementid=" + reimbursementid + ", employee=" + employee + ", manager="
				+ manager + ", status=" + status + ", category=" + category + "]";
	}
}
//String[] statuses = {"pending", "approved", "denied"};
//String[] categories = {"lodging", "travel", "food", "other"};