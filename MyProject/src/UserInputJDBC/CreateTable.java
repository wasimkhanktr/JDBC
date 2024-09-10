package UserInputJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateTable {

	public static void main(String[] args) throws SQLException 
	{
		
		// Establishing the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbms", "root", "root");

        // Creating a Statement object
        Statement stmt = con.createStatement();
        
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter Your Table name : ");
        String table=sc.nextLine();
       
        
        System.out.println("How many columns do you want to add?: ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume newline left by nextInt()

        String sql = "CREATE TABLE "+table+" (\n";

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter column name (e.g., columnName): ");
            String col = sc.nextLine();

            System.out.println("Enter data type (e.g., INT, VARCHAR(50)): ");
            String data = sc.nextLine();

            System.out.println("Do you want to add any key constraint (yes/no)?");
            String s = sc.nextLine();
            String key = "";

            if (s.equalsIgnoreCase("yes")) {
                System.out.println("Enter the key constraint (e.g., PRIMARY KEY, AUTO_INCREMENT, UNIQUE): ");
                key = sc.nextLine();
            }
            if(i<n)  
            	sql=sql+col+" "+data+" "+key+",\n";
            else
            	sql=sql+col+" "+data+" "+key+");";
        }
        System.out.println("Generated SQL query:");
        stmt.executeUpdate(sql);

        System.out.println("Table created successfully...");
        
        con.close();
		

	}

}
