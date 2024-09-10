package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTheData {

	public static void main(String[] args) throws SQLException {
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDatabase","root","root");
		 
		 Statement stmt=con.createStatement();
		 
		 String sql = "UPDATE Students SET marks = 95 WHERE id = 1";
		 
		  // Executing the query
         int rowsAffected = stmt.executeUpdate(sql);

         if (rowsAffected > 0) {
             System.out.println("Row updated successfully.");
         } else {
             System.out.println("No row found with the given id.");
         }
		 
		
		 con.close();
	
	}

}
