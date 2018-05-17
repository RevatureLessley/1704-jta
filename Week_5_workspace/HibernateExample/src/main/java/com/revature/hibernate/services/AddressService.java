package com.revature.hibernate.services;

import java.util.List;

import com.revature.hibernate.dao.AddressDao;
import com.revature.hibernate.dao.AddressDaoImpl;
import com.revature.hibernate.entity.Address;

public class AddressService {

	private static AddressDao dao = AddressDaoImpl.getInstance();
	
	private AddressService () {}
	
	public static List<Address> getAllAddresses(){
		return dao.getAllAddresses();
	}
}
