<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Core Tags</title>
</head>
<body>

	<%
	session.setAttribute("name", "Anand Dasani");
	%>

	<c:out value="Hello ${sessionScope.name }"/>


</body>
</html>


<!-- 

Tags Summary 

1. out
2. import
3. set
4. remove 
5. catch
6. if
7. choose -> when -> otherwise
8. forEach
9. forToken
10. param
11. redirect
12. url

 -->