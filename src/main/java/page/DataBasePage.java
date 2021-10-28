package page;

import java.sql.*;

public class DataBasePage {

	/*
	 * String columnValue = null; Connection connection = null; Statement statement
	 * = null; ResultSet rs = null;
	 */
	public static String getData(String columnName) throws ClassNotFoundException,SQLException {
	  
	   //setting properties for mysql
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   String sqlUrl = "jdbc:mysql://localhost:3306/august2020";
	   String sqlUsername = "root";
	   String sqlPassword = "Amenlove1@";
	   String query = "Select * from users";   
	   
	   //Create connection to local database
	   Connection  con= DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);   
	   
	   //Empowering the con reference variable to execute queries
	   Statement smt=con.createStatement();   
	   
	   //Delivering the sql query
	    ResultSet  rs = smt.executeQuery(query);
	   while(rs.next()) {
	     return rs.getString(columnName);
	   }
	   return columnName;
	   }
	}




