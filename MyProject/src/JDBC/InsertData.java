package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) throws SQLException {
		
		// Establishing the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDatabase", "root", "root");

        // Creating a Statement object
		Statement stmt = con.createStatement();

        // SQL query to insert data into the Students table
        String sql = "INSERT INTO Students (name, age, marks) "
                   + "VALUES ('John Doe', 20, 85),"
                   + "('Jane Smith', 22, 90),"
                   + "('Mike Johnson', 21, 78)";

        // Executing the query
        int rowsInserted = stmt.executeUpdate(sql);

        System.out.println(rowsInserted + " rows inserted successfully.");
        
        con.close();
	}

}
