package com.employee.configuration;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

	public Connection con;
	public Statement s;

	public JdbcConnection() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemangement", "root", "Sau@#123@");
			s = con.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
