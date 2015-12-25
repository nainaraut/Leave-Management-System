package com.tcs.ilp84.LMS.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp84.LMS.bean.AllocationBean;
import com.tcs.ilp84.LMS.dao.AllocationDao;

public class AllocationService {
	
	public boolean addDetails(AllocationBean ab) throws SQLException
	{
		AllocationDao ad=new AllocationDao();
		return ad.addDetails(ab);
	}
	
	public boolean viewDetails(AllocationBean ab) throws SQLException
	{
		AllocationDao ad=new AllocationDao();
		return ad.viewDetails(ab);
	}
	
	

	public ArrayList<String> fetchDetails() throws SQLException {
		
		AllocationDao ad=new AllocationDao();
		return ad.fetchDetails();
		
	
	}

	public boolean getName(AllocationBean ab) throws SQLException {
		
		AllocationDao ad=new AllocationDao();
		return ad.getNames(ab);
		
		
		
	}

	public boolean updateDetails(AllocationBean ab) throws SQLException {
		
		AllocationDao ad=new AllocationDao();
		return ad.updateDetails(ab);
	}
public boolean updateDetails1(AllocationBean ab,int days) throws SQLException {
		
		AllocationDao ad=new AllocationDao();
		return ad.updateDetails1(ab,days);
	}

	public boolean getType(AllocationBean ab) throws SQLException {
		
		AllocationDao ad=new AllocationDao();
		return ad.getType(ab);
	}

	public AllocationBean getData(String name) throws SQLException {
		AllocationDao ad=new AllocationDao();
		return ad.getData(name);
	}

	public boolean userResult(AllocationBean ab) throws SQLException {
		
		AllocationDao ad=new AllocationDao();
		return ad.userResult(ab);
	}

	public ArrayList<AllocationBean> viewLeaveData(AllocationBean ab) throws SQLException {
		AllocationDao ad=new AllocationDao();
		return ad.viewLeaveData(ab);
	}

	public String deleteRequest(AllocationBean ab) throws SQLException {
		// TODO Auto-generated method stub
		AllocationDao ad=new AllocationDao();
		return ad.deleteDetails(ab);
	}
	

	

}
