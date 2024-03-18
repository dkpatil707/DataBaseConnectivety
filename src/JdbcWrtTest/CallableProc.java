package JdbcWrtTest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CallableProc
{
	static Connection con;
	static CallableStatement cst;
	ResultSet rs;
	public CallableProc() 
	{
		con = DbConnection.getDbConnection();
		System.out.println("Connected to DataBase");
	}
	
	
	public void callProcedure(int Booth_id) throws SQLException
	{
		cst = con.prepareCall("{ call getTotalVoters(?,?) }");
		
		cst.setInt(1,Booth_id);
		
		cst.registerOutParameter(2,Types.INTEGER);
		
		boolean status = cst.execute();
		int voterCnt=0;
		if(status != true)
		{
		 voterCnt = cst.getInt(2);
		}
		System.out.println("Status is : " + status);
	    System.out.println("Total Num of Voter :"+voterCnt);
			
	} 
		
		
		public static void main(String []args)
		{
			CallableProc o = new CallableProc();
			try {
				o.callProcedure(101);
			} 
			catch (SQLException e1)
			{
				
				e1.printStackTrace();
			}
			
			try {
				con.close();
			} 
			catch (SQLException e)
			{
				
				e.printStackTrace();
			}
		}
}
