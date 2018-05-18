package com.revature.hibernate.dao;

import java.util.List;

import com.revature.hibernate.entity.Type;

public interface TypeDao {

	List<Type> getAllTypes();
	boolean insertType(String type);
}
