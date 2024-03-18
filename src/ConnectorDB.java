import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB
{
	public static Connection getConnectionDB()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/triggerexamp","root","1234");
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
		Connection con = ConnectorDB.getConnectionDB();
		
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
