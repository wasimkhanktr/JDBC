package UserInputJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateData {

    public static void main(String[] args) throws SQLException {
		
		// Establishing the database connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbms", "root", "root");
        Scanner sc = new Scanner(System.in);
        String sql = "";

        // Prompting user to choose what to update
        System.out.println("Enter 1 to update ID, 2 to update Name, 3 to update Age");
        int choice = sc.nextInt();
        sc.nextLine();  // Consume newline
        
        // Defining SQL queries based on user choice
        if (choice == 1) {
            System.out.println("Enter current ID: ");
            int currentId = sc.nextInt();
            System.out.println("Enter new ID: ");
            int newId = sc.nextInt();
            
            sql = "UPDATE STUDENT SET ID = ? WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, newId);
            ps.setInt(2, currentId);
            
            int rowsUpdated = ps.executeUpdate();
            System.out.println("Updated " + rowsUpdated + " row(s) with new ID = " + newId);
            
        } else if (choice == 2) {
            System.out.println("Enter ID of the student whose name you want to update: ");
            int id = sc.nextInt();
            sc.nextLine();  // Consume newline
            System.out.println("Enter new name: ");
            String newName = sc.nextLine();
            
            sql = "UPDATE STUDENT SET NAME = ? WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, newName);
            ps.setInt(2, id);
            
            int rowsUpdated = ps.executeUpdate();
            System.out.println("Updated " + rowsUpdated + " row(s) with new name = " + newName);
            
        } else if (choice == 3) {
            System.out.println("Enter ID of the student whose age you want to update: ");
            int id = sc.nextInt();
            System.out.println("Enter new age: ");
            int newAge = sc.nextInt();
            
            sql = "UPDATE STUDENT SET AGE = ? WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, newAge);
            ps.setInt(2, id);
            
            int rowsUpdated = ps.executeUpdate();
            System.out.println("Updated " + rowsUpdated + " row(s) with new age = " + newAge);
            
        } else {
            System.out.println("Invalid option.");
        }
        
        // Closing resources
        sc.close();
        con.close();
    }
}
