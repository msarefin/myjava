package accessingSQLDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPreparedStatement {

	private static final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/pnt";
	private static final String user = "arefin";
	private static final String password = "abc123";

	static String sql = "Select id, name, age from students where age > ?";
	static String sql1 = "insert into students (id, name, age) values(?,?,?)";
	
	 

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setInt(1, 25);
		
		ResultSet rs = pst.executeQuery(); 
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			System.out.println(id+" "+name+" "+age);
			
		}
		
		
	}
}
