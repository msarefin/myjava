package accessingSQLDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatement {

	private static final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/pnt";
	private static final String user = "arefin";
	private static final String password = "abc123";

	static String sql = null;

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		sql = "select id, name , age from students";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");

			System.out.println(id + " " + " " + name + " " + age);
		}

		sql = "insert into students (id, name, age) values(7,'Katalina','27')";

		stmt.executeUpdate(sql);

		sql = "delete from students where id = 5";
		stmt.executeUpdate(sql);

		sql = "update students set name = 'Kaniska' where id = 3";

		stmt.executeUpdate(sql);
		sql = "select id, name , age from students";
		rs = stmt.executeQuery(sql);

		System.out.println("After Insert update and Delete");

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			System.out.println(id + " " + name + " " + age);
		}

		rs.close();
		stmt.close();
		con.close();
	}

}
