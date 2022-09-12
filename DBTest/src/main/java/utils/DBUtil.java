package utils;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	static Properties pro=new Properties();
	
	static
	{
		
		try {
			InputStream inputStream=ClassLoader.getSystemResourceAsStream("db.properties");
			pro.load(inputStream);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException
	{
				
		String url=pro.getProperty("url");
		String user=pro.getProperty("user");
		String password=pro.getProperty("password");
		
		return DriverManager.getConnection(url,user,password);
		
		
	}
}
