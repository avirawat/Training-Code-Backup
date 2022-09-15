package com.bookApp.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookDAO {

	static Connection connection;                        //Connection Type variable           

	public static Connection openConnection() {             //Opening Connection

		String url = "jdbc:mysql://localhost:3306/training"; //DataBase Path
		try {
			connection = DriverManager.getConnection(url, "root", "root"); //connecting with database mysql
		} catch (SQLException e) {
		
			e.printStackTrace();                           //handling Exception
		}
		return connection;
	}

	public static void closeConnection() {             //Connection closing function
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
}
