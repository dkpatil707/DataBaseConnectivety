package VedioAss24;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q10UpdateWeigth
{
	Statement st; 
	ResultSet rs; 
	static Connection con;
	
	public Q10UpdateWeigth()
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
	public void updateRecord() throws SQLException
	{
		int r = st.executeUpdate("update hospital set  = 50.50 where pId ="+ 4);
		System.out.println("Number of rows updated : " + r);
	}
	public static void main(String[] args) throws SQLException
	{
		Q10UpdateWeigth o = new Q10UpdateWeigth();
		
		o.fetchData();
		System.out.println("______________________________________________________");
		System.out.println("______________________________________________________");
		o.updateRecord();
		System.out.println("______________________________________________________");
		o.fetchData();
		
		con.close();
		
}
}