package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTheData {

	public static void main(String[] args) throws SQLException {
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDatabase","root","root");
		 
		 Statement stm=con.createStatement();
		 
		 String sql = "UPDATE Students SET marks = 95 WHERE id = 1";
		 
		 int update=stm.executeUpdate(sql);
		 
		
		 con.close();
	
	}

}
