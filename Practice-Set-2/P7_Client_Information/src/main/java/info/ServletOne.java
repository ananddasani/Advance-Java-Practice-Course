package info;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter printWriter = response.getWriter();

		printWriter.println("<!DOCTYPE html>");
		printWriter.println("<html lang='en'>");
		printWriter.println("<head>");
		printWriter.println("<title>Client's Browser Info</title>");
		printWriter.println("</head>");
		printWriter.println("<body>");

		// Get the info of client browser
		String user_browser = request.getHeader("User-agent");

		printWriter.println("Client Browser :: " + user_browser + "<br> <br>");
		printWriter.println("<br> Client IP Address :: " + request.getRemoteAddr() + "<br> <br>");
		printWriter.println("<br> Client Port Number :: " + request.getRemotePort() + "<br> <br>");
		printWriter.println("<br> Server Port Number :: " + request.getServerPort() + "<br> <br>");
		printWriter.println("<br> Local Port Number :: " + request.getLocalPort() + "<br> <br>");
		printWriter.println("<br> Method Used By Client :: " + request.getMethod() + "<br> <br>");
		
		Date date = new Date();
		
		printWriter.println("System Date and Time :: " + date.toString() + "<br> <br>");
		
		printWriter.println("</body>");
		printWriter.println("</html>");
	}

}
