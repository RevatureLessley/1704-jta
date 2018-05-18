package model;

import java.util.Arrays;

import design.AbstractReimbursement;


public class ReimbursementImage extends AbstractReimbursement{
	private byte[] image;

	public ReimbursementImage(int reimbursementid, String employee, String manager, String status, byte[] image, String category) {
		super(reimbursementid, employee, manager, status, category);
		this.image = image;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(image);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementImage other = (ReimbursementImage) obj;
		if (!Arrays.equals(image, other.image))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimbursementImage [image=" + Arrays.toString(image) + "]";
	}

}
