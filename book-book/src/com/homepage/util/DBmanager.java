package com.homepage.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBmanager {
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"book","book");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DBmanager 에게서 에러가 났음");
		}
		return conn;
	}
}
