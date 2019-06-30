package writingToDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WritingFilesToMYSQL {

	public static void main(String[] args) throws SQLException {
	
		
	String url = "jdbc:mysql//localhost:3306/PNT";
	String user = "arefin";
	String pass = "abc123";
	
	Connection myConn = DriverManager.getConnection(url, user, pass); 
	
	Statement myStmt = myConn.createStatement(); 
	
	String sqlStatement = "insert into student (id, name, age) values (1,'Danny',24)";
	
	
		
	
	}
}
