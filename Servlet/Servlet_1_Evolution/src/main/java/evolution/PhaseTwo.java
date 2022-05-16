package evolution;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.*;

public class PhaseTwo extends GenericServlet {
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("Using Generic Servlet");
		
		//set the content
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1> Phase Two (Using GenericServlet) </h1>");
		out.println("<h3> Todays Date and Time is :: " + new Date().toString() + " </h3>");
	}
}

/*
 * Here all methods are implemented already except service 
 * so we will only orrived service method
 */