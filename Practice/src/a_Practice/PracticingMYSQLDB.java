package a_Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.swing.InputMap;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class PracticingMYSQLDB {

	static String driver, url, userName, password;

	public static void main(String[] args) throws Exception {

		InputStream input = new FileInputStream(System.getProperty("user.dir") + "/Files/mysql.properties");
		Properties prop = new Properties();
		prop.load(input);

		driver = prop.getProperty("MYSQLJDBC.Driver");
		url = prop.getProperty("MYSQLJDBC.url");
		userName = prop.getProperty("MYSQLJDBC.userName");
		password = prop.getProperty("MYSQLJDBC.password");

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement stmt = con.createStatement();
		String sqlInsert = "insert into Students(name, age) values(\"Mohammed\", 38)";
		String sqlUpdate = "update Students set age = 21 where id = 3";
		String sqlDelete = "delete from students where id>6";
		String sql = "select * from Students";
		int rowsEffected = stmt.executeUpdate(sqlInsert);
		rowsEffected = stmt.executeUpdate(sqlUpdate);
		rowsEffected = stmt.executeUpdate(sqlDelete);
		System.out.println("Number of rows affected " + rowsEffected);
		ResultSet re = stmt.executeQuery(sql);

		List<ArrayList> result = new ArrayList<ArrayList>();

		while (re.next()) {
			ArrayList rows = new ArrayList();
			rows.add(re.getInt("ID"));
			rows.add(re.getString("name"));
			rows.add(re.getInt("age"));
			result.add(rows);

		}
		input.close();

		for (int i = 0; i < result.size(); i++) {
			System.out.println((result.get(i).toString()));
		}

	}
}