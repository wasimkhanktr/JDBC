package UserInputJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {

    public static void main(String[] args) throws SQLException {
		
		// Establishing connection to the database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbms", "root", "root");
		Scanner sc = new Scanner(System.in);
		String sql = "";
		
		// Prompt user for delete option
		System.out.println("Delete by id press 1 \nDelete by name press 2");
		int n = sc.nextInt();
		sc.nextLine();  // Consume the newline
		
		// Choose deletion by ID or name
		if (n == 1) {
			System.out.println("Enter the id: ");
			int id = sc.nextInt();
			sql = "DELETE FROM STUDENT WHERE ID = ?";
			
			// Creating PreparedStatement and setting the ID parameter
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			// Executing the delete operation
			int rowsAffected = ps.executeUpdate();
			System.out.println("Deleted " + rowsAffected + " row(s) with ID = " + id);
			
		} else if (n == 2) {
			System.out.println("Enter the name: ");
			String name = sc.nextLine();
			sql = "DELETE FROM STUDENT WHERE NAME = ?";
			
			// Creating PreparedStatement and setting the name parameter
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			
			// Executing the delete operation
			int rowsAffected = ps.executeUpdate();
			System.out.println("Deleted " + rowsAffected + " row(s) with name = '" + name + "'");
		} else {
			System.out.println("Invalid option selected.");
		}
		
		// Closing resources
		sc.close();
		con.close();
    }
}
