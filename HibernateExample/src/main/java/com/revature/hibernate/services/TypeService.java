package com.revature.hibernate.services;

import java.util.List;

import com.revature.hibernate.dao.TypeDao;
import com.revature.hibernate.dao.TypeDaoImplementation;
import com.revature.hibernate.entity.Type;

public class TypeService {

	private static TypeDao dao = TypeDaoImplementation.getInstance();
	private TypeService() {}
	
	public static List<Type> getAllTypes() {
		return dao.getAllTypes();
	}
	
	public static boolean insertType(String type) {
		return dao.insertType(type);
	}
}
