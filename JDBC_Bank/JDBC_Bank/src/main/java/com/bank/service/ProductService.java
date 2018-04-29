package com.bank.service;

import com.bank.dao.ProductDao;
import com.bank.dao.ProductDaoImpl;
import com.bank.model.Product;

public class ProductService {

private static ProductDao dao = ProductDaoImpl.getInstance();
	
	private ProductService() {}
	
	public static Product getProduct(Product product1) {
		return dao.getProduct(product1);
	}
	
	public static boolean insertProduct(Product product) {
		return dao.insertProduct(product);
	}
	
}
