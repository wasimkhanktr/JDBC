package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//import java.sql.Connection;

public class JdbcConnection
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//step 1 register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step 2 Establish the connection 
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		
		System.out.println("Connection created");
	}
}
