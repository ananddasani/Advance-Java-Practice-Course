<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Functions Tag</title>
</head>
<body>

	<c:set var="str" value="Anand lives in probandar" scope="session"></c:set>
	<h1>
		<c:out value="Testing :: ${str}"></c:out>
		<br> <br>
	</h1>

	<!-- contains() -->
	<c:out value="${str} contains lives :: ${fn:contains(str, 'lives')}"></c:out>
	<br>
	<br>

	<!-- endsWith() -->
	<c:out
		value="${str} endsWith d :: ${fn:endsWith(userName, 'porbandar') }"></c:out>
	<br>
	<br>

	<!-- toUpperCase() -->
	<c:out value="${str} in upper case :: ${fn:toUpperCase(str) }"></c:out>
	<br>
	<br>

	<!-- toLowerCase() -->
	<c:out value="${str} in lower case :: ${fn:toLowerCase(str)}"></c:out>
	<br>
	<br>

	<!-- indexOf() -->
	<c:out
		value="Index of Anand in :: ${str} is  ${fn:indexOf(str, 'Anand') }"></c:out>
	<br>
	<br>

	<!-- length() -->
	<c:out value="length of :: ${str} is  ${fn:length(str) }"></c:out>
	<br>
	<br>

	<!-- replace() -->
	Replacing Anand with A.D...
	<br>
	<c:out value="Result :: ${fn:replace(str, 'Anand', 'A.D') }"></c:out>
	<br>

	<!-- join() & split() -->
	<c:set var="str1" value="Anand-is-20-years-old" scope="session"></c:set>
	<c:set var="str2" value="${fn:split(str1, '-') }"></c:set>
	<c:set var="str3" value="${fn:join(str2, ' ') }"></c:set>

	<p>String-3 : ${str3}</p>
	<c:set var="str4" value="${fn:split(str3, ' ')}" />
	<c:set var="str5" value="${fn:join(str4, '-')}" />

	<p>String-5 : ${str5}</p>
	<br> <br>

</body>
</html>

<!-- 

Tags Summary 

1. contains()
2. endsWith()
3. join()
4. split()
5. replace() 
6. substring()
7. toUpperCase()
8. toLowerCase()
9. trim()
10. length()

 -->