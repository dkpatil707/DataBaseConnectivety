package JdbcWrtTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData 
{
    static Connection con;
	
	public InsertData()
	{
		con = DbConnection.getDbConnection();
		
		System.out.println("Established Connection to DB");
	}
	
	public void fetchRecord() 
	{
		try(Statement st =con.createStatement();
				ResultSet rs = st.executeQuery("select * from jvoter");)
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
	public void insertdb(int id,String name,int age,int add_Id)	
    {
    	try(PreparedStatement pst = con.prepareStatement("insert into jvoter values(?,?,?,?)");)
    	{
    		pst.setInt(1, id);
    		pst.setString(2, name);
    		pst.setInt(3, age);
    		pst.setInt(4, add_Id);
    	
    		int r = pst.executeUpdate();
    		System.out.println("Row inserted "+r);
    	}
        catch(SQLException e)
	    {
		  e.printStackTrace();
	    }
    	}
	
	public static void main(String args[])
	{
		InsertData obj = new InsertData();
		obj.fetchRecord();
		System.out.println("____________________________________________________________________");
		obj.insertdb(00111, "Shivay", 24, 1002);
		obj.fetchRecord();
		
		try {
			con.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
}
