package session_management;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Here collect all the info of user and show on to the page
		// Also save all that info into a session for next page (or further use)

		String u_name = request.getParameter("u_name");
		String u_age = request.getParameter("u_age");
		String u_sem = request.getParameter("u_sem");
		String u_email = request.getParameter("u_email");
		String u_city = request.getParameter("u_city");

		// saving the info of user in the session
		HttpSession session = request.getSession(true);

		session.setAttribute("u_name", u_name);
		session.setAttribute("u_age", u_age);
		session.setAttribute("u_sem", u_sem);
		session.setAttribute("u_email", u_email);
		session.setAttribute("u_city", u_city);

		System.out.println("Session Saved Successfully");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><head><title> Session Management </title></head><body>");
		out.println("Name :: " + u_name + "<br> Age :: " + u_age + "<br>");
		out.println("Sem :: " + u_sem + "<br> Email :: " + u_email + "<br> City :: " + u_city + "<br>");
		out.println("<br> <a href='/ServletTwo'>Go to next Page</a>");
		out.println("</body></html>");
	}

}
