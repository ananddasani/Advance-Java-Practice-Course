<!-- Directive Tag (Page) -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" autoFlush="true" buffer="8kb"
	isErrorPage="false" isThreadSafe="true" isELIgnored="false"
	session="true"%>

<%@ page import="java.util.Scanner, java.sql.*"%>

<!-- Directive Tag (Include) -->
<%@ include file="CommonHeader.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tags Demo</title>
</head>
<body>

	<strong> 1. Scriptlet Tag ===> Goes in Service() Method when
		JSP page get converted into ..._jsp.java <br> <br> 2.
		Directive Tag (Page, Include, Taglib) ===> Goes outside of class
		declaration (like import, extends, implements.....) <br> <br>
		3. Declaration Tag ===> Goes inside of Class but outside of Service()
		(like global_variables...) <br> <br> 4. Expression Tag ===>
		Goes inside of out.println(.....) <br> <br>
	</strong>

	<br>
	<br>

	<!-- Scriplet Tag -->
	<%
	int i = 10;
	int j = 10;

	int sum = i + j;

	out.println(i + " + " + j + " = " + sum);
	%>

	<!-- Using Declaration Tag -->
	<%!double PI = 3.14;%>

	<!-- Using Expression Tag -->
	<br>
	<br>
	<br> Value of PI ::
	<%=PI%>

</body>
</html>


<!-- 

1. Scriptlet Tag    ===> Goes in Service() Method when JSP page get converted into ..._jsp.java 
2. Directive Tag (Page, Include, Taglib)  ===> Goes outside of class declaration (like import, extends, implements.....)
3. Declaration Tag  ===> Goes inside of Class but outside of Service() (like global_variables...)
4. Expression Tag  ===> Goes inside of out.println(.....)  


------------ SEE THE theory.jsp FILE FOR MORE & DETAILED THEORY -----------------------------


 -->