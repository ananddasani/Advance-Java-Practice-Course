package evolution;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PhaseThree extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("In the get method...");
		
		//set the content type (MIME)
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		
		out.println("<h1> Phase Three (Using HttpServlet) </h1>");
		out.println("<h3> Todays Date and Time is :: " + new Date().toString() + " </h3>");
	}
}

/*
 * This provide the http related methods like doGet, doPost, doPut ...
 * So always using HttpServlet for web like specific work 
 */
