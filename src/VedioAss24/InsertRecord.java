package VedioAss24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord
{
    static Connection con;
    
    public InsertRecord()
    {
    	con = HospitalDataCon.getDataConnection();
    	System.out.println("Data Base Connected Succefully");
    }
    
    public void fetchRecord()
    {
    	try(Statement st = con.createStatement();
    			ResultSet rs = st.executeQuery("Select * from hospital");){
    	
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
    public void insertData(int id,String name,int age,float weight,String email,String d)	
    {
    	try(PreparedStatement pst = con.prepareStatement
    			("insert into hospital values(?,?,?,?,?,?)");)
    	{
    		pst.setInt(1, id);
    		pst.setString(2, name);
    		pst.setInt(3, age);
    		pst.setFloat(4, weight);
    		pst.setString(5, email);
    		pst.setString(6, d);
    		
         	int r = pst.executeUpdate();
    		System.out.println("Row inserted "+r);
    	}
        catch(SQLException e)
	    {
		  e.printStackTrace();
	    }
    	}
    
    public static void main(String[] args) throws SQLException
	{
    	InsertRecord o = new InsertRecord();
		
		o.insertData(11, "Raja", 66, 74, "raja@gmail.com","2022-05-09");
		o.fetchRecord();
		try {
			o.con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
}
}
