package model;

import design.AbstractReimbursement;
import java.io.InputStream;

public class Reimbursement extends AbstractReimbursement{
	private InputStream image;
	
	public Reimbursement(int reimbursementid, String employee, String manager, 
			String status, InputStream image, String category) {
		super(reimbursementid, employee, manager, status, category);
		this.image = image;
	}

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Reimbursement [image=" + image + "]";
	}
}

//String[] statuses = {"pending", "approved", "denied"};
//String[] categories = {"lodging", "travel", "food", "other"};
