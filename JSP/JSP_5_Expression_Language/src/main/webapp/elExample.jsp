<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EL EXAMPLE</title>
</head>
<body>

	<!-- Fetch all the details using EL -->
	<p>Hello ${param.u_name}</p>

	<p>Your Address is :: ${param.address}</p>

	<p>Cookie Name :: ${cookie.myCookieKey.name}</p>

	<p>Cookie Value :: ${cookie.myCookieKey.value}</p>
	
	<p>Session id :: ${sessionScope.sid} </p>

</body>
</html>