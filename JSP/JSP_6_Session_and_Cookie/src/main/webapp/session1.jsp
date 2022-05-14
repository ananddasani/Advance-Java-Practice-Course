<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session info</title>
</head>
<body bgcolor="green">

	<!-- Save the session -->
	<%
	session.setAttribute("nameKey", "Anand Dasani");
	session.setAttribute("ageKey", 20);
	session.setAttribute("cityKey", "Porbandar");
	%>


	<h1>Your Session is saved :)</h1>

	<form action="session2.jsp">
		<input type="submit" value="See the details of session saved">
	</form>

</body>
</html>