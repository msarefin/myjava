package writingToDatabase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WritingFilesToMYSQL {

	public static void main(String[] args) throws SQLException {
		String jdbc = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/pnt";
		String user = "arefin";
		String password = "abc123";

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pst = null;
		CallableStatement cas = null;

		String sql = null;

		ResultSet rs = null;

		try {

			Class.forName(jdbc);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();

			sql = "select id, name, age from students";

			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String  name= rs.getString("name");
				int age = rs.getInt("age");
				
				System.out.println(id+" "+name+" "+age);
			}
			

		} catch (Exception e) {
			System.out.println("JDBC Failed");
		}

		finally {
			rs.close();
			stmt.close();
			conn.close();
		}
	}
}
