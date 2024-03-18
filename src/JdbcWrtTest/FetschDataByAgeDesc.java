package JdbcWrtTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetschDataByAgeDesc
{
    static Connection con;
	
	public FetschDataByAgeDesc()
	{
		con = DbConnection.getDbConnection();
		
		System.out.println("Established Connection to DB");
	}
	
	public void fetchRecord() 
	{
		try(Statement st =con.createStatement();
				ResultSet rs = st.executeQuery("select * from jvoter order by age desc");)
		{
		System.out.println("Voter_id"+"\t"+"Voter_Name"+"\t"+"age"+"\t"+"address_Id");
		while(rs.next())
		{
			int id = rs.getInt("Voter_id");
			String n = rs.getString(2);
			int a = rs.getInt(3);
			int d = rs.getInt(4);
			
			
			System.out.println(id+"\t\t"+n+"\t\t"+a+"\t"+d); 
		}
	}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	
	}
	public static void main(String args[])
	{
		FetschDataByAgeDesc obj = new FetschDataByAgeDesc();
		obj.fetchRecord();
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
}
}
