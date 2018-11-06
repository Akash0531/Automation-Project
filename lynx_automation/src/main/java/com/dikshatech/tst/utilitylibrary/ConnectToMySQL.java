package com.dikshatech.tst.utilitylibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class ConnectToMySQL {

	@Test
	public static void jdbcDbcon() throws Exception {
		// Object of Connection from the Database
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the query
		Statement stmt = null;

		// Object of ResultSet => 'It maintains a cursor that points to the current row
		// in the result set'
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded in Classpath");

			// Open a connection
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/classicmodels?autoReconnect=true&useSSL=false", "root", "root");
			System.out.println("JDBC connected Successfully");

			// Execute a query
			stmt = conn.createStatement();
			String data = "\"Las Vegas\"";
			String sql = "Select * from customers where city =" + data + " GROUP BY customerName";
			resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "  " + resultSet.getString(2) + "  "
						+ resultSet.getString(3) + "  " + resultSet.getString(4) + "  " + resultSet.getString(5));
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {

			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		}
	}
}