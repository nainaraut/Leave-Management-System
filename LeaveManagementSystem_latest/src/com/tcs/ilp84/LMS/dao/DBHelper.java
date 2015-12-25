package com.tcs.ilp84.LMS.dao;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.tcs.ilp84.LMS.bean.LmsBean;



public class DBHelper {
	public static Connection getConnection() throws SQLException{
		Connection conn=null;
		//step1 load Driver
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			//step2 create connection
			String url="jdbc:oracle:thin:@192.168.129.12:1521:orcl";
			conn=DriverManager.getConnection(url,"a84core","a84core");
		}catch(ClassNotFoundException e){
			System.out.println("class not found error"+e.getMessage());
		}
		return conn;
	}
	public static String addEmployeeDetails(LmsBean lBean){
		String msg="";
		Connection conn = null;

		System.out.println("step 5");
		try {
			//step 1 & 2
			conn = getConnection();
			//3. Create statement

			System.out.println("step 6");

			Statement stmt = conn.createStatement();
			System.out.println("step 6.1"); 
			//4. Execute statement

			String sql="INSERT INTO MEGAWARE_GROUP_E_1 (firstname,lastname,employeeid,designation,sdate,edate,ltype,reason,phone,status,days_allocated) VALUES ('"+lBean.getFirstname()+"','"+lBean.getLastname()+"',"+lBean.getEmployeeid()+",'"+lBean.getDesignation()+"',to_date('"+lBean.getStartdate()+"','dd-mm-yyyy'),to_date('"+lBean.getEnddate()+"','dd-mm-yyyy'),'"+lBean.getLeavetype()+"','"+lBean.getReason()+"',"+lBean.getPhonenumber()+",'"+lBean.getStatus()+"',"+lBean.getDays_allocated()+")";
			stmt.execute(sql);

			System.out.println(sql); 

			msg="Record added succesfully";
		} catch (SQLException e) {
			msg = "Exception occureddffdgd-------"+e.getMessage();
			System.out.println(msg);
		}finally{
			//5. MUST:  close the connection
			cleanUp(conn);			
		}
		return msg;
	}
	
	public static boolean cancelLeaveRequest(int employeeid){
		boolean flag=true;
		String msg="";
		Connection conn=null;
		try
		{
			conn=getConnection();
			Statement stmt=conn.createStatement();
			String sql="DELETE FROM MEGAWARE_GROUP_E_1 WHERE STATUS='PENDING' employeeid="+employeeid;
			stmt.execute(sql);
			msg="Leave request cancelled successfully";
			
		}
		catch(Exception e)
		{
			System.out.println("error in deleting leave request");
			flag=false;
		}

		finally
		{
			cleanUp(conn);
		}

		return flag;
	}
	
	public static String updateLeaveRequest(LmsBean lBean){
	//	boolean flag=true;
		String msg="";
		Connection conn=null;
		try
		{
			conn=getConnection();
			Statement stmt=conn.createStatement();
			System.out.println("before query");
			String sql="UPDATE MEGAWARE_GROUP_E_1 SET employeeid="+lBean.getEmployeeid()+",designation='"+lBean.getDesignation()+"',sdate=to_date('"+lBean.getStartdate()+"','dd-mm-yyyy'),edate=to_date('"+lBean.getEnddate()+"','dd-mm-yyyy'),ltype='"+lBean.getLeavetype()+"', reason='"+lBean.getReason()+"',phone="+lBean.getPhonenumber()+" WHERE employeeid="+lBean.getEmployeeid();
			System.out.println("after query");
			System.out.println(sql);
			msg="Record updated succesfully";
			System.out.println("2");
			stmt.executeUpdate(sql);
		}
		
		catch(Exception e)
		{ 
			e.printStackTrace();
			System.out.println("error in updating leave request");
			
		}

		finally
		{
			cleanUp(conn);
		}

		return msg;
	}
	public static LmsBean viewLeaveRequest(int id){
		Connection conn=null;
		LmsBean lBean=new LmsBean();
		try {
			//1 2 steps
			System.out.println("Before Conn");
			conn = getConnection();
			System.out.println("After Conn");
			//3. Create statement

			Statement stmt = conn.createStatement();
			System.out.println("After stmt");
			//4. Execute
			String sql = "SELECT * FROM MEGAWARE_GROUP_E_1 WHERE employeeid=" + id ;
			System.out.println("After Query");
			
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("After result");
			
			//5. Read the result-set
			if(rs.next()){
				System.out.println("before  resulset");
				lBean.setFirstname(rs.getString("firstname"));
				lBean.setLastname(rs.getString("lastname"));
				lBean.setDesignation(rs.getString("designation"));
				
				Date d=new Date();
				d=rs.getDate("sdate");
				SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
				lBean.setStartdate(sdf.format(d));
				
				Date d1=new Date();
				d1=rs.getDate("edate");
				lBean.setEnddate(sdf.format(d1));
				
				lBean.setLeavetype(rs.getString("ltype"));
				lBean.setReason(rs.getString("reason"));
				lBean.setPhonenumber(rs.getString("Phone"));
				lBean.setStatus(rs.getString("status"));
				lBean.setDays_allocated(rs.getInt("days_allocated"));
				System.out.println("after resulset");
			}
			
			else
			{
				String msg="employee id not found";
			}
			System.out.println("After result2");
		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			//6. MUST:  close the connection
			cleanUp(conn);			
		}
		return lBean;
	}

	public static void cleanUp(Connection conn){
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e){
				System.out.println("Exception occured while exit"+e.getMessage());
			}
		}
	}
	
}


