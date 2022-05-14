/*
 * Write a html code that takes username and password from user and if valid password is entered, 
 * create cookie storing username and redirect user to a html page that display the value of this cookie.
 */

package cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Extract username and password and it must be anand & java
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.equals("anand") && password.equals("java")) {
			// Creating and string the username in the cookie
			Cookie cookie = new Cookie("username", username);
			response.addCookie(cookie);

			PrintWriter out = response.getWriter();
			response.setContentType("text/html");

			out.println("<h1> Welcome " + username + "<br>");

			out.println("<br> <form action='ServletTwo' method='post'>\n"
					+ "<input type='submit' value='See the Cookie Details'>\n" + "</form>");
		}
	}
}
