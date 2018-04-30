package com.bank.dao;

import java.util.List;

import com.bank.model.Product;
import com.bank.model.User;

public interface UserDao {
	
	List<User> getAllUsers();
	User getUser(String firstname, String lastname);
	boolean insertUser(User user);
	String getPasswordHash(User user);
	int getUserId(User user);
	int getApproved(User user);
	int getLocked(User user);
	boolean approveAccount(User user);
	boolean lockAccount(User user);
	boolean unlockAccount(User user);
	
}