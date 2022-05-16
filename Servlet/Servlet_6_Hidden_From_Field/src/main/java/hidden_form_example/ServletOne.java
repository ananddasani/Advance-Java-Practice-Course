package hidden_form_example;

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

		// set the content type
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();

		// Getting user name entered by the user
		String user_name = request.getParameter("name");

		// Making Page
		printWriter.println("<!DOCTYPE html>");
		printWriter.println("<html lang='en'>");
		printWriter.println("<head>");
		printWriter.println("<title>Https Stateless Problem</title>");
		printWriter.println("</head>");
		printWriter.println("<body>");
		printWriter.println("<h1>Welcome " + user_name + " To ServletOne </h1>");
		printWriter.println("<br>");

		// ------------ Now Passing To the ServletTwo by making a form (Hidden form
		// field)
		printWriter.println("" + "<form action='ServletTwo'>" + "<input type='hidden' name='user_name' value="
				+ user_name + ">" + "<button>Go To Second Servlet</button>" + "</form>");

		printWriter.println("</body>");
		printWriter.println("</html>");
	}
}
