package net.starcup.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/starcupnew";
	
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";
	
	public static Connection getDBConnection() {
		Connection connection;
	    
	    try {
		    Class.forName("com.mysql.jdbc.Driver");
		    
		    // Recupero i dati per la connessione
	        connection = DriverManager.getConnection(DB_URL, USER, PASS);
	    	
	        return connection;
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return null;
	
	}
}
