<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
     <link href="resourse/test1.css" rel="stylesheet" type="text/css">
	</style>
<title>Home</title>
</head>
<body background="resourse/wrapper-bg.jpg;" style=" color:#592C0C;"><p>
<h1 >Introduction</h1><br>

<h3>
<div>
<div>Key Assumptions, Dependencies, Constraints and Overriding Priorities
The successful execution of the assignment will depend on the following factors:</div>
<div style="height:40%;width:40%;float:right;" ><img src="resourse/logo.jpg;"></img></div>
</div>

</h3> 



<br><h1>Scope</h1></br>
<h3>
This is a on demand , on line application, which is useful for this particular (Megaware) organization. It very helpful for administration, HR personnel and employees also. Through this system employees can apply for leave
, HR can manage the employee data and leave records of employees.  Being a flexible system it can be upgraded in the future according to requirement of organization.

Key Assumptions, Dependencies, Constraints and Overriding Priorities
The successful execution of the assignment will depend on the following factors:

Assumptions:
Following are the assumptions and constraints used for the functional requirements and there by the
system behavior. The following is assumed while defining the functional requirement based on the
current model.
• The requirements are explicitly created for the purpose of learning the phase wise
development of web application in ILP.
• Use cases are tailored to accommodate the scope for learning CRUD/CR and to make the
division of work easier for different groups who are working on different modules of the
application.
• Only CRUD (create/read/update/delete) functionality will be supported by the system in the first
phase.
• Screen design for List/View/Update pages is similar for all modules, hence these screens are
shown only in the first modules (section 3.1) details. Only create screen is shown for other
modules. Use similar screen design for CRUD functionality in all other modules.
• Validate all the data before submitting as necessary. For example user must not be allowed to
submit the form unless the required form fields are filled in with valid inputs.
• System must do the post submit validations as well (called server side validations). For
example while creating the leave records, system must not allow to create a leave request for
an employee who has already applied for leave during given dates.
• System allows only soft-delete of data. Do not physically delete the data from system, but set
the record status to inactive and consider those records as deleted, do not show such records
in the view pages/search results.
• System is supporting only full day leaves. We are not handling half-day leaves.
• Provide the necessary links/menu in the system for smooth navigation among the different
modules in the system. For example though it is not shown in the above screens shots, provide
the links like 'Back', 'Home' etc wherever required. Keep in mind, the user must be able to
navigate through all the areas of the application without using Back/Refresh buttons of the
browser
• HR is the sole user of the system. During the next phase, the system will support all the
employee self service and work flow functionality
• Through out the system while entering and displaying the data, use the date in dd-mm-yyyy
format. e.g. 15th of May,2012 is displayed/entered as 15-05-2012. Consider the time format is
hh:mm and is in 24 hr format.</h3>
<br><h1>Dependencies</h1>
<h3>

Involvement of the end users in signing off this SRS document.
Availability of System Software from the client for development.
Availability of installed hardware/System software for implementation.
Feedback on this report will be provided as per the agreemnent in the contract. Any delay in the feedback will have impact on the schedule and cost of the project.


Constraints

None

>
User Classes and Characteristics
Managing holiday details:  Provide CRUD functionality for managing company holiday details.
The following mandatory details should be captured. Holiday name, Date, Holiday type
(Regional/Flexi/Mandatory etc), Comments.

Managing leave type details: Provide CRUD functionality for managing leave type details. The
following mandatory details should be captured. Leave type, Maximum number of days per year,
Created by and Comments.

Managing system global parameters: Provide CRUD functionality for managing some system
wide parameters and details. The following mandatory details should be captured. Parameter name,
Type (date/number/string), Parameter value, Last update date, Last modified by(employee id).

Hardware and Software Platform
Software:
                  Windows Xp and above version OS.
                  TOOL:
                     User interface:HTML, CSS, Javascript.
                     Logic: using j2ee.
                     Database: Oracle 10g.
Hardware:
	     32 bit processor
	     128 MB RAM


Application Security
Application is enough secure to protect the system from unauthorized access, and to save the database from unintended modification. Password policy is used to provide the security.</p>
</h3>
</body>
</html>