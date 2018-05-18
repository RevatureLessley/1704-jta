package com.revature.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;


public class ConnectionUtil {

	private static final Logger logger = Logger.getLogger(ConnectionUtil.class);
	
	public static Connection getConnection() {
		Properties props = new Properties();
		try (InputStream in = ConnectionUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
			props.load(in);
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
		} catch (FileNotFoundException fnfe) {
			logger.warn(fnfe.getMessage());
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			logger.warn(ioe.getMessage());
		} catch (SQLException sqle) {
			logger.warn(sqle.getMessage());
			logger.warn("SQL State: " + sqle.getSQLState());
			logger.warn("Error Code: " + sqle.getErrorCode());
		} catch (ClassNotFoundException cnfe) {
			logger.warn(cnfe.getMessage());
		}
		return null;
	}
	
	
}
