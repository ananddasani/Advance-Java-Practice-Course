package cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<h1> Below is the value of cookie saved from previous page");
		
		//Extract cookies and show the value
		Cookie[] cookies = request.getCookies();
		
		for(int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("username")) {
				out.println("<br><br>Cookie Name :: " + cookies[i].getName() + "<br>");
				out.println("Cookie Value :: " + cookies[i].getValue() + "<br>");
			}
		}
	}
}
