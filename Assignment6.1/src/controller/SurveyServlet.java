package controller;

import beans.*;
import dao.StudentDAO;
import model.DataProcessor;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SurveyServlet
 */
@WebServlet(name = "SurveyResponse", urlPatterns = { "/survey" })
public class SurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDAO dao = new StudentDAO();
		StudentBean sb = fetchData(request, response);
		DataBean db = processData(sb.getData());
		dao.insertData(sb, db);
		displayAcknoledgement(db,request,response,sb);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sid = request.getParameter("sid");
		StudentDAO dao = new StudentDAO();
		StudentBean sb = dao.retrieveData(sid);
		displayStudentInfo(request, response, sb);
	}
	
	private StudentBean fetchData(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		
		StudentBean sb = new StudentBean();
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String apt = req.getParameter("apartment");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String zip = req.getParameter("zip");
		String telephone = req.getParameter("telephone");
		String email = req.getParameter("email");
		String url = req.getParameter("url");
		String survey_date = req.getParameter("date");
		String[] campus = req.getParameterValues("chkbx");
		String university = req.getParameter("rdbtn");
		String comments = req.getParameter("comments");
		String graduation = req.getParameter("grad-month")+" - "+req.getParameter("grad-year");
		String recommendation = req.getParameter("recommendation");
		String data = req.getParameter("data");
		String maximum = req.getParameter("maximum");
		
		String campus_things = campus[0];
		for(int i=1;i<campus.length;i++)
			campus_things += " - "+campus[i];
		int zipcode = Integer.parseInt(zip);
		int max = Integer.parseInt(maximum);
		
		sb.setId(Integer.parseInt(id));
		sb.setName(name);
		sb.setAddress(address);
		sb.setApt(apt);
		sb.setCity(city);
		sb.setState(state);
		sb.setZipcode(zipcode);
		sb.setTelephone(telephone);
		sb.setEmail(email);
		sb.setBlog(url);
		sb.setSurvey_date(survey_date);
		sb.setCampus_liking(campus_things);
		sb.setUniversity(university);
		sb.setComments(comments);
		sb.setGraduation(graduation);
		sb.setRecommendation(recommendation);
		sb.setRecommendation(recommendation);
		sb.setData(data);
		sb.setMax(max);
		return sb;
	}
	
	private DataBean processData (String input) {
		DataBean db = new DataBean();
		DataProcessor dp = new DataProcessor();
		dp.compute(input);
		db.setMean(dp.getMean());
		db.setStd(dp.getStd());
		
		return db;
	}
	
	private void displayAcknoledgement(DataBean databean, HttpServletRequest req, HttpServletResponse res,StudentBean studentbean) throws ServletException, IOException {
		String address;
		HttpSession session = req.getSession();
		session.setAttribute("db", databean);
		session.setAttribute("sb", studentbean);
		if(databean.getMean() > 90)
			address = "/jsp/WinnerAcknowledgement.jsp";
		else
			address = "/jsp/SimpleAcknowledgement.jsp";
		RequestDispatcher dispatch = req.getRequestDispatcher(address);
		dispatch.forward(req, res);
	}
	
	
	private void displayStudentInfo(HttpServletRequest req, HttpServletResponse res,StudentBean studentbean) throws ServletException, IOException {
		String address;
		HttpSession session = req.getSession();
		session.setAttribute("sb", studentbean);
		if(studentbean !=null) 
			address = "/jsp/Student.jsp";
		else
			address = "/jsp/NoSuchStudent.jsp";
		RequestDispatcher dispatch = req.getRequestDispatcher(address);
		dispatch.forward(req, res);
	}
	

}
