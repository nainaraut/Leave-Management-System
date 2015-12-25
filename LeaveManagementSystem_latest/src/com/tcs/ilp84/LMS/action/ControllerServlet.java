package com.tcs.ilp84.LMS.action;

// OM NAMAH SHIVAI
//JAI MATA DI

import java.io.IOException;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp84.LMS.bean.LmsBean;
import com.tcs.ilp84.LMS.dao.DBHelper;
import com.tcs.ilp84.LMS.service.AllocationService;





public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String page=request.getParameter("page");
		
		if(page.equals("login"))
		{
			int loginId=Integer.parseInt(request.getParameter("uname"));
			String password=request.getParameter("pwd");
			if(loginId==123456 && password.equals("sofia"))
			{
				AllocationService as=new AllocationService();

				forward("AllocationPage.jsp",request,response);
			
			}
		}


		if(page.equals("create")){
			System.out.println("STEP 1:getting the values from JSP to ControllerServlet");

			String first=request.getParameter("first");
			String last=request.getParameter("last");
			int empid=Integer.parseInt(request.getParameter("empid"));
			String designation=request.getParameter("designation");
			String start=request.getParameter("start");
			String end=request.getParameter("end");
			String type=request.getParameter("type");
			String reason=request.getParameter("reason");
			String phonenumber=request.getParameter("phonenumber");
			String status="Pending";
			int days_allocated=0;

			LmsBean lBean=new LmsBean(); 

			System.out.println("STEP 2:setting the values to Bean class using setters");

			lBean.setFirstname(first);
			lBean.setLastname(last);
			lBean.setEmployeeid(empid);
			lBean.setDesignation(designation);
			lBean.setStartdate(start);
			lBean.setEnddate(end);
			lBean.setLeavetype(type);
			lBean.setReason(reason);
			lBean.setPhonenumber(phonenumber);
			lBean.setStatus(status);
			lBean.setDays_allocated(days_allocated);

			//save the details in DB

			System.out.println("STEP 3.1:calling the method from DBHelper to the ControllerServlet");
			String msg = DBHelper.addEmployeeDetails(lBean);

			System.out.println("STEP 4.1:getting message from  method");		
			//response to the request
			request.setAttribute("msg",msg);

			System.out.println("STEP 4.2:Forwarding the message to JSP");
			forward("LeaveRequest.jsp",request,response);
			System.out.println("EXIT");
		}
		if(page.equals("view")){
			System.out.println("in view servlet");
			int id=Integer.parseInt(request.getParameter("empid"));

			System.out.println("callling method");
			LmsBean lBean= DBHelper.viewLeaveRequest(id);

			
			Date d=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat();
			sdf.format(d);
			

			String msg="Your Leave Request are as Shown Below";

			request.setAttribute("msg",msg);
			request.setAttribute("lBean", lBean);
			System.out.println("forwarding");
			forward("RequestView.jsp",request,response);
			System.out.println("forwarding 2");
		}
		if(page.equals("update")){
			int  id =Integer.parseInt(request.getParameter("empid"));
			String designation =request.getParameter("designation");
			String startdate =request.getParameter("start");
			String enddate=request.getParameter("end");
			String leavetype =request.getParameter("type");
			String Reason =request.getParameter("reason");
			String phonenumber =request.getParameter("phonenumber");

			LmsBean lBean = new LmsBean();

			lBean.setEmployeeid(id);
			lBean.setDesignation(designation);
			lBean.setStartdate(startdate);
			lBean.setEnddate(enddate);
			lBean.setLeavetype(leavetype);
			lBean.setReason(Reason);
			lBean.setPhonenumber(phonenumber);

			System.out.println(id);
			System.out.println(designation);
			System.out.println(startdate);		
			System.out.println(enddate);
			System.out.println(leavetype);
			System.out.println(Reason);
			System.out.println(phonenumber);

			String msg=DBHelper.updateLeaveRequest(lBean);
			request.setAttribute("msg",msg);
			forward("RequestUpdate.jsp",request,response);
		}
		if(page.equals("cancel")){
			int id=Integer.parseInt(request.getParameter("empid"));
			System.out.println("before method");
			boolean flag = DBHelper.cancelLeaveRequest(id);
			System.out.println("after method");
			String msg="Leave request cancelled successfully";
			if(flag)
			{
				request.setAttribute("msg",msg);
				forward("RequestCancel.jsp",request,response);
			}
			else
			{
				System.out.println("Leave Request Not Deleted");
			}	
		}
	}
	public  void forward(String path,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}


