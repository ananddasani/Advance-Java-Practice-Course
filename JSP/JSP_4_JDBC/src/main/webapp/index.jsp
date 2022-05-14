<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error_page.jsp"%>

<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%!String USER = "root";
	String PASS = "root";
	String URL = "jdbc:mysql://localhost:3306/anand";

	String sql = "SELECT * FORM students";%>

	<%
	Class.forName("com.mysql.cj.jdbc.Driver");

	Connection connection = DriverManager.getConnection(USER, PASS, URL);

	Statement statement = connection.createStatement();

	ResultSet resultSet = statement.executeQuery(sql);

	while (resultSet.next()) {

		int id = resultSet.getInt("id");
		String fName = resultSet.getString("fName");
		String lName = resultSet.getString("lName");
		int marks = resultSet.getInt("marks");
		String city = resultSet.getString("city");

		out.println("<br>fName :: " + fName + "<br>lName :: " + lName + "<br>Marks :: " + marks + "<br>City :: " + city
		+ "<br><br><br>");
	}
	%>

</body>
</html>


<!-- 
I am having "students" table in my "anand" Database (using MySql)


mysql> select * from students;
+----+---------+---------+-------+-----------+
| id | fName   | lName   | marks | city      |
+----+---------+---------+-------+-----------+
|  1 | Anand   | Dasani  |    90 | Porbandar |
|  2 | Dhruv   | Lakhani |    90 | Mumbai    |
|  3 | Bharat  | Singh   |    70 | Pune      |
|  4 | Prakash | Tambe   |    65 | Chennai   |
|  5 | Rohit   | Yadav   |    85 | Mumbai    |
|  6 | Manoj   | Sharma  |    65 | Goa       |
+----+---------+---------+-------+-----------+

 -->