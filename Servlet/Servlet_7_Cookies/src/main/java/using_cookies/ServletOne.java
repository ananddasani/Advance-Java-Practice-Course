package using_cookies;

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

		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();

		// extract the user name
		String user_name = request.getParameter("name");

		// Attaching cookie with the response
		try {
			Cookie cookie = new Cookie("UserNameKey", user_name);
			response.addCookie(cookie);

			// Log
			System.out.println("Cookie Saved");
		} catch (Exception e) {
			System.out.println("Trying to save invalid character into the cookie");
			// e.printStackTrace();
		}

		printWriter.println("<!DOCTYPE html>");
		printWriter.println("<html lang='en'>");
		printWriter.println("<head>");
		printWriter.println("<title>Https Stateless Problem</title>");
		printWriter.println("</head>");
		printWriter.println("<body>");
		printWriter.println("<h1>Welcome " + user_name + " To ServletOne </h1>");
		printWriter.println("<br>");
		printWriter.println("<h1><a href='ServletTwo'>Go To Servlet 2</a></h2>");
		printWriter.println("</body>");
		printWriter.println("</html>");
	}

}

/*
 * Cookies can contain only textual information && No space space (32) is a
 * illegal character for storing in cookie file
 */
