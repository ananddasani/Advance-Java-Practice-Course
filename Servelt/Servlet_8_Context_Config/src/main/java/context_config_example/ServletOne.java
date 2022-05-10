package context_config_example;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();

		// Extract information from the context
		ServletContext context = getServletContext();
		String contextNameString = context.getInitParameter("name");

		printWriter.println("<h1>Getting Name From Context...</h1>");
		printWriter.println("(Global) Name is " + contextNameString);

		// Extract information from the config
		ServletConfig config = getServletConfig();
		String configNameString = config.getInitParameter("name");

		printWriter.println("<br><br><h1>Getting Name From Config...</h1>");
		printWriter.println("(Local) Name is " + configNameString);

	}

}

/*
 * We have only one context (global) for the project But every servlet has their
 * own config
 */