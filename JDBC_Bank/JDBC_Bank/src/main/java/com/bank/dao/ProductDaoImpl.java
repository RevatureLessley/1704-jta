package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bank.model.Product;
import com.bank.util.ConnectionUtil;

public class ProductDaoImpl implements ProductDao{

	private static ProductDaoImpl instance;
	
	private ProductDaoImpl() {}
	
	public static ProductDaoImpl getInstance() {
		if (instance == null) {
			instance = new ProductDaoImpl();
		}
		return instance;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProduct(Product productName) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM product WHERE product_name = ?");
			stmt.setString(++index, productName.getProduct_name());
			ResultSet rs = stmt.executeQuery();
			// If can be used if just selecting one entry
			if (rs.next()) {
				return new Product(rs.getInt("id"), rs.getString("product_name"), rs.getDouble("product_price"), 
						rs.getInt("product_quantity"));
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public boolean insertProduct(Product product) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL insert_product(?, ?, ?)}");
			stmt.setString(++index, product.getProduct_name());
			stmt.setDouble(++index, product.getProduct_price());
			stmt.setInt(++index, product.getProduct_quantity());
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean deleteProduct(String product) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}