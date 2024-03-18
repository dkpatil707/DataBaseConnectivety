
//2. List All Patient details with age above 50


package VedioAss24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchData 
{

	static Connection con;
	
	public FetchData()
	{
		con = HospitalDataCon.getDataConnection();
		System.out.println("Data Base Connected Succefully");
	}
	
	public void fetchRecord()
	{
		try(PreparedStatement pst = con.prepareStatement
				("select * from hospital where age >= ?");)
		{
			pst.setInt(1, 50);
			ResultSet rs = pst.executeQuery();
			
			System.out.println("pId"+"\t"+"pname"+"\t\t"+"age"+"\t"+"weigth"+"\t"+"email"+"\t\t"+"administartion");
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String n = rs.getString(2);
				int a = rs.getInt(3);
				float w = rs.getFloat(4);
				String e = rs.getString(5);
				String d = rs.getString(6);
				
				System.out.println(id+"\t"+n+"\t"+a+"\t"+w+"\t"+e+"\t"+d);
			}
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args)
	{
		FetchData f = new FetchData();
		f.fetchRecord();
		try {
			f.con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
