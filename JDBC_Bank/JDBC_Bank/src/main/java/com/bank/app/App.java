package com.bank.app;

import com.bank.model.Product;
import com.bank.service.ProductService;

public class App {

	public static void main(String[] args) {
//		User user = new User("Firstname", "Lastname", "Password", 0, 0);
//		System.out.println("User successfully inserted? " + UserService.insertUser(user));
//		User user1 = UserService.getUser(user.getFirst_name(),user.getLast_name());
//		System.out.println("Username: " + user.getFirst_name());
//		System.out.println("Password: " + user.getPassword());
//		System.out.println("Result when hashing: " + UserDaoImpl.getInstance().getPasswordHash(user));
//		System.out.println(user1.getPassword());
//		System.out.println("Are they the same? " + 
//		(user1.getPassword().equals(UserDaoImpl.getInstance().getPasswordHash(user))));
//		UserService.login(user);
		Product product = new Product("Doritos", .99, 100);
		System.out.println("User successfully inserted? " + ProductService.insertProduct(product));
	//	Product product1 = ProductService.getProduct(product);
		System.out.println("Product: " + product.getProduct_name());
		System.out.println("Price: " + product.getProduct_price());
		
	}
}