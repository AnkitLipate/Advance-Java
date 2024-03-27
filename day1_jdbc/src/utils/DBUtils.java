package utils;

import java.sql.*;

public class DBUtils {
	// static data member : Connection => fixed connectivity
	private static Connection cn;

	// add static method to open the db connection
	public static Connection openConnection() throws /* ClassNotFoundException, */ SQLException {
		// load JDBC driver class in method area
	//	Class.forName("com.mysql.cj.jdbc.Driver");
		// establish db connection
		String dbURL = "jdbc:mysql://localhost:3306/advancejava?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
		cn = DriverManager.getConnection(dbURL, "root", "root123");
		
		return cn;
	}

}
