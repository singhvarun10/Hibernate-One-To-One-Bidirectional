package com.varun.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/hb_student_tracker?serverTimezone=IST";
		String URL= "jdbc:mysql://127.0.0.1:3306/hb_student_tracker?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
		
		String url2 = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user = "varun";
		String password = "varun";
		
		try {
			System.out.println("Connecting to db " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(url2,user,password);
			System.out.println("Connection successful");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
