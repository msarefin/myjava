package a_Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;

import javax.swing.InputMap;

import com.mysql.cj.PerConnectionLRUFactory;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.SqlUpdateResult;

public class PracticingMYSQLDB {

	static String driver, url, userName, password;
	static String propreiesFile = System.getProperty("user.dir") + "/Files/mysql.properties";

	public static void main(String[] args) throws Exception {

//		SQLInsertStatement("insert into students (name, age) values(\"Hanip\", 44)");
//		SQLUpdateStatement("update students set age = 30 where name = \"hanip\"");
//		SQLDeleteStatement(
//				"delete from students where id in (select id from (select id, row_number() over(partition by name) as 'row' from students) as t where t.row>1)");
//		SQLReadStatement("select * from students");
//		SQLReadPreparedStatement(4);
//		SQLInsertPreparedStatement("Alexander", 22);
		SQLCallableStatement_StudentCountByCountry("Bangladesh");
		
	}

	static void setCredentials(String propreiesFile) throws IOException {
		InputStream inStream = new FileInputStream(propreiesFile);
		Properties prop = new Properties();
		prop.load(inStream);

		driver = prop.getProperty("MYSQLJDBC.Driver");
		url = prop.getProperty("MYSQLJDBC.url");
		userName = prop.getProperty("MYSQLJDBC.userName");
		password = prop.getProperty("MYSQLJDBC.password");

		prop.clear();
		inStream.close();

	}

	static Connection registerAndGetConnection(String driver, String url, String userName, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, userName, password);
		return connection;
	}

//	---------------------------------------------------SQL Callable Statement---------------------------------------------------

	static void SQLCallableStatement_StudentCountByCountry(String Country) throws IOException, ClassNotFoundException, SQLException {
		InputStream inStream = new FileInputStream(System.getProperty("user.dir") + "/Files/mysql.properties");
		Properties prop = new Properties();
		prop.load(inStream);

		driver = prop.getProperty("MYSQLJDBC.Driver");
		url = prop.getProperty("MYSQLJDBC.url");
		userName = prop.getProperty("MYSQLJDBC.userName");
		password = prop.getProperty("MYSQLJDBC.password");

		prop.clear();
		inStream.close();
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, userName, password); 
		String sp_StudentByCountry = "{ call sp_StudentByCountry(?,?)}";
		CallableStatement callstmt = con.prepareCall(sp_StudentByCountry); 
		
		callstmt.setString(1, Country);
		callstmt.registerOutParameter(2,java.sql.Types.BIT);
		callstmt.execute(); 
		int counter = callstmt.getInt(2); 
		System.out.println("There are "+counter+" students from "+Country);
		
		
	}

//	---------------------------------------------------SQL Prepared Statement---------------------------------------------------

	static void SQLInsertPreparedStatement(String name, int age)
			throws IOException, SQLException, ClassNotFoundException {
		InputStream inStream = new FileInputStream(System.getProperty("user.dir") + "/Files/mysql.properties");
		Properties prop = new Properties();
		prop.load(inStream);

		driver = prop.getProperty("MYSQLJDBC.Driver");
		url = prop.getProperty("MYSQLJDBC.url");
		userName = prop.getProperty("MYSQLJDBC.userName");
		password = prop.getProperty("MYSQLJDBC.password");

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, userName, password);
		PreparedStatement prep = con.prepareStatement("insert into students (name, age) values(?,?)");

		prep.setString(1, name);
		prep.setInt(2, age);

		prep.execute();

		SQLReadStatement("select * from students;");

		prep.close();
		con.close();
	}

	static void SQLReadPreparedStatement(int id) throws Exception {
		InputStream inStream = new FileInputStream(System.getProperty("user.dir") + "/Files/mysql.properties");
		Properties prop = new Properties();
		prop.load(inStream);

		driver = prop.getProperty("MYSQLJDBC.Driver");
		url = prop.getProperty("MYSQLJDBC.url");
		userName = prop.getProperty("MYSQLJDBC.userName");
		password = prop.getProperty("MYSQLJDBC.password");

		prop.clear();
		inStream.close();

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, userName, password);
		PreparedStatement prepstmt = con.prepareStatement("select * from students where id = ?");

		prepstmt.setInt(1, id);

		ResultSet rs = prepstmt.executeQuery();

		List<ArrayList> data = new ArrayList<ArrayList>();
		while (rs.next()) {
			ArrayList row = new ArrayList();
			row.add(rs.getInt("id"));
			row.add(rs.getString("name"));
			row.add(rs.getInt("age"));
			data.add(row);
		}

		rs.close();
		prepstmt.close();
		con.close();

		for (int i = 0; i < data.size(); i++) {
			System.out.println((data.get(i).toString()));
		}
	}

//	---------------------------------------------------SQL Statement---------------------------------------------------

	static void SQLDeleteStatement(String sqlDeleteStatement) throws IOException, ClassNotFoundException, SQLException {
		setCredentials(propreiesFile);
		Connection con = registerAndGetConnection(driver, url, userName, password);
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sqlDeleteStatement);
	}

	static void SQLUpdateStatement(String sqlUpdateStatement) throws IOException, ClassNotFoundException, SQLException {
		setCredentials(propreiesFile);
		Connection con = registerAndGetConnection(driver, url, userName, password);
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sqlUpdateStatement);
	}

	static void SQLInsertStatement(String sqlInsertStatement) throws IOException, ClassNotFoundException, SQLException {
		setCredentials(propreiesFile);
		Connection con = registerAndGetConnection(driver, url, userName, password);
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sqlInsertStatement);

		stmt.close();
		con.close();

	}

	static void SQLReadStatement(String sqlStatement) throws IOException, ClassNotFoundException, SQLException {
		setCredentials(propreiesFile);

		Connection con = registerAndGetConnection(driver, url, userName, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlStatement);

		List<ArrayList> tableDate = new ArrayList<ArrayList>();
		while (rs.next()) {
			ArrayList rows = new ArrayList();
			rows.add(rs.getInt("id"));
			rows.add(rs.getString("name"));
			rows.add(rs.getInt("age"));
			tableDate.add(rows);
		}

		rs.close();
		stmt.close();
		con.close();

		Iterator it = tableDate.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
}