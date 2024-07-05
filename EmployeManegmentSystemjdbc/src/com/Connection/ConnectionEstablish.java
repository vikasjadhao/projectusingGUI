package com.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionEstablish {
	
	public static Connection createConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdvantoInfotech","root","9588404653");
		
		return con;
	}

}
