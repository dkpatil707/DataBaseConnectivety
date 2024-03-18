import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchDetailsInTable
{

	static Connection con;
	
	public FetchDetailsInTable()
	{
		con = DataConnector.getDBConnection();
		
		System.out.println("Established Connection to DB");
	}
	public void fetchData() 
	{
		try(Statement st =con.createStatement();
				ResultSet rs = st.executeQuery("select * from employee1");)
		{
		System.out.println("empId"+"\t"+"Emp Name"+"\t"+"Salary"+"\t" + "DepId"+"\t"+"JobId");
		while(rs.next())
		{
			int id = rs.getInt("empId");
			String n = rs.getString(2);
			int s = rs.getInt(3);
			int d = rs.getInt(4);
			int j = rs.getInt(5);
			
			System.out.println(id+"\t"+n+"\t\t"+s+"\t"+d+"\t"+j); }
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	
		}
	public static void main(String[] args) throws SQLException
	{
		FetchDetailsInTable o = new FetchDetailsInTable();
		
		o.fetchData();
		try {
			o.con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
}
}

