/*
 * Write a Java Servlet to print BE Semester Marksheet of entered enrollment number and semester no by student using JDBC.
 */
package servlet_jdbc;

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

import com.mysql.cj.jdbc.Driver;

public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		// Extract the Enrollment number and sem given by the student (from form)
		String enrollmentString = request.getParameter("enrollment");
		String semString = request.getParameter("sem");

		int enrollment = Integer.parseInt(enrollmentString);
		int sem = Integer.parseInt(semString);

		// ----------------------- JDBC WORK ---------------------------
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String user = "root";
			String pass = "root";
			String url = "jdbc:mysql://localhost:3306/anand";

			String query = "SELECT * from student_management where Id=? and Sem=?";

			Connection connection = DriverManager.getConnection(url, user, pass);

			PreparedStatement statement = connection.prepareStatement(query);

			statement.setInt(1, enrollment);
			statement.setInt(2, sem);

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				String fName = resultset.getString("Firstname");
				String lName = resultset.getString("LastName");
				int semester = resultset.getInt("Sem");
				int marks = resultset.getInt("Marks");
				String city = resultset.getString("City");

				//Console Printing 
				System.out.println("First Name :: " + fName + "\nLast Name :: " + lName + "\nMarks :: " + "Sem :: "
						+ semester + marks + "\nCity :: " + city);
				
//				out.println("First Name :: " + fName + "\nLast Name :: " + lName + "\nMarks :: " + "Sem :: "
//						+ semester + marks + "\nCity :: " + city);
				
				//HTML Page Printing
				String heading = "First Name :: " + fName + "<br>Last Name :: " + lName + "<br>Marks :: " + marks + "<br>Sem :: "
						+ semester + "<br>City :: " + city;
				
				out.println("<br>");
				out.println("<h1>" + heading + "</h1>");
			}

		} catch (Exception e) {
			out.println("ERROR :: " + e.getMessage());
			e.printStackTrace();
		}

	}
}

/*
 * This Table named 'studetn_management' is already created in my Database named
 * 'anand'

+----+-----------+----------+------+-------+-----------+
| Id | FirstName | LastName | Sem  | Marks | City      |
+----+-----------+----------+------+-------+-----------+
|  1 | Jay       | Dabhi    |    7 |    60 | Mumbai    |
|  2 | Deep      | Singh    |    7 |    60 | Goa       |
|  3 | Mihir     | Samani   |    5 |    85 | Pune      |
|  4 | Sia       | Joshi    |    7 |    50 | Mumbai    |
|  5 | Hetavi    | Dasani   |    7 |    90 | Porbandar |
|  6 | Anand     | Dasani   |    6 |    90 | Porbandar |
|  7 | Ria       | Joshi    |    8 |    60 | Jaipur    |
+----+-----------+----------+------+-------+-----------+

 */