package visit_count;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int visit_count = 1;

	public void init() {
		visit_count = 1;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Total Number of Hits";

		out.println("<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body>\n" + "<h1 align = \"center\">"
				+ title + "</h1>\n" + "<h2 align = \"center\">" + visit_count++ + "</h2>\n" + "</body> </html>");
	}

}
