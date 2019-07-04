package writingToDatabase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCStatementInterface {

	private final static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/pnt?useTimezone=true&serverTimezone=GMT%2B8";

	private final static String user = "arefin";
	private final static String password = "abc123";

	public static void main(String[] args) throws SQLException {

		String sql = "select id, name, age from students";

		Connection conn = null;
		Statement stmt = null;

		ResultSet result = null;

		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(url, user, password);

			stmt = conn.createStatement();
			result = stmt.executeQuery(sql); 
			
			while(result.next()) {
				int id  = result.getInt("id");
				String name = result.getString("name");
				int age = result.getInt("age");
				
				System.out.println(id+" "+name+" "+age);

			}
			
			

		} catch (Exception e) {
			System.out.println("JDBC failed");
		}

		finally {
			result.close();
			stmt.close();
			conn.close();
		}

	}

}
