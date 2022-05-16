package stateless_problem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();

		// extract the user name
		String user_name = request.getParameter("name");

		printWriter.println("<h1>Welcome " + user_name + " To ServletTwo </h1>");
		printWriter.println("<h4>Here null is printed because https is stateless so it is not capable to remember your name you given in index file</h4>");
		printWriter.println("<br>");
		printWriter.println("<h1>Thanks For Visiting</h2>");
	}

}
