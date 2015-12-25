package com.tcs.ilp84.LMS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tcs.ilp84.LMS.bean.AllocationBean;
import com.tcs.ilp84.LMS.common.DBConnection;

public class AllocationDao {
	public boolean getNames(AllocationBean ab) throws SQLException
	{
		int id=ab.getId();

		Connection con=null;
		Statement stmt=null;
		String get_name=null;
		boolean flag=false;
		String query2="SELECT EMPLOYEE_NAME FROM MEGAWARE_GROUP_E_3 WHERE ID="+id;

		con=DBConnection.getDBconnection();
		System.out.println("connection");


		try
		{
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query2);
			if(rs.next())
			{
				get_name=rs.getString("EMPLOYEE_NAME");
				if(get_name!=null)
				{
					flag=true;
				}
				else
				{
					flag=false;
				}
			}
			return flag;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		finally
		{
			if(con!=null)
			{
				con.close();
			}
			if(stmt!=null)
			{
				stmt.close();
			}
		}

	}

	public boolean getType(AllocationBean ab) throws SQLException
	{
		int id=ab.getId();

		Connection con=null;
		Statement stmt=null;
		String get_type=null;
		boolean flag=false;
		String query2="SELECT * FROM MEGAWARE_GROUP_E_3 WHERE TYPE1='"+ab.getType()+"' AND ID="+id;

		con=DBConnection.getDBconnection();
		System.out.println("connection");


		try
		{
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query2);
			if(rs.next())
			{
				get_type=rs.getString("TYPE1");
				if(get_type!=null)
				{
					flag=true;
				}
				else
				{
					flag=false;
				}
			}
			return flag;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		finally
		{
			if(con!=null)
			{
				con.close();
			}
			if(stmt!=null)
			{
				stmt.close();
			}
		}

	}

	public boolean addDetails(AllocationBean ab) throws SQLException
	{
		String name=ab.getName();
		int id=ab.getId();
		String dept=ab.getDept();
		String type=ab.getType();
		int days=ab.getDays();
		String comments=ab.getComments();

		Connection con=null;
		Statement stmt=null;

		con=DBConnection.getDBconnection();
		System.out.println("connection");

		String query="INSERT INTO MEGAWARE_GROUP_E_3 (EMPLOYEE_NAME,ID,DESIGNATION,TYPE1,DAYS,COMMENTS) VALUES('"+name+"',"+id+",'"+dept+"','"+type+"',"+days+",'"+comments+"')";

		try
		{
			stmt=con.createStatement();

			stmt.executeQuery(query);
			System.out.println("row created");

			return true;

		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		finally
		{
			if(con!=null)
			{
				con.close();
			}
			if(stmt!=null)
			{
				stmt.close();
			}
		}

	}


	public boolean viewDetails(AllocationBean ab) throws SQLException
	{
		Connection con=null;
		Statement stmt=null;

		con=DBConnection.getDBconnection();
		String query="SELECT * FROM MEGAWARE_GROUP_E_3 WHERE ID="+ab.getId()+"";

		try
		{
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);

			while(rs.next())
			{
				ab.setName(rs.getString(1));
				ab.setId(rs.getInt(2));
				ab.setDept(rs.getString(3));
				ab.setType(rs.getString(4));
				ab.setDays(rs.getInt(5));
				ab.setComments(rs.getString(6));

			}
			stmt.executeUpdate("commit");
			System.out.println("row readed");
			return true;
		}
		catch(SQLException e)
		{
			System.out.println("Error in selection");
			System.out.println(e.getMessage());
			return false;
		}
		finally
		{
			if(con!=null)
			{
				con.close();
			}
			if(stmt!=null)
			{
				stmt.close();
			}
		}

	}

