package com.revature.image;

import java.util.Arrays;

public class Image {

	private int id;
	private byte[] img;
	
	
	public Image(int id, byte[] img) {
		super();
		this.id = id;
		this.img = img;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", img=" + Arrays.toString(img) + "]";
	}
	
	
}
