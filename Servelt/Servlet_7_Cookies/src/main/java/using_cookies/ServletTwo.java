package using_cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.geom.FlatteningPathIterator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class ServletTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isDesiredValuePresent = false;
		String user_name = "";

		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();

		// extract the user name from the cookies
		Cookie[] cookies = request.getCookies();

		// Here we got cookies if there is noting in the cookie null will be returned
		if (cookies == null) {
			isDesiredValuePresent = false;
			printWriter.println("<h2>You are new user so go to home page and submit your name first.</h2>");

			// Log
			System.out.println("Because Cookies[] is null");
			return;
		}

		// if cookie contains the informaion then array will be returned and we have to
		// find our desired value
		for (Cookie c : cookies) {
			if (c.getName().equals("UserNameKey")) {
				user_name = c.getValue();
				isDesiredValuePresent = true;
				break;
			}
		}

		if (isDesiredValuePresent) {
			printWriter.println("<h1>Welcome " + user_name + " To ServletTwo </h1>");
			printWriter.println("<br>");
			printWriter.println("<h1>Thanks For Visiting</h2>");
		} else {
			printWriter.println("<h2>You are new user so go to home page and submit your name first.</h2>");

			// Log
			System.out.println("Because isDesiredValuePresent: " + isDesiredValuePresent);
		}

	}

}
