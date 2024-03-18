package VedioAss24;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDB1 
{
   static Connection con;
    Statement st;
    ResultSet rs;
    
    public UpdateDB1()
    {
    	con = HospitalDataCon.getDataConnection();
    	System.out.println("Data Base Connected Succefully");
    }
    
    public void fetchRecord() throws SQLException
    {
        st = con.createStatement();
        rs = st.executeQuery("Select * from hospital");
    	
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
 	   int r = st.executeUpdate("update hospital set email ='naikVk@gmail.com' "
 	   		+ "where pname = 'V.K.Naik'");
 	   System.out.println("Number of rows updated : " + r);
    }
    
    public static void main (String [] args) throws SQLException
    {
 	   UpdateDB1 o = new UpdateDB1();
 	   o.fetchRecord();
 	   
 	   System.out.println("______________________________________________________");
 	   o.updateRecord();
 	   
 	   con.close();
 	   
    }
}
