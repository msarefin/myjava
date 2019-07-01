package writingToDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCPreparedStatementInterface {

	private final static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/pnt";

	private final static String user = "arefin";
	private final static String password = "abc123";

	public static void main(String[] args) {
		String sql = "select id, name,age  from students where id > ?";

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(url, user, password);
			pst = conn.prepareStatement(sql);
			pst.setInt(1, 2);

			rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");

				System.out.println(id + " " + name + " " + age);

			}

		} catch (Exception e) {
			System.out.println("JDBC Failed");
		}

	}

}
