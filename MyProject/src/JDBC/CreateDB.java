package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        try {
            // Establishing the connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");

            // Creating a Statement object
            stmt = con.createStatement();

            // SQL query to create a database
            String sql = "CREATE DATABASE IF NOT EXISTS MyDatabase";
            stmt.executeUpdate(sql);

            System.out.println("Database created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing resources
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
