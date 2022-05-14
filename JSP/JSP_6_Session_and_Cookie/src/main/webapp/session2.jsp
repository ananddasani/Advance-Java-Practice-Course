<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Example</title>
</head>
<body>


	<h1>Here are your session details</h1>
	<br>
	<br>

	<!-- Extract all the session data and show them on the page -->
	
	<!-- Using EL -->
	<p> Hello ${sessionScope.nameKey} </p> <br>
	
	<p> So you live in ${sessionScope.cityKey } </p> <br>
	
	<!-- Now using scriplet tag -->
	<%
	int u_age = (int) session.getAttribute("ageKey");
	%>
	
	<p> And your age is :: <%= u_age %>
	 
	

</body>
</html>