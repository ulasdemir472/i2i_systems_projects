package com.i2isystems.hazelcast;

import java.sql.*;
import java.util.Random;



public class Oracle {
	
	public Connection connection(String username, String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe",username,password);

			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public long insertNumbers(Connection conn) throws SQLException {

		String SQL = "INSERT INTO NUMBERS(ID,NUM) " + "VALUES(?,?)";
		Connection connection = conn;
		PreparedStatement statement;
		long startTime = System.currentTimeMillis();
		
		
		try{
			statement = connection.prepareStatement(SQL);
			for (int i = 0; i <20000; i++) {
			    Random rand = new Random();
			    int rand_int = rand.nextInt();
			    statement.setInt(1,rand_int);
			    statement.setInt(2,rand_int);
			}

				statement.executeUpdate();
				
			
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		long endTime = System.currentTimeMillis();

		return endTime - startTime;

	}

	public long selectNumbers(Connection conn) throws SQLException {


		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from numbers");

		long startTime = System.currentTimeMillis();

		while (rs.next()) {
			rs.getInt(1);
			rs.getInt(2);
		}
		
		long endTime = System.currentTimeMillis();

		return endTime - startTime;
	}
	
	public String truncateUsersTable(Connection conn) {
		
		String SQL = "truncate table users";
		Connection connection = conn; 
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(SQL);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Users table truncated";
		
	}

	public void closeConnection(Connection conn) throws SQLException {
		conn.close();

	}

}
