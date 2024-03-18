import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertUpdateDeletePreparedStastemnt 
{

    static Connection con;
	
	public InsertUpdateDeletePreparedStastemnt()
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
    public void insertData(int id,String name,int sal,int depId,int jobid)	
    {
    	try(PreparedStatement pst = con.prepareStatement("insert into employee1 values(?,?,?,?,?)");)
    	{
    		pst.setInt(1, id);
    		pst.setString(2, name);
    		pst.setInt(3, sal);
    		pst.setInt(4, depId);
    		pst.setInt(5, jobid);
    		
    		int r = pst.executeUpdate();
    		System.out.println("Row inserted "+r);
    	}
        catch(SQLException e)
	    {
		  e.printStackTrace();
	    }
    	}
    public void updateDate(int id,String name)
    {
    	try(PreparedStatement pst = con.prepareStatement
    			("update employee1 set empname = ? where empId =?");)
    	{
        pst.setString(1, name);	
        pst.setInt(2, id);
    		
      	int r = pst.executeUpdate();
    	System.out.println("Update Row"+r);
    	}
    	
        catch(SQLException e)
	    {
		  e.printStackTrace();
	    }
   }
   public void deleteData(int id)
   {
	   try(PreparedStatement pst = con.prepareStatement
			   ("delete from employee1 where empId = ?");)
	   {
		   pst.setInt(1,id);
		   int r = pst.executeUpdate();
		   System.out.println("Delete Row"+r);
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
   }
    
    
	public static void main(String[] args) throws SQLException
	{
		InsertUpdateDeletePreparedStastemnt o = new InsertUpdateDeletePreparedStastemnt();
		o.fetchData();
		System.out.println("______________________________________________________");
		o.insertData(1220, "LL", 35000, 555, 5);
		o.updateDate(120, "HK");
		o.deleteData(114);
		
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