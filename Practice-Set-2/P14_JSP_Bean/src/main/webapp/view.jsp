<%@page import="beans.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Page</title>
</head>
<body>

	<%
	out.println("<h1> Below is the values saved in Bean Class from previous page </h1>");
	
	StudentBean bean = (StudentBean) request.getAttribute("bean");
	%>
	
	<br> <br>
	 
	Student Name :: <%= bean.getStudent_name() %> <br> 
	Student Enrollment :: <%= bean.getEnrollment_no() %> <br> 
	Student Mobile :: <%= bean.getMobile_no() %> <br> 
	Student CPI :: <%= bean.getCpi() %> <br> 

</body>
</html>