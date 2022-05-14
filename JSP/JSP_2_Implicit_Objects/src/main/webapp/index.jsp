<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Implicit Objects in JSP</title>
</head>
<body>

	<%
	pageContext.setAttribute("name", "Anand", PageContext.SESSION_SCOPE);

	String u_name = (String) session.getAttribute("name");

	out.println("Name is :: " + u_name);
	
	%>

	<br>
	<br> Name i got is ::
	<%=u_name%>

</body>
</html>


<!-- 
out	JspWriter

request	HttpServletRequest

response	HttpServletResponse

config	ServletConfig

application	ServletContext

session	HttpSession

pageContext	PageContext

page	Object

exception	Throwable

 -->