<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Here are the cookie name and values</h1>
	<br>
	<br>

	<!-- Extract cookie value and show it on the page -->
	<%
	Cookie[] cookies = request.getCookies();

	for (int i = 0; i < cookies.length; i++) {
		out.println("<p>" + cookies[i].getName() + " : " + cookies[i].getValue() + "</p>");
	}
	%>

	<br>
	<br>

	<form action="session1.jsp">
		<input type="submit" value="Go to Session page example">
	</form>

</body>
</html>