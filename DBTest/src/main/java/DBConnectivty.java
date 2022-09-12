import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.PreparedStatement;



public class DBConnectivty {
	
	
	
	
	public static Connection getConnection() throws SQLException
	{
		
		InputStream inputStream=ClassLoader.getSystemResourceAsStream("db.properties");
		Properties pro=new Properties();
		try
		{
		pro.load(inputStream);
		
		String url=pro.getProperty("url");
		String user=pro.getProperty("user");
		String password=pro.getProperty("password");
		
		Connection connection = DriverManager.getConnection(url,user,password);
		return connection;
		
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	

	public static void main(String[] args) {
		
		
		//updateTest();
		
		deleteTest();
		
		// selectTest();
		
		

	}
	
	
	private static void selectTest() {

		try (Connection connection=getConnection();

				Statement statement = connection.createStatement();

				ResultSet resultSet = statement
						.executeQuery("SELECT customerNumber, contactFirstName, contactLastName FROM customers");) {

			while (resultSet.next()) {

				Integer custNo = resultSet.getInt("customerNumber");
				String custName = resultSet.getString("contactFirstName");
				String contactLastName = resultSet.getString("contactLastName");

				System.out.println(custNo + "\t" + custName + "\t" + contactLastName);

			}

			connection.close();
			statement.close();
			resultSet.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	
	private static void updateTest()
	{
		String sql="UPDATE customers SET contactFirstName=? ,contactLastName=? WHERE customerNumber=?";
		try (Connection connection = getConnection();

				PreparedStatement statement=(PreparedStatement) connection.prepareStatement(sql);
			) {
			
			
			statement.setString(1, "Akash");
			statement.setString(2, "Kalyankar");
			statement.setInt(3,103);
			Integer count= statement.executeUpdate();

			
				System.out.println("record updated="+count);

			

		} catch (SQLException e) {

			e.printStackTrace();
		}

		
	}

	private static void deleteTest()
	{
		String sql="DELETE FROM customers where customerNumber=?";
		try (Connection connection = getConnection();

				PreparedStatement statement=(PreparedStatement) connection.prepareStatement(sql);
			) {
			
			
			
			statement.setInt(1,103);
			Integer count= statement.executeUpdate();

			
				System.out.println("record deleted="+count);

			

		} catch (SQLException e) {

			e.printStackTrace();
		}

		
	}

	
		
}
