package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.revature.logging.LogThis;

public class ConnectionUtil {

	private ConnectionUtil() {
	}

	public static Connection getConnection() {
		try (InputStream in = ConnectionUtil.class.getClassLoader().getResourceAsStream("ers_db.properties")) {
			Properties props = new Properties();
			props.load(in);
			Class.forName("oracle.jdbc.OracleDriver");
//			return DriverManager.getConnection(System.getenv("jdbc.url"), System.getenv("jdbc.username"),
//					System.getenv("jdbc.password"));
			return DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"),
					props.getProperty("jdbc.password"));

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException sqle) {
			LogThis.warn(sqle.getMessage());
			LogThis.warn("SQL State: " + sqle.getSQLState());
			LogThis.warn("Error Code: " + sqle.getErrorCode());
		} catch (ClassNotFoundException cnfe) {
			LogThis.warn(cnfe.getMessage());
		}
		return null;
	}


}
