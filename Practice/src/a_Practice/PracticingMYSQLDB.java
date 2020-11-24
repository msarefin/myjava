package a_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class PracticingMYSQLDB {

	private static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/pnt?userTimezone=true&serverTimezone=GMT%2B8";
	private static String user = "msarefin";
	private static String password = "abc123";
	
	static String sql = null; 

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = DriverManager.getConnection(url, user, password); 
		Statement statement = con.createStatement(); 
		sql = "select * from student"; 
		ResultSet rs = statement.executeQuery(sql); 
		
		while(rs.next()) { 
			int id = rs.getInt("id"); 
			String name = rs.getString("student_name"); 
			String dob = rs.getString("date_of_birth"); 
			System.out.println(id+"-->"+name+"-->"+dob);
		}
		con.close();
		
	}
}
