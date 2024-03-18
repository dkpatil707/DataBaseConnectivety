import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

 
    public class AccessDatabase 
    {

		Statement st; 
		ResultSet rs; 
		static Connection con;
		
		public AccessDatabase()
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
		public void insertRecord() throws SQLException
		{
			int r = st.executeUpdate("insert into employee1 values(140,'HHH',25000,1111,5)");
		
			
		System.out.println("Number of rows inserted : " + r);
				
		}
		public void deleteRecord() throws SQLException
		{
			int r = st.executeUpdate("delete from employee1 where empid =" + 120);
			System.out.println("Number of rows deleted : " + r);
		
		}
		
		public void updateRecord() throws SQLException
		{
			int r = st.executeUpdate("update employee1 set salary = 50000 where empId ="+ 118);
			System.out.println("Number of rows updated : " + r);
		}
		
		public static void main(String[] args) throws SQLException
		{
			AccessDatabase o = new AccessDatabase();
			
			o.fetchData();
			
			System.out.println("______________________________________________________");
		    o.insertRecord();
		    
			System.out.println("______________________________________________________");
			o.deleteRecord();
			
			System.out.println("______________________________________________________");
			o.updateRecord();
			
			System.out.println("______________________________________________________");
			o.fetchData();
		
			con.close();
			

		}

	}

