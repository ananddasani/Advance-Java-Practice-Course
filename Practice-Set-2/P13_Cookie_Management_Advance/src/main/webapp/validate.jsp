<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Valiating...</title>
</head>
<body>

	<!-- Validate the Username and Password & then create the cookie username -->
	<%
	// Extract username and password and it must be anand & java
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	if (username.equals("deep") && password.equals("java")) {
		// Creating and store the username in the cookie
		Cookie cookie = new Cookie("username", username);
		response.addCookie(cookie);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
		dispatcher.forward(request, response);
		
	} else {
		out.println("<h1>Invalid Username or Password </h1>");

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		dispatcher.include(request, response);
	}
	%>

</body>
</html>