	public boolean updateDetails(AllocationBean ab) throws SQLException
	{
		Connection con=null;
		Statement stmt=null;
		int id=ab.getId();
		int applied_days=ab.getDays();
		String query="SELECT DAYS FROM MEGAWARE_GROUP_E_3 WHERE TYPE1='"+ab.getType()+"' AND ID="+id;
		String update_days;
		int prev_days=0,final_days=0;
		
		con=DBConnection.getDBconnection();
		try
		{
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				prev_days=rs.getInt("DAYS");
			}
			final_days=prev_days+applied_days;
			
			update_days="UPDATE MEGAWARE_GROUP_E_3 SET DAYS="+final_days+" WHERE TYPE1='"+ab.getType()+"' AND ID="+id;
			
			int updatedRow=stmt.executeUpdate(update_days);
			System.out.println(updatedRow +"Days updated");
			return true;
		}
		catch(SQLException e)
		{
			System.out.println("error in updating days");
			System.out.println(e.getMessage());
			return false;
		}
		finally
		{
			if(con!=null)
			{
				con.close();
			}
			if(stmt!=null)
			{
				((java.sql.Statement) stmt).close();
			}
		}
	}

	public boolean updateDetails1(AllocationBean ab,int days) throws SQLException
	{
		Connection con=null;
		Statement stmt=null;
		int id=ab.getId();
		String query="SELECT * FROM MEGAWARE_GROUP_E_3 WHERE ID="+id;
		String update_days;
		
		con=DBConnection.getDBconnection();
		try
		{
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				ab.setName(rs.getString(1));
				ab.setId(rs.getInt(2));
				ab.setDept(rs.getString(3));
				ab.setType(rs.getString(4));
				ab.setDays(days);
				ab.setComments(rs.getString(6));

			}
			
			
			update_days="UPDATE MEGAWARE_GROUP_E_3 SET DAYS="+days+" WHERE ID="+id;
			String query1="UPDATE MEGAWARE_GROUP_E_1 SET DAYS_ALLOCATED="+days+"  WHERE EMPLOYEEID="+ab.getId()+" AND STATUS='APPROVED' AND LTYPE='"+ab.getType()+"'" ;
			int update=stmt.executeUpdate(query1);
			
			int updatedRow=stmt.executeUpdate(update_days);
			System.out.println(updatedRow +"Days updated");
			System.out.println(update+"Days updated");
			stmt.executeUpdate("commit");
			return true;
		}
		catch(SQLException e)
		{
			System.out.println("error in updating days");
			System.out.println(e.getMessage());
			return false;
		}
		finally
		{
			if(con!=null)
			{
				con.close();
			}
			if(stmt!=null)
			{
				((java.sql.Statement) stmt).close();
			}
		}
	}


	public String deleteDetails(AllocationBean ab) throws SQLException {
		Connection con=null;
		Statement stmt=null;
		String msg=null;

		con=DBConnection.getDBconnection();
		String query="DELETE MEGAWARE_GROUP_E_3 WHERE ID="+ab.getId();
		String query1="DELETE MEGAWARE_GROUP_E_2 WHERE EMPLOYEEID="+ab.getId();
		String query2="DELETE MEGAWARE_GROUP_E_1 WHERE EMPLOYEEID="+ab.getId();
		try
		{
			stmt=con.createStatement();
			int updatedRow=stmt.executeUpdate(query);
			int updatedRow2=stmt.executeUpdate(query1);
			int updatedRow3=stmt.executeUpdate(query2);
			System.out.println(updatedRow +"rows deleted from allocation");
			System.out.println(updatedRow2 +"rows deleted from approval");
			System.out.println(updatedRow3 +"rows deleted from request");
			msg="Deleted Successfully";
			return msg;
		}
		catch(SQLException e)
		{
			msg="error in deleting dbms";
			System.out.println(e.getMessage());
			return msg;
		}
		finally
		{
			if(con!=null)
			{
				con.close();
			}
			if(stmt!=null)
			{
				stmt.close();
			}
		}

	}


	public ArrayList<String> fetchDetails() throws SQLException {
		Connection con=null;
		Statement stmt=null;
		ArrayList<String> name=new ArrayList<String>();

		con=DBConnection.getDBconnection();
		String query="SELECT FIRSTNAME,LASTNAME FROM MEGAWARE_GROUP_E_2";
		try
		{
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);

			while(rs.next())
			{
				String n1=rs.getString(1);
				String n2=rs.getString(2);
				name.add(n1+" "+n2);
			}

			return name;
		}
		catch(SQLException e)
		{
			System.out.println("error in deleting dbms");
			System.out.println(e.getMessage());
			return null;

		}
		finally
		{
			if(con!=null)
			{
				con.close();
			}
			if(stmt!=null)
			{
				stmt.close();
			}
		}

	}

	public AllocationBean getData(String name) throws SQLException {
		Connection con=null;
		Statement stmt=null;
		AllocationBean ab=new AllocationBean();
		
		int space=name.indexOf(' ');
			
		String first_name=name.substring(0,space);
		String last_name=name.substring(space+1,name.length());
			
		con=DBConnection.getDBconnection();
		String query="SELECT * FROM MEGAWARE_GROUP_E_2 WHERE FIRSTNAME='"+first_name+"' AND LASTNAME='"+last_name+"'";
		try
		{
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery(query);

			rs.last();
			
				ab.setName(rs.getString(1));
				ab.setId(rs.getInt(3));
				ab.setDept(rs.getString(4));
				ab.setType(rs.getString(7));
			
			return ab;
		}
		catch(SQLException e)
		{
			System.out.println("error in deleting dbms");
			System.out.println(e.getMessage());
			return null;

		}
		finally
		{
			if(con!=null)
			{
				con.close();
			}
			if(stmt!=null)
			{
				stmt.close();
			}
		}
		
	}

	public boolean userResult(AllocationBean ab) throws SQLException {
		Connection con=null;
		Statement stmt=null;
		
		con=DBConnection.getDBconnection();
		String query="UPDATE MEGAWARE_GROUP_E_1 SET DAYS_ALLOCATED='"+ab.getDays()+"'  WHERE EMPLOYEEID="+ab.getId()+" AND STATUS='APPROVED' AND LTYPE='"+ab.getType()+"'" ;
		try
		{
			stmt=con.createStatement();
			int updatedRow=stmt.executeUpdate(query);
			if(updatedRow==0)
			{
				String query1="UPDATE MEGAWARE_GROUP_E_1 SET DAYS_ALLOCATED="+0+" WHERE EMPLOYEEID="+ab.getId()+" AND STATUS='REJECTED' AND LTYPE='"+ab.getType()+"'" ;
				int updatedRow2=stmt.executeUpdate(query1);
				System.out.println(updatedRow2+ "updated");
			}
		}
		catch(SQLException e)
		{
			System.out.println("error in deleting dbms");
			System.out.println(e.getMessage());
			

		}
		finally
		{
			if(con!=null)
			{
				con.close();
			}
			if(stmt!=null)
			{
				stmt.close();
			}
		}
		
			
		
		return false;
	}
	public ArrayList<AllocationBean> viewLeaveData(AllocationBean ab) throws SQLException {
		Connection con=null;
		Statement stmt=null;
		
		con=DBConnection.getDBconnection();
		String query="SELECT * FROM MEGAWARE_ALLOCATION_GROUPE_2 WHERE ID="+ab.getId();
		ArrayList<AllocationBean> data=new ArrayList<AllocationBean>();
		
		try
		{
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				AllocationBean ab2=new AllocationBean();
				ab2.setName(rs.getString("EMPLOYEE_NAME"));
				ab2.setId(rs.getInt("ID"));
				ab2.setDept(rs.getString("DESIGNATION"));
				ab2.setType(rs.getString("TYPE1"));
				ab2.setDays(rs.getInt("DAYS"));
				data.add(ab2);
			}
			return data;
			
		}
		catch(SQLException e)
		{
			System.out.println("error in selecting dbms");
			System.out.println(e.getMessage());
			return null;
			
		}
		finally
		{
			if(con!=null)
			{
				con.close();
			}
			if(stmt!=null)
			{
				stmt.close();
			}
		}
	
	}
}



