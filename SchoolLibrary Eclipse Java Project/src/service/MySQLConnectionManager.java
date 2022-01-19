package service;

import java.sql.*;

public class MySQLConnectionManager {
	
	private static boolean isConnected=false;
	private static Connection connection=null;
	
	public static void initMySQLConnection(String name, String password, String database) {
		if(isConnected==true) 
			throw new IllegalStateException("The MySQL connection must be closed before it can be reinitialised!");
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database,name,password);
			isConnected=true;
			System.out.println("Database connected succcesfully!");
		}catch(Exception exc) {
			System.out.println("Database failed to connect!");
			isConnected=false;
			throw new IllegalStateException("The MySQL connection could not open!");
		}
		return;
	}
	
	public static void closeMySQLConnection() {
		if(isConnected==false) {
			throw new IllegalStateException("The MySQL connection is already closed!");
		}
		try {
			connection.close();
			connection=null;
			isConnected=false;
			System.out.println("Database connection closed succcesfully!");
		} catch (SQLException e) {
			throw new IllegalStateException("The MySQL connection could not close!");
		}
		return;
	}
	
	public static Statement getStatement() throws SQLException  {
		if(!isConnected)
			throw new IllegalStateException("The MySQL connection was closed so this instance of MySQLService is no longer operative!");
		return connection.createStatement();
	}
	
	public static PreparedStatement getPreparedStatement(String wildcardQuery) throws SQLException  {
		if(!isConnected)
			throw new IllegalStateException("The MySQL connection was closed so this instance of MySQLService is no longer operative!");
		return connection.prepareStatement(wildcardQuery);
	}
	
}
