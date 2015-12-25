package com.tcs.ilp84.LMS.bean;

public class LmsBean {
	private String firstname;
	private String lastname;
	private int employeeid;
	private String designation;
	private String startdate;
	private String enddate;
	private String leavetype;
	private String reason;
	private String phonenumber;
	private String status;
	private int days_allocated;
	private String leavestatus;
	
	public String getLeavestatus() {
		return leavestatus;
	}


	public void setLeavestatus(String leavestatus) {
		this.leavestatus = leavestatus;
	}


	public LmsBean(String firstname, String lastname, int employeeid,
			String designation, String startdate, String enddate,
			String leavetype, String reason, String phonenumber, String status,
			int daysAllocated) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.employeeid = employeeid;
		this.designation = designation;
		this.startdate = startdate;
		this.enddate = enddate;
		this.leavetype = leavetype;
		this.reason = reason;
		this.phonenumber = phonenumber;
		this.status = status;
		days_allocated = daysAllocated;
	}


	public LmsBean() {
		super();
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phone) {
		this.phonenumber = phone;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getDays_allocated() {
		return days_allocated;
	}


	public void setDays_allocated(int daysAllocated) {
		days_allocated = daysAllocated;
	}
	

}
