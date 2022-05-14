<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details Page</title>
</head>
<body>

	<!-- Adding Cookie and Session id -->
	<%
	Cookie cookie = new Cookie("myCookieKey", "Anand");
	response.addCookie(cookie);

	session.setAttribute("sid", "012");
	%>

	<form action="elExample.jsp">
		Name <input type="text" name="u_name"> <br> Address <input
			type="text" name="address"> <br> <br> <input
			type="submit" value="Go to next jsp page">
	</form>

</body>
</html>