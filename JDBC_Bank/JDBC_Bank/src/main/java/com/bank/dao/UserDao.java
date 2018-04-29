package com.bank.dao;

import java.util.List;
import com.bank.model.User;

public interface UserDao {
	
	List<User> getAllUsers();
	User getUser(String firstname, String lastname);
	boolean insertUser(User user);
	String getPasswordHash(User user);
}
