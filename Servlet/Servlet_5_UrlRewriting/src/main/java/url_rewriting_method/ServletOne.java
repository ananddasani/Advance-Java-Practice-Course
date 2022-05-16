package url_rewriting_method;

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

		String user_name = "";

		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();

		// Extract user name
		user_name = request.getParameter("name");

		printWriter.println("<!DOCTYPE html>");
		printWriter.println("<html lang='en'>");
		printWriter.println("<head>");
		printWriter.println("<title>URL Rewriting</title>");
		printWriter.println("</head>");
		printWriter.println("<body>");
		printWriter.println("<h1>Welcome " + user_name + " To ServletOne </h1>");
		printWriter.println("<br>");

		// Making URL (Rewriting)
		printWriter.println("<h1><a href='ServletTwo?user=" + user_name + "'>Go To Servlet 2</a></h2>");

		printWriter.println("</body>");
		printWriter.println("</html>");
	}

}
