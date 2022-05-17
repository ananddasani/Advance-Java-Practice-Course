<%@page import="javabeans.MarksBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View</title>
</head>
<body>

	<%
	MarksBean bean = (MarksBean) request.getAttribute("bean");
	
	out.println(bean);
	%>
	
	<%-- <br> <br> Class :: <%= bean.getClasss() %> <br> 
	Percentage :: <%= bean.getPercentage() %> --%>
	
</body>
</html>