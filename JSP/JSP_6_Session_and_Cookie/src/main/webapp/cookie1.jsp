<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Info Page</title>
</head>
<body bgcolor='green'>

	<!-- Saving cookie -->
	<%
	Cookie cookie = new Cookie("MyCookie", "Anand");
	cookie.setMaxAge(60 * 60);
	response.addCookie(cookie);
	%>

	Cookie Saved :)

	<br>
	<br>

	<form action="cookie2.jsp">
		<input type="submit" value="See the details of Cookie saved">
	</form>

</body>
</html>