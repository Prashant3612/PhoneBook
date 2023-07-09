package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnect {
	private static Connection conn;
	public static Connection getConn()
	{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		String url="jdbc:mysql://localhost/phonebook";
		String username="root";
		String password="prashant";
		 conn=DriverManager.getConnection(url,username,password);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return conn;
}
}
