package utils;

import java.sql.*;

public class DBUtils {
//add static method to return DB connection instance 
	//modify the code below, to enusure SINGLETON instance of the DB connection 
	//(not a scalable solution, will be replace by connection pool, from 
	//hibernate onwords)
	// static data member : Connection => fixed connectivity
	private static Connection cn;
 
	// add static method to open the db connection
	public static Connection fetchDBConnection() throws  ClassNotFoundException,  SQLException {
		// load JDBC driver class in method area
		Class.forName("com.mysql.cj.jdbc.Driver");
		// establish db connection
		if(cn==null) {
			String dbURL = "jdbc:mysql://localhost:3306/dac24?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
  			cn = DriverManager.getConnection(dbURL, "root", "root123");
  			System.out.println("singleton instance of db cn created");
		}
		return cn;
	}

	//add static method to close db connection
	public static void closeConnection() throws SQLException
	{
		if(cn != null)
			cn.close(); 
	}
}
