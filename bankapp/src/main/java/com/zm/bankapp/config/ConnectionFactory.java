package com.zm.bankapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {
	private static Connection con = null;
	public static Connection establishConnection() throws SQLException, ClassNotFoundException {
		if(con==null) {
			ResourceBundle bundle = ResourceBundle.getBundle("com/zm/bankapp/config/dbconfig");
			String dc = bundle.getString("jdbc.driverclass");
			String url = bundle.getString("jdbc.url");
			String user = bundle.getString("jdbc.username");
			String pass = bundle.getString("jdbc.password");
			
			Class.forName(dc);
			con = DriverManager.getConnection(url,user,pass);
			con.setSchema("bank_app");
			return con;
		}
		return con;
	}
}
