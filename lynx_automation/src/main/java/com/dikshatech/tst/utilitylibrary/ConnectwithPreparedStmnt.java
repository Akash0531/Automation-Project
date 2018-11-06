package com.dikshatech.tst.utilitylibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class ConnectwithPreparedStmnt {

	@Test
	public static void jdbcDbcon() throws Exception {
		// Object of Connection from the Database
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the query
		PreparedStatement stmt = null;

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
			String data = "\"Las Vegas\"";
			String sql = "insert into customers values(?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "Harsh");
			stmt.setInt(2, 18);
			stmt.setFloat(3, 2.35f);

			stmt.executeQuery();

		} catch (Exception e) {
			e.getMessage();
		} finally {

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

/**
 * For reference:
 * 
 * BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 * 
 * do{ System.out.println("enter id:"); int id=Integer.parseInt(br.readLine());
 * System.out.println("enter name:"); String name=br.readLine();
 * System.out.println("enter salary:"); float
 * salary=Float.parseFloat(br.readLine());
 * 
 * ps.setInt(1,id); ps.setString(2,name); ps.setFloat(3,salary); int
 * i=ps.executeUpdate(); System.out.println(i+" records affected");
 * 
 * System.out.println("Do you want to continue: y/n"); String s=br.readLine();
 * if(s.startsWith("n")){ break; } }while(true);
 * 
 * con.close(); }}
 * 
 */