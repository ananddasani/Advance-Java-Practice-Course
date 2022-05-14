<!-- 
Write a jsp program that will print following message based on the system time:
If system_hour<12: message: Good morning
If system_hour<17 & >12: messsage: Good afternoon
If system_hour>17 & <20: message: Good evening
If system_hour>20 & <24: message: Good night

 -->

<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
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
	GregorianCalendar gc = new GregorianCalendar();
	
	int hour = gc.get(Calendar.HOUR_OF_DAY);
	int day = gc.get(Calendar.DAY_OF_MONTH);
	int minute = gc.get(Calendar.MINUTE);
	int month = gc.get(Calendar.MONDAY) + 1;
	int year = gc.get(Calendar.YEAR);
	
	out.println("The Current Time is " + hour + ":" + minute);
	out.println("<br><br>Today's Date is " + month + "/" + year);
	
	String greeting = "Hello ";
	if(hour < 12)
		greeting = "Good Morning ";
	else if (hour < 17)
		greeting = "Good Afternoon ";
	else if(hour < 20)
		greeting = "Good Evening ";
	else 
		greeting = "Good Night ";
	%>
	
	<h1><%= greeting %> User </h1>
	
</body>
</html>