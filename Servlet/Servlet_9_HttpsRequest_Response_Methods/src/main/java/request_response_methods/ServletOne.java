package request_response_methods;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();

		// ----------------- HttpServletRequest Method -------------------

		// getting conecxt path
		printWriter.println("getContextPath(): " + request.getContextPath() + "<br><br>");

		// getting the header files
		Enumeration<String> header = request.getHeaderNames();
		while (header.hasMoreElements()) {

			String h_name = (String) header.nextElement();
			String h_valueString = (String) request.getHeader(h_name);

			printWriter.println(h_name + " : " + h_valueString + "<br>");
		}

		// getting header value
		printWriter.println("<br>host: " + request.getHeader("host") + "<br>");

		// getting query string
		printWriter.println("getQueryString(): " + request.getQueryString() + "<br>");

		// getting servlet path
		printWriter.println("getServletPath(): " + request.getServletPath() + "<br>");

		// getting method
		printWriter.println("getMethod(): " + request.getMethod() + "<br>");

		// ----------------- HttpServletResponse Method -------------------

		// getting character
		printWriter.println("<br><br><br>getCharacterEncoding(): " + response.getCharacterEncoding() + "<br>");

		// getting servlet path
		printWriter.println("setContentType(): " + "<br>");

		// getting method
		printWriter.println("setContentLength(): " + "<br>");
	}

}

/*
 * getContextPath(): /Servlet_9_HttpsRequest_Response_Methods
 * 
 * host : localhost:8080 connection : keep-alive cache-control : max-age=0
 * sec-ch-ua : " Not A;Brand";v="99", "Chromium";v="99", "Google Chrome";v="99"
 * sec-ch-ua-mobile : ?0 sec-ch-ua-platform : "Windows"
 * upgrade-insecure-requests : 1 user-agent : Mozilla/5.0 (Windows NT 10.0;
 * Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51
 * Safari/537.36 sec-fetch-site : none sec-fetch-mode : navigate sec-fetch-user
 * : ?1 sec-fetch-dest : document accept-encoding : gzip, deflate, br
 * accept-language : en-US,en;q=0.9 cookie :
 * Idea-ff088775=6bd8ad11-eff5-4913-97d1-ed81e381ce20
 * 
 * host: localhost:8080 getQueryString(): null getServletPath(): /ServletOne
 * getMethod(): GET
 * 
 * 
 * 
 * getCharacterEncoding(): UTF-8 setContentType(): setContentLength():
 */
