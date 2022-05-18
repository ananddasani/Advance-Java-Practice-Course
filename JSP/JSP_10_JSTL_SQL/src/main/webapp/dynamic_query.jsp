<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SQL Tags</title>
</head>
<body>

	<!-- import, Class.forName(), Connection, (DriverRegistration) Done :) -->
	<sql:setDataSource var="db" user="root" password="root"
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/anand" />


	<!-- DELETE FROM Students WHERE Id = ?   -->
	<c:set var="StudentId" value="152" />
	<sql:update dataSource="${db}" var="count">  
		DELETE FROM Students WHERE Id = ?  
 		<sql:param value="${StudentId}" />
	</sql:update>


	<!-- select * from students; -->
	<sql:query var="rs" dataSource="${db}">
		SELECT * FROM student;
	</sql:query>

	<table border="2" width="100%">

		<tr>
			<th>id</th>
			<th>fName</th>
			<th>lName</th>
			<th>Marks</th>
			<th>City</th>
		</tr>

		<c:forEach var="table" items="${rs.rows}">

			<tr>
				<td><c:out value="${table.id}"></c:out></td>
				<td><c:out value="${table.fName}"></c:out></td>
				<td><c:out value="${table.lName}"></c:out></td>
				<td><c:out value="${table.marks}"></c:out></td>
				<td><c:out value="${table.city}"></c:out></td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>

<!-- 

Tags Summary 

1. query
2. setDataSource
3. update
4. param
5. dateParam 
6. transaction

 -->