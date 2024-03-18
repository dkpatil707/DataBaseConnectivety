/*5. Delete all records from patient table for giben patient id. Use 
PreparedStatement for the same*/

package VedioAss24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRecordPd
{
    static Connection con;
	
	public DeleteRecordPd()
	{
		con = HospitalDataCon.getDataConnection();
		
		System.out.println("Established Connection to DB");
	}
	
	 public void deleteData(int id)
	 {
		   try(PreparedStatement pst = con.prepareStatement
				   ("delete from hospital where pId = ?");)
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
	 
	 public static void main(String []args)
	 {
		 DeleteRecordPd o = new DeleteRecordPd();
		 o.deleteData(3);
		 try {
			con.close();
		} 
		 catch (SQLException e)
		 {
			
			e.printStackTrace();
		}
	 }
	 
}
