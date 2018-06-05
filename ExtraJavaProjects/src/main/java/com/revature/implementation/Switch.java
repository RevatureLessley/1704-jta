package com.revature.implementation;

public class Switch {

	public static String modifyString(String modify) {
		return modify.substring(1, 2).concat(modify.substring(0, 1)).concat(" ").concat(modify.substring(2));
	}

}
