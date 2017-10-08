package dao;

import util.Dbconn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import beans.DataBean;
import beans.StudentBean;

public class StudentDAO {

	Dbconn connect = new Dbconn();
	private Connection con = null;

	public void insertData(StudentBean sb, DataBean db) {

		try {
			con = connect.createDbConnection();
			String query = "insert into survey_data (id, name, address, apt, city, state, zip, telephone,"
					+ "email, url, survey_date, campus, university, comments, graduation, recommendation, data, average, maximum) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstat = con.prepareStatement(query);
			
			pstat.setInt(1,sb.getId());
			pstat.setString(2, sb.getName());
			pstat.setString(3, sb.getAddress());
			if(sb.getApt().equals(""))
				pstat.setNull(4, java.sql.Types.VARCHAR);
			pstat.setString(4, sb.getApt());
			pstat.setString(5, sb.getCity());
			pstat.setString(6, sb.getState());
			pstat.setInt(7, sb.getZipcode());
			pstat.setString(8, sb.getTelephone());
			pstat.setString(9, sb.getEmail());
			pstat.setString(10, sb.getBlog());
			pstat.setString(11, sb.getSurvey_date());
			pstat.setString(12, sb.getCampus_liking());
			pstat.setString(13, sb.getUniversity());
			pstat.setString(14, sb.getComments());
			pstat.setString(15, sb.getGraduation());
			pstat.setString(16, sb.getRecommendation());
			pstat.setString(17, sb.getData());
			pstat.setFloat(18, db.getMean());
			pstat.setInt(19, sb.getMax());
			
			pstat.executeUpdate();			
			con.close();

		} catch (SQLException ex) {
			System.out.println("SQL Exception Occured " + ex);
		}
	}
	
	public StudentBean retrieveData (String student_id) {
		StudentBean sb = new StudentBean();
		try {
			 con = connect.createDbConnection();
			 Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 ResultSet rs = stmt.executeQuery("select * from survey_data where ID ="+student_id);
			 
			 while(rs.next()) {
				 sb.setId(rs.getInt(1));
				 sb.setName(rs.getString(2));
				 sb.setAddress(rs.getString(3));
				 sb.setApt(rs.getString(4));
				 if(!(sb.getApt()!=null))
					 sb.setApt("");
				 sb.setCity(rs.getString(5));
				 sb.setState(rs.getString(6));
				 sb.setZipcode(rs.getInt(7));
				 sb.setTelephone(rs.getString(8));
				 sb.setEmail(rs.getString(9));
				 sb.setBlog(rs.getString(10));
				 sb.setSurvey_date(rs.getString(11));
				 sb.setCampus_liking(rs.getString(12));
				 sb.setUniversity(rs.getString(13));
				 sb.setComments(rs.getString(14));
				 sb.setGraduation(rs.getString(15));
				 sb.setRecommendation(rs.getString(16));	
			 }
			 con.close();
		}
		catch (SQLException ex) {
			System.out.println("SQL Error Occured While Retreiving Info." +ex);
		}
		
	if(sb.getId() == 0)
		return null;
	else
		return sb;
	}

}
