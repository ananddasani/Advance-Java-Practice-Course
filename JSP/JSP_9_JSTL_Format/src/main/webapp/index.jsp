<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formatting Tag</title>
</head>
<body>

	<c:set var="str" value="123.456" scope="session"></c:set>
	<h1>
		<c:out value="Testing :: ${str}"></c:out>
		<br> <br>
	</h1>

	<!-- parseNumber -->
	<fmt:parseNumber var="i" value="${str}" type="number"
		integerOnly="true"></fmt:parseNumber>
	<fmt:parseNumber var="j" value="${str}" type="number"></fmt:parseNumber>

	<c:out value="${str} parsed to Integer :: ${i}"></c:out>
	<br>
	<c:out value="${str} parsed to number :: ${j}"></c:out>

	<br>
	<br>

	<!-- formatNumber -->
	<h2>Different Formats of the Number</h2>
	<c:set var="Amount" value="9850.14115" />
	<p>
		Formatted Number-1:
		<fmt:formatNumber value="${Amount}" type="currency" />
	</p>
	<p>
		Formatted Number-2:
		<fmt:formatNumber type="number" groupingUsed="true" value="${Amount}" />
	</p>
	<p>
		Formatted Number-3:
		<fmt:formatNumber type="number" maxIntegerDigits="3" value="${Amount}" />
	</p>
	<p>
		Formatted Number-4:
		<fmt:formatNumber type="number" maxFractionDigits="6"
			value="${Amount}" />
	</p>
	<p>
		Formatted Number-5:
		<fmt:formatNumber type="percent" maxIntegerDigits="4"
			value="${Amount}" />
	</p>
	<p>
		Formatted Number-6:
		<fmt:formatNumber type="number" pattern="###.###$" value="${Amount}" />
	</p>

	<!-- formatDate -->
	<h2>Different Formats of the Date</h2>
	<c:set var="Date" value="<%=new java.util.Date()%>" />
	<p>
		Formatted Time :
		<fmt:formatDate type="time" value="${Date}" />
	</p>
	<p>
		Formatted Date :
		<fmt:formatDate type="date" value="${Date}" />
	</p>
	<p>
		Formatted Date and Time :
		<fmt:formatDate type="both" value="${Date}" />
	</p>
	<p>
		Formatted Date and Time in short style :
		<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
			value="${Date}" />
	</p>
	<p>
		Formatted Date and Time in medium style :
		<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"
			value="${Date}" />
	</p>
	<p>
		Formatted Date and Time in long style :
		<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
			value="${Date}" />
	</p>


	<!-- parseDate -->
	<h3>Parsed Date:</h3>
	<c:set var="date" value="12-08-2016" />

	<fmt:parseDate value="${date}" var="parsedDate" pattern="dd-MM-yyyy" />
	<p>
		<c:out value="${parsedDate}" />
	</p>

	<c:set var="date" value="<%=new java.util.Date()%>" />
	<p>
		<b>Date and Time in Indian Standard Time(IST) Zone:</b>
		<fmt:formatDate value="${date}" type="both" timeStyle="long"
			dateStyle="long" />
	</p>
	<fmt:setTimeZone value="GMT-10" />
	<p>
		<b>Date and Time in GMT-10 time Zone: </b>
		<fmt:formatDate value="${date}" type="both" timeStyle="long"
			dateStyle="long" />
	</p>


	<!-- setTimeZone -->
	<c:set var="date" value="<%=new java.util.Date()%>" />
	<p>
		<b>Date and Time in Indian Standard Time(IST) Zone:</b>
		<fmt:formatDate value="${date}" type="both" timeStyle="long"
			dateStyle="long" />
	</p>
	<fmt:setTimeZone value="GMT-10" />
	<p>
		<b>Date and Time in GMT-10 time Zone: </b>
		<fmt:formatDate value="${date}" type="both" timeStyle="long"
			dateStyle="long" />
	</p>

</body>
</html>

<!-- 

Tags Summary 

1. parseNumber
2. formatNumber
3. formatDate
4. parseDate
5. setTimeZone 
6. timeZone
7. message

 -->