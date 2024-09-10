package UserInputJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateDB {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);

            // Load the MySQL JDBC driver (optional in newer versions, but good practice)
//            Class.forName("com.mysql.cj.jdbc.Driver");

            // Getting the database name from user input
            System.out.println("Enter the name of the database you want to create: ");
            String dbName = sc.nextLine();

            // Establishing the connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");

            // SQL query with a placeholder for the database name
            String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;  // Placeholder can't be used here

            // Creating a PreparedStatement object (though Statement is better here)
            pstmt = con.prepareStatement(sql);

            // Executing the query
            pstmt.executeUpdate();
            System.out.println("Database '" + dbName + "' created successfully...");

            sc.close();
    }
}
