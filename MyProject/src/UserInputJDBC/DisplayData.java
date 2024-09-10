package UserInputJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayData {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		 // Establishing the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbms", "root", "root");

        // Creating a Statement object
		Statement stmt = con.createStatement();

        // SQL query to retrieve data from the Students table
        String sql = "SELECT * FROM Student";

        // Executing the query and getting the result set
        ResultSet rs = stmt.executeQuery(sql);
		
		System.out.println(" id |      name      | age | marks");
		
		while(rs.next())
		{
			System.out.println("-------------------------------------");
			int id = rs.getInt("id");
			String name= rs.getString("name");
			int age = rs.getInt("age");
			int marks = rs.getInt("marks");
			
			int size=15-name.length();
			
			String s="  "+id+" |"+name;
			while(size-- >0)
			{
				s=s+" ";
			}
			
			
			System.out.println(s+" | "+age+"  | "+marks);
				
		}
		
		con.close();
	}

}
