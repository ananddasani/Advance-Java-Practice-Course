package evolution;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Test implements Servlet{
	
	ServletConfig config;

	@Override
	public void destroy() {
		System.out.println("Destroying...");
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return this.config;
	}

	@Override
	public String getServletInfo() {
		
		return "Created By A.D";
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("Inside Service...");
		
		PrintWriter out = arg1.getWriter();
		arg1.setContentType("text/html");
		
		out.println("Hello from the Generic Class Servlet :)");
		
	}

}
