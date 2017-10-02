package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;

/**
 * Servlet implementation class Survey
 */
@WebServlet(name="SurveyServlet", urlPatterns = "/survey.info")
public class Survey extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		String absoluteDiskPath = getServletContext().getRealPath("/");
		File file = new File(absoluteDiskPath,"save/SurveyFile.txt");
		FileWriter fw = new FileWriter(file);
		
		fw.write("Name : "+name + System.getProperty("line.separator"));
		fw.write("Address : "+address + System.getProperty("line.separator"));
		if(apt != "")
			fw.write("Apartment : "+apt + System.getProperty("line.separator"));
		fw.write("City : "+city + System.getProperty("line.separator"));
		fw.write("State : "+state+ System.getProperty("line.separator"));
		fw.write("Zipcode : "+zip+ System.getProperty("line.separator"));
		fw.write("Telephone : "+telephone + System.getProperty("line.separator"));
		fw.write("Email: "+email+ System.getProperty("line.separator"));
		fw.write("Blog URL: "+url+ System.getProperty("line.separator"));
		fw.write("Survey Date: "+survey_date+ System.getProperty("line.separator"));
		fw.write("Things you liked about campus : "+campus_things + System.getProperty("line.separator"));
		fw.write("Heard about University from : "+university + System.getProperty("line.separator"));
		fw.write("Your Comments : "+comments+ System.getProperty("line.separator"));
		fw.write("High School Graduation Month and Year : "+gradMonth+" - "+gradYear+ System.getProperty("line.separator"));
		fw.write("Your Recommendation to your Friends : "+recommendation+ System.getProperty("line.separator"));
		fw.write("Data : "+data+ System.getProperty("line.separator"));
		fw.write("Average : "+average+ System.getProperty("line.separator"));
		fw.write("Maximum : "+maximum + System.getProperty("line.separator"));
		fw.close();	
		
		
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
        out.println("<td>"+name+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Address</td>");
        out.println("<td>"+address+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Apartment #</td>");
        out.println("<td>"+apt+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>City</td>");
        out.println("<td>"+city+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>State</td>");
        out.println("<td>"+state+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Zipcode</td>");
        out.println("<td>"+zip+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Telephone/Mobile #</td>");
        out.println("<td>"+telephone+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Email</td>");
        out.println("<td>"+email+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Blog URL</td>");
        out.println("<td>"+url+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Survey Date</td>");
        out.println("<td>"+survey_date+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Things you liked about the campus</td>");
        out.println("<td>"+campus_things+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Heard About the University from</td>");
        out.println("<td>"+university+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Comments</td>");
        out.println("<td>"+comments+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>High Graduation Month and Year</td>");
        out.println("<td>"+gradMonth+"-"+gradYear+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Your recommendation for the university</td>");
        out.println("<td>"+recommendation+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Data</td>");
        out.println("<td>"+data+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Average</td>");
        out.println("<td>"+average+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Maximum</td>");
        out.println("<td>"+maximum+"</td>");
        out.println("</tr>");
        
        out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
