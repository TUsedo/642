package surveyData;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetrieveServlet
 */
@WebServlet(name = "dataretriever", urlPatterns = { "/survey.info" })
public class RetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		handleRequest(request, response);
	}

	protected void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		String pvalue = request.getParameter("id");
		int id = Integer.parseInt(pvalue);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/survey_info", "Jay", "P@ss1234");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("select * from survey_data where id =" + id);

			while (rs.next()) {
				String name = rs.getString(2);
				String address = rs.getString(3);
				String apt = rs.getString(4);
				if(!(apt!= null))
					apt = "";				
				String city = rs.getString(5);
				String state = rs.getString(6);
				int zip = rs.getInt(7);
				String telephone = rs.getString(8);
				String email = rs.getString(9);
				String url = rs.getString(10);
				String survey_date = rs.getString(11);
				String campus_things = rs.getString(12);
				String university = rs.getString(13);
				String comments = rs.getString(14);
				String graduation = rs.getString(15);
				String recommendation = rs.getString(16);
				String data = rs.getString(17);
				float average = rs.getFloat(18);
				int maximum = rs.getInt(19);

				con.close();

				PrintWriter out = response.getWriter();

				out.println("<html>");
				out.println("<head>");
				out.println("<title>Confirmation Page</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>You have Successfully completed the Survey......<i>Thank You</i></h2>");
				out.println("<strong>Here is the Information that you have submitted for Your Records</strong>");
				out.println("<table border=\"1\">");

				out.println("<tr>");
				out.println("<td><b>Form Fields</b></td>");
				out.println("<td><b>Form Fields Values</b></td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Full Name</td>");
				out.println("<td>" + name + "</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Address</td>");
				out.println("<td>" + address + "</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Apartment #</td>");
				out.println("<td>" + apt + "</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>City</td>");
				out.println("<td>" + city + "</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>State</td>");
				out.println("<td>" + state + "</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Zipcode</td>");
				out.println("<td>" + zip + "</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Telephone/Mobile #</td>");
				out.println("<td>" + telephone + "</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Email</td>");
				out.println("<td>" + email + "</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Blog URL</td>");
				out.println("<td>" + url + "</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Survey Date</td>");
				out.println("<td>" + survey_date + "</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Things you liked about the campus</td>");
				out.println("<td>" + campus_things + "</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Heard About the University from</td>");
				out.println("<td>" + university + "</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Comments</td>");
				out.println("<td>" + comments + "</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>High Graduation Month and Year</td>");
				out.println("<td>" + graduation + "</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Your recommendation for the university</td>");
				out.println("<td>" + recommendation + "</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Data</td>");
				out.println("<td>" + data + "</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Average</td>");
				out.println("<td>" + average + "</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Maximum</td>");
				out.println("<td>" + maximum + "</td>");
				out.println("</tr>");

				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
			}

		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("SQL Exception Caught " + ex);
		}
	}
}
