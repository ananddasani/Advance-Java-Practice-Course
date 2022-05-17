/*
 * Write a web application that takes marks of 3 subjects from an html page 
 * and passes them to servlet. This servlet class contain method 
 * getClass()(returns the class as per marks) and getPercentage()(returns the percentage). 
 * Display class and percentage in jsp page.
 */

package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javabeans.MarksBean;

import java.io.IOException;

public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		//get the marks of 3 subjects  
		int mark1 = Integer.parseInt(request.getParameter("mark1"));
		int mark2 = Integer.parseInt(request.getParameter("mark2"));
		int mark3 = Integer.parseInt(request.getParameter("mark3"));
		
		double percentage = getPercentage(mark1, mark2, mark3);
		System.out.println("Percentage ::  " + percentage);
		
		ServletOne servletOne = new ServletOne();
		Class<?> classs = servletOne.getClass();
		
		MarksBean bean = new MarksBean();
		bean.setPercentage(percentage);
		bean.setClasss(classs);
		request.setAttribute("bean", bean);
		
		
		//response.sendRedirect("view.jsp");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
		dispatcher.forward(request, response);
	}

	private double getPercentage(int mark1, int mark2, int mark3) {
		return (mark1 + mark2 + mark3) / 3;
	}

}
