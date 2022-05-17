<%@page import="beans.StudentBean"%>
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
	// Extract name, enrollment, mobile, cpi
	String name = request.getParameter("name");
	String mobile = request.getParameter("mobile");
	String enrollemnt = request.getParameter("enrollment");
	int cpi = Integer.parseInt(request.getParameter("cpi"));

	//Set all above details in StudentBean class and move to next page
	StudentBean bean = new StudentBean();
	
	bean.setStudent_name(name);
	bean.setEnrollment_no(enrollemnt);
	bean.setMobile_no(mobile);
	bean.setCpi(cpi);
	
	//Forward this bean to next page (view.jsp)
	request.setAttribute("bean", bean);
	
	//Let's move to next page
	RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
	dispatcher.forward(request, response);
	%>

</body>
</html>