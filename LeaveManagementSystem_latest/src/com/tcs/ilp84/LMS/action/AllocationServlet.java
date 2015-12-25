package com.tcs.ilp84.LMS.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp84.LMS.bean.AllocationBean;
import com.tcs.ilp84.LMS.service.AllocationService;

/**
 * Servlet implementation class AllocationServlet
 */
public class AllocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllocationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out=response.getWriter();

		String page=request.getParameter("page");

		if(page.equals("login"))
		{
			int loginId=Integer.parseInt(request.getParameter("uname"));
			String password=request.getParameter("pwd");
			if(loginId==123456 && password.equals("sofiacristy"))
			{

				HttpSession session=request.getSession();
				session.setAttribute("megawaresession2","validated");
				AllocationService as=new AllocationService();

				try {
					ArrayList<String> names=as.fetchDetails();
					request.setAttribute("names", names);
					forward("AllocationPage.jsp",request,response);
				} catch (SQLException e) {

					e.printStackTrace();
				}
				
			}
			else 
			{
				request.setAttribute("loginstatus","Username or Password is incorrect");
				forward("AllocationLogin.jsp",request,response);

			}


		}


		if(page.equals("create"))
		{
			String name=request.getParameter("emp");

			AllocationService as=new AllocationService();
			AllocationBean data=null;
			try {
				data = as.getData(name);

				if(data!=null)
				{
					request.setAttribute("data", data);
					forward("AllocationPage.jsp",request,response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		if(page.equals("create2"))
		{

			String name=request.getParameter("emp");
			int id=Integer.parseInt(request.getParameter("id"));
			String dept=request.getParameter("dept");
			String type=request.getParameter("res");
			int days=Integer.parseInt(request.getParameter("days"));
			String comments=request.getParameter("comment");	


			AllocationBean ab=new AllocationBean();
			ab.setName(name);
			ab.setId(id);
			ab.setDept(dept);
			ab.setType(type);
			ab.setDays(days);
			ab.setComments(comments);

			AllocationService as=new AllocationService();

			boolean flag=false;

			//Creating and Updating Days
			try {
				boolean get_name=as.getName(ab);
				boolean request_result=as.userResult(ab);
				if(get_name)
				{
					boolean get_type=as.getType(ab);
					if(get_type)
					{
						boolean update=as.updateDetails(ab);
						if(update)
						{
							flag=true;
						}

					}
					else
					{
						boolean insert=as.addDetails(ab);
						if(insert)
						{
							flag=true;
						}
					}

				}
				else
				{
					boolean insert=as.addDetails(ab);
					if(insert)
					{
						flag=true;
					}
				}

				if(flag)
				{

					String msg="Details added and days updated successfully";
					if(msg!=null)
					{
						request.setAttribute("msg", msg);
						ArrayList<String> names=as.fetchDetails();
						request.setAttribute("names", names);
					}
					forward("AllocationPage.jsp",request,response);
				}
			} 
			catch (SQLException e) {
				out.println("error 1");
				e.printStackTrace();
			}
		}

		if(page.equals("view"))
		{

			int id=Integer.parseInt(request.getParameter("id"));

			AllocationBean ab2=new AllocationBean();

			ab2.setId(id);

			AllocationService as=new AllocationService();

			try {
				boolean result2=as.viewDetails(ab2);
				if(result2)
				{

					request.setAttribute("ab2", ab2);
					forward("ViewDetails.jsp",request,response);

				}

			} catch (SQLException e) {
				out.println("error 2");
				e.printStackTrace();
			}

		}

		if(page.equals("view2"))
		{
			AllocationBean ab=new AllocationBean();
			ab.setId(Integer.parseInt(request.getParameter("id")));

			AllocationService as=new AllocationService();

			try {
				ArrayList<AllocationBean> ab1=as.viewLeaveData(ab);
				request.setAttribute("ab1", ab1);
				forward("ViewDetails2.jsp",request,response);
			} catch (SQLException e) {

				e.printStackTrace();
			}


		}
		if(page.equals("delete"))
		{
			AllocationBean ab=new AllocationBean();
			ab.setId(Integer.parseInt(request.getParameter("id")));

			AllocationService as=new AllocationService();

			try {
				String msg=as.deleteRequest(ab);
				request.setAttribute("msg", msg);
				forward("DeleteDetails.jsp",request,response);
			} catch (SQLException e) {

				e.printStackTrace();
			}


		}
		if(page.equals("update"))
		{

			int id=Integer.parseInt(request.getParameter("id"));
			int days=Integer.parseInt(request.getParameter("days"));

			AllocationBean ab2=new AllocationBean();
			
			ab2.setId(id);

			AllocationService as=new AllocationService();

			try {
				boolean result2=as.updateDetails1(ab2,days);
				if(result2)
				{

					request.setAttribute("ab2", ab2);
					forward("UpdateDetails.jsp",request,response);

				}

			} catch (SQLException e) {
				out.println("error 2");
				e.printStackTrace();
			}

		}

	}



	public void forward(String path,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dis=request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
}


