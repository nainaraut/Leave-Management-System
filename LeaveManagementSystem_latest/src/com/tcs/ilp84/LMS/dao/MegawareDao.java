package com.tcs.ilp84.LMS.dao;




import java.sql.ResultSet;
import java.util.ArrayList;
import com.tcs.ilp84.LMS.bean.LmsBean;
import com.tcs.ilp84.LMS.common.DBConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class MegawareDao {

	Connection dbConnection = null;
	Statement statement = null;

	public ArrayList<LmsBean> showLeaveRequest() {
		ResultSet rs = null;
		ArrayList<LmsBean> alhb = new ArrayList<LmsBean>();
		String sql = "SELECT * FROM MEGAWARE_GROUP_E_1 WHERE STATUS='Pending'";
			
		System.out.println(sql);
		try {
			dbConnection = (Connection) DBConnectionManager.getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println("in dao");
			rs = statement.executeQuery(sql);
			System.out.println("after executing ur query");
			if(rs==null)
			{
				
				System.out.println("rs is null  s333333333333");
			}
			if (rs != null) {
				while (rs.next()) {
					System.out.println("how are you sir");
					LmsBean beanObj = new LmsBean();
					beanObj.setFirstname(rs.getString(1));
					beanObj.setLastname(rs.getString(2));
					beanObj.setEmployeeid(rs.getInt(3));
					beanObj.setDesignation(rs.getString(4));
					beanObj.setStartdate(rs.getString(5));
					beanObj.setEnddate(rs.getString(6));
					beanObj.setLeavetype(rs.getString(7));
					beanObj.setReason(rs.getString(8));
					beanObj.setPhonenumber(rs.getString(9));
					System.out.println("hi sir , your name is"+beanObj.getFirstname());
					alhb.add(beanObj);
					// return beanObj;
					// arrObj.add(beanObj);
				}
			}

		}

		catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
					try {
						System.out.println("Finally to chal raha hai");
						statement.execute("COMMIT");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			cleanUp(dbConnection, rs, statement);
		}
		return alhb;
	}

	public ArrayList<LmsBean> showStatusTable()
	{
		ResultSet rs = null;
		ArrayList<LmsBean> alhb = new ArrayList<LmsBean>();
		String sql = "SELECT * FROM MEGAWARE_GROUP_E_2";
			
		System.out.println(sql);
		try {
			dbConnection = (Connection) DBConnectionManager.getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println("in dao");
			rs = statement.executeQuery(sql);
			if (rs != null) {
				while (rs.next()) {
					LmsBean beanObj = new LmsBean();
					beanObj.setFirstname(rs.getString(1));
					beanObj.setLastname(rs.getString(2));
					beanObj.setEmployeeid(rs.getInt(3));
					beanObj.setDesignation(rs.getString(4));
					beanObj.setStartdate(rs.getString(5));
					beanObj.setEnddate(rs.getString(6));
					beanObj.setLeavetype(rs.getString(7));
					beanObj.setReason(rs.getString(8));
					beanObj.setPhonenumber(rs.getString(9));
					beanObj.setLeavestatus(rs.getString(10));
					alhb.add(beanObj);
					// return beanObj;
					// arrObj.add(beanObj);
				}
			}

		}

		catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
					try {
						statement.execute("COMMIT");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			cleanUp(dbConnection, rs, statement);
		}
		return alhb;
		
		
	}
	
	public String login(int username, String password)
	{
		

		String check="wrong";
		ResultSet rs = null;
		

		 boolean b=false;
	  try
	  {
		  dbConnection = (Connection) DBConnectionManager.getDBConnection();
			statement = dbConnection.createStatement();
		
        String sql="SELECT * FROM MEGAWARE_LOGIN_HR_GROUP_E WHERE username ="+username+" AND PASSWORD='"+password+"'";
		
        System.out.println(sql);
       
		 System.out.println("after creating statement");
		 rs=statement.executeQuery(sql);
		
		 //System.out.println("username="+rs.getInt(1));
		 b=rs.next();
		 System.out.println(b+"in dao");
		 if(b==true){
			 check="ok";
		 }
		 System.out.println("after running query");
		
		 
		 
	  }
	  
	  catch(Exception e)
	  {
		System.out.println("problem in searching");  
		System.out.println(e.getMessage());
		  
	  }
	  
	
	 

		finally {
			
			try {
				statement.execute("COMMIT");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			cleanUp(dbConnection, rs, statement);
		}
		return check;
		
		
		
	}
	
	public LmsBean seeDetails(int empid)
	{
		
		ResultSet rs = null;
		//ArrayList<LmsBean> alhb = new ArrayList<LmsBean>();
		String sql = "SELECT * FROM MEGAWARE_GROUP_E_1 where EMPLOYEEID="+empid;
		LmsBean beanObj = new LmsBean();
		System.out.println(sql);
		System.out.println("in see detail dao");
		try {
			dbConnection = (Connection) DBConnectionManager.getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println("in dao");
			rs = statement.executeQuery(sql);
			System.out.println("KOI PROBLEM NAHI HAI");
			
			if (rs != null) {
				while (rs.next()) {
					
					beanObj.setFirstname(rs.getString(1));
					beanObj.setLastname(rs.getString(2));
					beanObj.setEmployeeid(rs.getInt(3));
					beanObj.setDesignation(rs.getString(4));
					beanObj.setStartdate(rs.getString(5));
					beanObj.setEnddate(rs.getString(6));
					beanObj.setLeavetype(rs.getString(7));
					beanObj.setReason(rs.getString(8));
					beanObj.setPhonenumber(rs.getString(9));
					
					//beanObj.setLeavestatus(rs.getString(10));
				
					//alhb.add(beanObj);
					// return beanObj;
					// arrObj.add(beanObj);
				}
			}

		}

		catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
			try {
				statement.execute("COMMIT");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cleanUp(dbConnection, rs, statement);
		}
		return beanObj;
		
		
	}
	
	public LmsBean seeUpdateDetails(int empid)
	{
		
		ResultSet rs = null;
		//ArrayList<LmsBean> alhb = new ArrayList<LmsBean>();
		String sql = "SELECT * FROM MEGAWARE_GROUP_E_2 where EMPLOYEEID="+empid;
		LmsBean beanObj = new LmsBean();
		System.out.println(sql);
		System.out.println("in see detail dao");
		try {
			dbConnection = (Connection) DBConnectionManager.getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println("in dao");
			rs = statement.executeQuery(sql);
			System.out.println("KOI PROBLEM NAHI HAI");
			
			if (rs != null) {
				while (rs.next()) {
					
					beanObj.setFirstname(rs.getString(1));
					beanObj.setLastname(rs.getString(2));
					beanObj.setEmployeeid(rs.getInt(3));
					beanObj.setDesignation(rs.getString(4));
					beanObj.setStartdate(rs.getString(5));
					beanObj.setEnddate(rs.getString(6));
					beanObj.setLeavetype(rs.getString(7));
					beanObj.setReason(rs.getString(8));
					beanObj.setPhonenumber(rs.getString(9));
					beanObj.setLeavestatus(rs.getString(10));
				
					//alhb.add(beanObj);
					// return beanObj;
					// arrObj.add(beanObj);
				}
			}

		}

		catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
			try {
				statement.execute("COMMIT");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cleanUp(dbConnection, rs, statement);
		}
		return beanObj;
		
		
	}
	
	
	public boolean setStatus(int empid,String leavestatus)
	{
		boolean check=false;
		ResultSet rs = null;
		//ArrayList<LmsBean> alhb = new ArrayList<LmsBean>();
		String sql = "SELECT * FROM MEGAWARE_GROUP_E_1 where EMPLOYEEID="+empid;
		LmsBean beanObj = new LmsBean();
		System.out.println(sql);
		try {
			dbConnection = (Connection) DBConnectionManager.getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println("in dao");
			rs = statement.executeQuery(sql);
			
			if (rs != null) {
				while (rs.next()) {
					
					beanObj.setFirstname(rs.getString(1));
					beanObj.setLastname(rs.getString(2));
					beanObj.setEmployeeid(rs.getInt(3));
					beanObj.setDesignation(rs.getString(4));
					beanObj.setStartdate(rs.getString(5));
					beanObj.setEnddate(rs.getString(6));
					beanObj.setLeavetype(rs.getString(7));
					beanObj.setReason(rs.getString(8));
					beanObj.setPhonenumber(rs.getString(9));
					//alhb.add(beanObj);
					// return beanObj;
					// arrObj.add(beanObj);
				}
			}
			//SimpleDateFormat sdf =  new SimpleDateFormat("dd-MM-yyyy");
			 
			
			
			String sql2 = "INSERT INTO MEGAWARE_GROUP_E_2  VALUES ('"+beanObj.getFirstname()+"','"+beanObj.getLastname()+"',"+beanObj.getEmployeeid()+",'"+beanObj.getDesignation()+"',to_date('"+beanObj.getStartdate().substring(0,10)+"','yyyy-mm-dd'),to_date('"+beanObj.getEnddate().substring(0, 10)+"','yyyy-mm-dd'),'"+beanObj.getLeavetype()+"','"+beanObj.getReason()+"',"+beanObj.getPhonenumber()+",'"+leavestatus+"')";
			
			System.out.println(sql2);
			String sql4="UPDATE MEGAWARE_GROUP_E_1 SET STATUS='"+leavestatus+"' WHERE EMPLOYEEID="+beanObj.getEmployeeid();
			//String sql3= "DELETE FROM MEGAWARE_GROUP_E_1 WHERE  EMPLOYEEID="+beanObj.getEmployeeid();
			//System.out.println("sql3");
			System.out.println(sql4);
			statement.execute(sql2);
			//statement.execute(sql3);
			statement.execute(sql4);
			System.out.println("insert ho gaya");
			check=true;
		}

		catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
			
			try {
				statement.execute("COMMIT");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			cleanUp(dbConnection, rs, statement);
		}
		return check;
		
		
	}
	
	
	public boolean setUpdatedStatus(int empid,String leavestatus)
	{
		System.out.println("==================== i am in set Updated status in dao");
		boolean check=false;
		ResultSet rs = null;
		//ArrayList<LmsBean> alhb = new ArrayList<LmsBean>();
		String sql = "SELECT * FROM MEGAWARE_GROUP_E_2 where EMPLOYEEID="+empid;
		LmsBean beanObj = new LmsBean();
		System.out.println(sql);
		try {
			dbConnection = (Connection) DBConnectionManager.getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println("in dao");
			rs = statement.executeQuery(sql);
			
			if (rs != null) {
				while (rs.next()) {
					
					beanObj.setFirstname(rs.getString(1));
					beanObj.setLastname(rs.getString(2));
					beanObj.setEmployeeid(rs.getInt(3));
					beanObj.setDesignation(rs.getString(4));
					beanObj.setStartdate(rs.getString(5));
					beanObj.setEnddate(rs.getString(6));
					beanObj.setLeavetype(rs.getString(7));
					beanObj.setReason(rs.getString(8));
					beanObj.setPhonenumber(rs.getString(9));
					beanObj.setLeavestatus(rs.getString(10));
					//alhb.add(beanObj);
					// return beanObj;
					// arrObj.add(beanObj);
				}
			}
			
			String sql2 = "UPDATE MEGAWARE_GROUP_E_2 SET LEAVESTATUS='"+leavestatus+"' WHERE EMPLOYEEID="+beanObj.getEmployeeid();
			System.out.println(sql2);
			
			String sql4 = "UPDATE MEGAWARE_GROUP_E_1  SET STATUS='"+leavestatus+"' WHERE EMPLOYEEID="+beanObj.getEmployeeid();
			//String sql3= "DELETE FROM MEGAWARE_GROUP_E_1 WHERE  EMPLOYEEID="+beanObj.getEmployeeid();
			//System.out.println("sql3");
			
			statement.execute(sql2);
			statement.execute(sql4);
			//statement.execute(sql3);
			System.out.println("update ho gaya");
			check=true;
		}

		catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
			
			try {
				statement.execute("COMMIT");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			cleanUp(dbConnection, rs, statement);
		}
		return check;
		
	}
	
	public ArrayList<LmsBean> deletStatusRecords(String ids[])
	{
		
		
		
		
		ResultSet rs = null;
		ArrayList<LmsBean> alhb = new ArrayList<LmsBean>();
		String sql = "SELECT * FROM MEGAWARE_GROUP_E_2";
		String sql2;
	//	String sql2 = "DELETE FROM MEGAWARE_GROUP_E_2 WHERE EMPLOYEEID="+;
		System.out.println(sql);
		try {
			dbConnection = (Connection) DBConnectionManager.getDBConnection();
			statement = dbConnection.createStatement();

			for(String str :ids)
			{
				int id = Integer.parseInt(str);
				sql2="DELETE FROM MEGAWARE_GROUP_E_2 WHERE EMPLOYEEID="+id;
				statement.execute(sql2);
				
			}
			
			System.out.println("in dao");
			rs = statement.executeQuery(sql);
			if (rs != null) {
				while (rs.next()) {
					LmsBean beanObj = new LmsBean();
					beanObj.setFirstname(rs.getString(1));
					beanObj.setLastname(rs.getString(2));
					beanObj.setEmployeeid(rs.getInt(3));
					beanObj.setDesignation(rs.getString(4));
					beanObj.setStartdate(rs.getString(5));
					beanObj.setEnddate(rs.getString(6));
					beanObj.setLeavetype(rs.getString(7));
					beanObj.setReason(rs.getString(8));
					beanObj.setPhonenumber(rs.getString(9));
					beanObj.setLeavestatus(rs.getString(10));
					alhb.add(beanObj);
					// return beanObj;
					// arrObj.add(beanObj);
				}
			}

		}

		catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
					try {
						statement.execute("COMMIT");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			cleanUp(dbConnection, rs, statement);
		}
		return alhb;
		
		
	}
	
	public static void cleanUp(Connection conn, ResultSet rs, Statement s) 
	{
		if (conn != null) {
			try {
				rs.close();
				conn.close();
				s.close();
			} catch (SQLException e) {
				System.out.println("Exception occured while clean up:---"
						+ e.getMessage());
			}
		}
	}
	
}
