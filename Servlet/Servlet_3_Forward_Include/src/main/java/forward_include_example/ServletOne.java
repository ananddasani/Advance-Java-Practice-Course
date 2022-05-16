package forward_include_example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		// using request to extact all the information of user we got from the form
		PrintWriter printWriter = response.getWriter();

		// stroing all the user info
		String user_name = request.getParameter("user_name");
		String user_password = request.getParameter("user_password");
		String user_email = request.getParameter("user_email");
		String user_gender = request.getParameter("user_gender");
		String user_course = request.getParameter("user_course");
		String user_condition = request.getParameter("condition");

		// output on the web page
		if (user_condition != null) {

			if (user_condition.equals("checked")) {
				printWriter.println("<h2> Name: " + user_name + " </h2>");
				printWriter.println("<h2> Password: " + user_password + " </h2>");
				printWriter.println("<h2> Email: " + user_email + " </h2>");
				printWriter.println("<h2> Gender: " + user_gender + " </h2>");
				printWriter.println("<h2> Course: " + user_course + " </h2>");
				
				//--------------- Forwarding ---------------------
				//let's forward to successServelt 
				RequestDispatcher dispatcher = request.getRequestDispatcher("SuccessServlet");
				dispatcher.forward(request, response);
				
				//so successServlet will be executed instead of ServletOne.java
				
			} else
				printWriter.println("<h3>You Have to Agree With Our T&C</h3>");

		} else {
			printWriter.println("<h3> You Have to Agree With Our T&C </h3>");

			// User has not accepted our T&C so output of index.html sholud also be shown
			// so now we will include the index.html using requestDispatcher
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);
		}
	}

}

/*
 * RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
 * 
 * Here if you want to user any servelt then give urlpattern i need to user a
 * page (html) that's why i am giving page name
 */
