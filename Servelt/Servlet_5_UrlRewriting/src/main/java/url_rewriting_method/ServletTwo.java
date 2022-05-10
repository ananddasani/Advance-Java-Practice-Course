package url_rewriting_method;

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

		String user_name = "";

		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();

		// Extract user name & other info (if any) from the url
		user_name = request.getParameter("user");

		printWriter.println("<h1>Welcome " + user_name + " To ServletTwo </h1>");
		printWriter.println("<br>");
		printWriter.println("<h1>Thanks For Visiting</h2>");
	}

}
