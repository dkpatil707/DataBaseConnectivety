package VedioAss24;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q8Db 
{

	Statement st; 
	ResultSet rs; 
	static Connection con;
	
	public Q8Db()
	{
		con = HospitalDataCon.getDataConnection();
		
		System.out.println("Established Connection to DB");
	}
	public void fetchData() throws SQLException
	{
		st = con.createStatement();
		rs = st.executeQuery("select * from hospital");
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
	public void deleteRecord() throws SQLException
	{
		int r = st.executeUpdate("delete from hospital where pId =" + 5);
		System.out.println("Number of rows deleted : " + r);
	
	}
	public static void main(String[] args) throws SQLException
	{
		Q8Db o = new Q8Db();
		
		o.fetchData();
		System.out.println("______________________________________________________");
		o.deleteRecord();
		System.out.println("______________________________________________________");
		o.fetchData();
	
		con.close();
		
}	
}
