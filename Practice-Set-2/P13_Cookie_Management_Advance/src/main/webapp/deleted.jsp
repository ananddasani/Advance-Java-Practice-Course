<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cookie Deleted</title>
</head>
<body>

	<%
	//Extract cookies and show the value
	Cookie[] cookies = request.getCookies();

	for (int i = 0; i < cookies.length; i++) {
		if (cookies[i].getName().equals("username")) {
			cookies[i].setMaxAge(0);
			
			out.println("Cookie Deleted :)");
			break;
		}
	}
	%>

</body>
</html>