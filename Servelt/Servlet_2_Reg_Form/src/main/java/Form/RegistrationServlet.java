package Form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// using request to extact all the information of user we got from the form
		PrintWriter printWriter = response.getWriter();
		response.setContentType("text/html");

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
			} else
				printWriter.println("<h3>You Have to Agree With Our T&C</h3>");

		} else
			printWriter.println("<h3> You Have to Agree With Our T&C </h3>");
	}

}

/*
 * Response is used by server to let user know something and to send the data
 * Request is used by server to extract all the information and to use it
 * internally
 */
