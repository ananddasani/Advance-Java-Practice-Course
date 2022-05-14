/*
 * Design a form to input details of a student and submit the data to a servlet. 
 * 
 * Write code for servlet that will save the entered details as a new record in database table students 
 * with fields (Enrollment_no, Sname, Semester, Mobile_no).
 */

package jdbc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Extract the enrollment, name, sem, mobile given by the user (from form)
		int enrollment = Integer.parseInt(request.getParameter("enrollment"));
		int sem = Integer.parseInt(request.getParameter("sem"));
		String mobile = request.getParameter("mobile");
		String name = request.getParameter("name");

		// ----------------------- JDBC WORK ---------------------------
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String user = "root";
			String pass = "root";
			String url = "jdbc:mysql://localhost:3306/anand";

			String query = "INSERT INTO servlet_jdbc VALUES (Enrollment_no=?, Sname=?, Semester=?, Mobile_no=?)";

			Connection connection = DriverManager.getConnection(url, user, pass);
			PreparedStatement statement = connection.prepareStatement(query);

			// Set the dynamic data into query
			statement.setInt(1, enrollment);
			statement.setString(2, name);
			statement.setInt(3, sem);
			statement.setString(4, mobile);

			int rowsAffetcted = statement.executeUpdate();

			if (rowsAffetcted != 0) {
				System.out.println("Rows Affected :: " + rowsAffetcted);
				//out.println("<h1>Details Inserted</h1>");
				out.println("Enrollment_no = " + enrollment + "<br>Sname = " + name + "<br>Semester = " + sem
						+ "<br>Mobile_no = " + mobile + "<br><br><br> Above Details Inserted into DB :)");
			} else {
				System.out.println("Something went wrong");
				out.println("Something Went Wrong :(");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.println("ERROR :: " + e.getMessage());
		}
	}
}
