package com.bookingApp;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class DBConnection {
	static String url="jdbc:mysql://localhost:3306/travelApp";
	static String user="root";
	static String pass="root@39";
	public static Connection getConnection() {
		Connection con=null;
		try {
			con=DriverManager.getConnection(url,user,pass);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
 
}