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
import java.util.Properties;

import javax.swing.InputMap;

public class PracticingMYSQLDB {

}

class MySQLAccess {
	private static Connection con = null;
	private static Statement st = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	private static Properties loadProperties() throws IOException { 
		Properties prop = new Properties();
		InputStream ism = new FileInputStream(System.getProperty("user.dir")+"/Files/mysql.properties"); 
		prop.load(ism);
		ism.close();
		return prop; 
		
	}

}