<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	out.println("<h1> Below is the value of cookie saved from previous page");

	//Extract cookies and show the value
	Cookie[] cookies = request.getCookies();

	for (int i = 0; i < cookies.length; i++) {
		if (cookies[i].getName().equals("username")) {
			out.println("<br><br>Cookie Name :: " + cookies[i].getName() + "<br>");
			out.println("Cookie Value :: " + cookies[i].getValue() + "<br>");
		}
	}
	%>
	
	<br><br>
	<a href="deleted.jsp">Delete Cookie</a>

</body>
</html>