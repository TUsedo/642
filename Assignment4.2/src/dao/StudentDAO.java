package dao;

import util.Connectivity;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import beans.DataBean;
import beans.StudentBean;

public class StudentDAO {

	Connectivity connect = new Connectivity();

	public void insertData(StudentBean sb, DataBean db) {

		try {
			BufferedWriter bw = connect.getWriter();
			bw.newLine();
			bw.write("Student Record");
			bw.newLine();
			bw.newLine();
			bw.write("Student ID Without G : " + sb.getId());
			bw.newLine();
			bw.write("Name : " + sb.getName());
			bw.newLine();
			bw.write("Address : " + sb.getAddress());
			bw.newLine();
			if (sb.getApt() != "") {
				bw.write("Apartment : " + sb.getApt());
				bw.newLine();
			}
			bw.write("City : " + sb.getCity());
			bw.newLine();
			bw.write("State : " + sb.getState());
			bw.newLine();
			bw.write("Zipcode : " + sb.getZipcode());
			bw.newLine();
			bw.write("Telephone : " + sb.getTelephone());
			bw.newLine();
			bw.write("Email: " + sb.getEmail());
			bw.newLine();
			bw.write("Blog URL: " + sb.getBlog());
			bw.newLine();
			bw.write("Survey Date: " + sb.getSurvey_date());
			bw.newLine();
			bw.write("Things you liked about campus : " + sb.getCampus_liking());
			bw.newLine();
			bw.write("Heard about University from : " + sb.getUniversity());
			bw.newLine();
			bw.write("Your Comments : " + sb.getComments());
			bw.newLine();
			bw.write("High School Graduation Month and Year : " + sb.getGraduation());
			bw.newLine();
			bw.write("Your Recommendation to your Friends : " + sb.getRecommendation());
			bw.newLine();
			bw.write("Data : " + sb.getData());
			bw.newLine();
			bw.write("End of Record");
			bw.newLine();
			bw.close();
		} catch (IOException ex) {
			System.out.println("IOException Occured at inserData StudentDAO" + ex);
		}
	}

	public ArrayList<String> getStudentID() {

		Scanner br = connect.getReader();
		ArrayList<String> sid = new ArrayList<String>();
		String line;
		
		while (br.hasNext()) {
			line = br.nextLine();
			if (line.contains("Student ID Without G")) {
				String[] split = line.split(":");
				sid.add(split[1].trim());
			}
		}
		br.close();
		return sid;
	}

	public StudentBean retrieveData (String student_id) {
	 
		StudentBean sb = new StudentBean();
		Scanner br = connect.getReader();
		String line;
		while (br.hasNext()) {
			line = br.nextLine();
			if (line.contains(student_id)) {
				sb = setBean(br);
				sb.setId(Integer.parseInt(student_id));
			}
		}
		if(sb.getId() == 0)
		 return null;
		else
		 return sb;
	 }
	
	private StudentBean setBean(Scanner br) {
		
		StudentBean sb = new StudentBean();
		sb.setName(splitLine(br.nextLine()));
		sb.setAddress(splitLine(br.nextLine()));
		String line = br.nextLine();
		if(line.contains("Apartment")) {
			sb.setApt(splitLine(line));
			line = br.nextLine();
		}
		sb.setCity(splitLine(line));
		sb.setState(splitLine(br.nextLine()));
		sb.setZipcode(Integer.parseInt(splitLine(br.nextLine())));
		sb.setTelephone(splitLine(br.nextLine()));
		sb.setEmail(splitLine(br.nextLine()));
		sb.setBlog(splitLine(br.nextLine()));
		sb.setSurvey_date(splitLine(br.nextLine()));
		sb.setCampus_liking(splitLine(br.nextLine()));
		sb.setUniversity(splitLine(br.nextLine()));
		sb.setComments(splitLine(br.nextLine()));
		sb.setGraduation(splitLine(br.nextLine()));
		sb.setRecommendation(splitLine(br.nextLine()));
		sb.setData(splitLine(br.nextLine()));
		return sb;
	}
	
	private String splitLine(String line) {
		String[] split = line.split(":");
		return split[1].trim();
	}

}
