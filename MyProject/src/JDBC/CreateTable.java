package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) throws SQLException 
	{
		// Establishing the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDatabase", "root", "root");

        // Creating a Statement object
        Statement stmt = con.createStatement();

        // SQL query to create a table
        String sql = "CREATE TABLE Students ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "name VARCHAR(50), "
                    + "age INT, "
                    + "marks INT"
                    + ")";
        
        // Executing the query
        stmt.executeUpdate(sql);

        System.out.println("Table created successfully...");
        
        con.close();
		

	}

}
