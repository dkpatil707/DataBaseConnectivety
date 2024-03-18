import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class UpdateDB 
{
       Statement st;
       ResultSet rs;
       static Connection con;
       
       public UpdateDB()
       {
    	   con = DataConnector.getDBConnection();
    	   
    	   System.out.println("Established Connection to DB");
       }
       
       public void fetchData() throws SQLException
       {
    	   st = con.createStatement();
    	   rs = st.executeQuery("select * from employee1");
    	   System.out.println("empId"+"\t"+"Emp Name"+"\t"+"Salary"+"\t" + "DepId"+"\t"+"JobId");
    	   
    	   while(rs.next())
    	   {
    		   int id = rs.getInt("empId");
    		   String n = rs.getString(2);
    		   int s = rs.getInt(3);
    		   int d = rs.getInt(4);
			   int j = rs.getInt(5);
			   
			   System.out.println(id+"\t"+n+"\t\t"+s+"\t"+d+"\t"+j);
    	   }
       }
       
       public void updateRecord() throws SQLException
       {
    	   int r = st.executeUpdate("update employee1 set empname = 'Khushu' where empId ="+117);
    	   System.out.println("Number of rows updated : " + r);
       }
       
       public static void main (String [] args) throws SQLException
       {
    	   UpdateDB o = new UpdateDB();
    	   o.fetchData();
    	   
    	   System.out.println("______________________________________________________");
    	   o.updateRecord();
    	   
    	   con.close();
    	   
       }
       
}
