package com.tcs.ilp84.LMS.action;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp84.LMS.bean.LmsBean;
import com.tcs.ilp84.LMS.dao.MegawareDao;

/**
 * Servlet implementation class MegawareServlet
 */
public class MegawareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MegawareServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String xcode=request.getParameter("xcode");
		//String xcode2="a";
		 //xcode2=request.getParameter("xyz");
			
		System.out.println("in post");
		System.out.println("xcode="+xcode);
		if(xcode.equals("login"))
		{
			MegawareDao md=new MegawareDao();
			int username=Integer.parseInt(request.getParameter("username"));
			String password=request.getParameter("password");
			System.out.println("username="+username+"password="+password);
			String check=md.login( username,password);
			System.out.println("check value of login="+check);
			if(check.equals("ok"))
			{
				HttpSession session=request.getSession();
				session.setAttribute("megawaresession","validated");
				
				forward("Home.jsp", request, response);
			}
			else if(check.equals("wrong"))
			{
				request.setAttribute("loginstatus","Username or Password is incorrect");
				forward("login.jsp",request,response);
				
			}
			
			
		}
		if(xcode.equals("create"))
		{
			MegawareDao md=new MegawareDao();
			ArrayList<LmsBean> alhb =md.showLeaveRequest();
			request.setAttribute("data", alhb);
			request.setAttribute("status", "from servlet");
			forward("setstatus.jsp", request, response);
			System.out.println("in servlet with bean size="+alhb.size());
			
		}
		if(xcode.equals("seedetail"))
		{
			System.out.println("in servlet see detail part");
			
			int empid=Integer.parseInt(request.getParameter("empid"));
			MegawareDao md=new MegawareDao();
			LmsBean lb=md.seeDetails(empid);
			request.setAttribute("bean",lb);
			request.setAttribute("status", "from servlet");
			forward("seedetail.jsp",request,response);
			
		}
		
		if(xcode.equals("setstatus"))
		{
			
			int empid=Integer.parseInt(request.getParameter("eid"));
			String leavestatus=request.getParameter("status");
			MegawareDao md=new MegawareDao();
			boolean check=md.setStatus(empid,leavestatus);
			//MegawareDao md=new MegawareDao();
			ArrayList<LmsBean> alhb =md.showLeaveRequest();
			request.setAttribute("data", alhb);
			request.setAttribute("status", "from servlet");
			//request.setAttribute("bean",lb);
			System.out.println("==================== after set status");
			forward("setstatus.jsp",request,response);
			
		}
		if(xcode.equals("update"))
		{
			System.out.println("hi in update");
			MegawareDao md=new MegawareDao();
			ArrayList<LmsBean> alhb =md.showStatusTable();
			request.setAttribute("data", alhb);
			System.out.println("size of arraylist="+alhb.size());
			request.setAttribute("status", "from servlet");
			forward("updatestatus.jsp", request, response);
			System.out.println("in servlet");
		}
				
		if(xcode.equals("updatestatus"))
		{
			System.out.println("in servlet see detail part");
			int empid=Integer.parseInt(request.getParameter("empid"));
			MegawareDao md=new MegawareDao();
			LmsBean lb=md.seeUpdateDetails(empid);
			request.setAttribute("bean",lb);
			System.out.println("in updatedstatus in megaware servlet after getting particular info in bean obj and leave status="+lb.getLeavestatus());
			request.setAttribute("status", "from servlet");
			forward("updatestatusdetail.jsp",request,response);
			
		}
	
		if(xcode.equals("setupdatedstatus"))
		{
			System.out.println("empid="+request.getParameter("eid"));
			System.out.println("empid="+Integer.parseInt(request.getParameter("eid")));
			System.out.println("==================== chal jao please");
			System.out.println("empid="+Integer.parseInt(request.getParameter("eid")));
			int empid=Integer.parseInt(request.getParameter("eid"));
			String leavestatus=request.getParameter("status");
			MegawareDao md=new MegawareDao();
			System.out.println("==================== chal jao please2");
			boolean check=md.setUpdatedStatus(empid,leavestatus);
			System.out.println("==================== chal jao please,, method chal gaya");
			request.setAttribute("check", check);
			//MegawareDao md=new MegawareDao();
		ArrayList<LmsBean> alhb =md.showStatusTable();
			request.setAttribute("data", alhb);
			request.setAttribute("status", "from servlet");
			//request.setAttribute("bean",lb);
			System.out.println("==================== after set status");
			forward("updatestatus.jsp",request,response);
		}
		if((xcode.equals("read"))||(xcode.equals("indreaddone"))||(xcode.equals("delete")))
		{
			
			

			System.out.println("hi in read servlet");
			MegawareDao md=new MegawareDao();
			ArrayList<LmsBean> alhb =md.showStatusTable();
			request.setAttribute("data", alhb);
			System.out.println("size of arraylist="+alhb.size());
			request.setAttribute("status", "from servlet");
			if(xcode.equals("delete"))
			{
				forward("deletestatus.jsp", request, response);
				System.out.println("in servlet");
				
			}
			else{forward("readstatus.jsp", request, response);
			System.out.println("in servlet");
			}
			
			
		
			
		}
		if(xcode.equals("readstatus"))
		{
			System.out.println("in servlet read detail part");
			int empid=Integer.parseInt(request.getParameter("empid"));
			MegawareDao md=new MegawareDao();
			LmsBean lb=md.seeUpdateDetails(empid);
			request.setAttribute("bean",lb);
			System.out.println("in updatedstatus in megaware servlet after getting particular info in bean obj and leave status="+lb.getLeavestatus());
			request.setAttribute("status", "from servlet");
			forward("readstatusdetail.jsp",request,response);
			
		}
		if(xcode.equals("deleteleavestatus"))
		{
			System.out.println("Sir, you are in delete status records part of servlet");
			//	String[] index=request.getParameterValues("delete");
				
				//System.out.println("Deletion Started");
				String[] ids = request.getParameterValues("delete");
				System.out.println("lenthgiktjkt="+ids.length);
				for(String id : ids)
				{
					System.out.println(id);
				}
				MegawareDao md=new MegawareDao();
				ArrayList<LmsBean> alhb =md.deletStatusRecords(ids);
				request.setAttribute("data", alhb);
				System.out.println("size of arraylist="+alhb.size());
				request.setAttribute("status", "from servlet");
				
					forward("deletestatus.jsp", request, response);
					System.out.println("in servlet");
		}
		
		/*if(xcode2.equals("deletestatusrecords"))
		{
			System.out.println("Sir, you are in delete status records part of servlet");
		//	String[] index=request.getParameterValues("delete");
			
			//System.out.println("Deletion Started");
			String[] ids = request.getParameterValues("delete");
			System.out.println("lenthgiktjkt="+ids.length);
			for(String id : ids)
			{
				System.out.println(id);
			} */
			//RequestDispatcher rd = request.getRequestDispatcher("DeleteMultipleResult.jsp");
			//String st = DeleteHelper.deleteMultiple(ids);
			//request.setAttribute("status", st );
			//rd.forward(request, response);
			
			
			
			
			/*
			MegawareDao md=new MegawareDao();
			
			
			ArrayList<LmsBean> alhb =md.deletStatusRecords(index);
			request.setAttribute("data", alhb);
			System.out.println("size of arraylist="+alhb.size());
			request.setAttribute("status", "from servlet");
			
				forward("deletestatus.jsp", request, response);
				System.out.println("in servlet");
			*/
			
		
		
		
	}
	public void forward(String path, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}


}
