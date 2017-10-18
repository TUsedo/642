package surveyData;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SavingServlet", urlPatterns = { "/savedinfo" })
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
}

	protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String apt = request.getParameter("apartment");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String url = request.getParameter("url");
		String survey_date = request.getParameter("date");
		String[] campus = request.getParameterValues("chkbx");
		String university = request.getParameter("rdbtn");
		String comments = request.getParameter("comments");
		String gradMonth = request.getParameter("grad-month");
		String gradYear = request.getParameter("grad-year");
		String recommendation = request.getParameter("recommendation");
		String data = request.getParameter("data");
		String average = request.getParameter("average");
		String maximum = request.getParameter("maximum");
		
		
		String campus_things = campus[0];
		for(int i=1;i<campus.length;i++)
			campus_things += " - "+campus[i];
		String graduation = gradMonth +" - "+gradYear;
		int id=0;
		try {
			int currentRow = 0;
			int zipcode = Integer.parseInt(zip);
			float avg = Float.parseFloat(average);
			int max = Integer.parseInt(maximum);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/survey_info","Jay","P@ss1234");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("select * from survey_data");
			if(rs.last())
				currentRow = rs.getRow();
			id = ++currentRow;
			
			
			
			String query = "insert into survey_data (id, name, address, apt, city, state, zip, telephone,"
					+ "email, url, survey_date, campus, university, comments, graduation, recommendation, data, average, maximum) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstat = con.prepareStatement(query);
			
			pstat.setInt(1, id);
			pstat.setString(2, name);
			pstat.setString(3, address);
			if(apt.equals(""))
				pstat.setNull(4, java.sql.Types.VARCHAR);
			else
				pstat.setString(4, apt);
			pstat.setString(5, city);
			pstat.setString(6, state);
			pstat.setInt(7, zipcode);
			pstat.setString(8, telephone);
			pstat.setString(9, email);
			pstat.setString(10, url);
			pstat.setString(11, survey_date);
			pstat.setString(12, campus_things);
			pstat.setString(13, university);
			pstat.setString(14, comments);
			pstat.setString(15, graduation);
			pstat.setString(16, recommendation);
			pstat.setString(17, data);
			pstat.setFloat(18, avg);
			pstat.setInt(19, max);
			
			pstat.executeUpdate();
			con.close();
			
		}
		catch (SQLException | ClassNotFoundException ex) {
			System.out.println("SQL Exception Caught "+ex);
		}
				
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Confirmation Page</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>You have Successfully completed the Survey......<i>Thank You for Time</i></h2>");        
        out.println("<a href=\"/Assignment5.1/survey.info?id="+id+"\">Here is the link to retrieve the data you just Submitted for Your Reference</a>");        
		out.println("</body>");
		out.println("</html>");	
		
	}
}
