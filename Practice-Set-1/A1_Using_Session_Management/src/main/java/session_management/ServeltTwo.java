package session_management;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


public class ServeltTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Extract all the info of user form the session and show it on the page
		HttpSession session = request.getSession();

		if (session == null) {
			// Session is null means no data saved, so saving it again
			response.sendRedirect("index.html");
		}

		String u_name = (String) session.getAttribute("u_name");
		String u_age = (String) session.getAttribute("u_age");
		String u_sem = (String) session.getAttribute("u_sem");
		String u_email = (String) session.getAttribute("u_email");
		String u_city = (String) session.getAttribute("u_city");

		System.out.println("Session Extracted Successfully");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><head><title> Session Management </title></head><body>");
		out.println("Name :: " + u_name + "<br> Age :: " + u_age + "<br>");
		out.println("Sem :: " + u_sem + "<br> Email :: " + u_email + "<br> City :: " + u_city + "<br>");
		out.println("</body></html>");
	}

}
