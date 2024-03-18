import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnector 
{
	
	
	public static Connection getDBConnection()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","1234");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return con;
		
	}

	public static void main(String[] args)
	{
		Connection con = DataConnector.getDBConnection();
		
		if(con != null)
		{
			System.out.println("Database Connected Succesfully");
		}
		else
		{
			System.out.println("Database Not Connected");
		}

	}

}
