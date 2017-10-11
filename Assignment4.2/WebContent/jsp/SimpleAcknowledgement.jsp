<%@page import="java.util.ArrayList"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Acknowledgement for Survey Page</title>
	</head>
	<body>
		<h2>Thank you for your participation</h2>
        <form name ="survey"  method ="Get" action="/Assignment6.1/survey">
         	<h3>Data Entered by You : ${sb.data} </h3>
            <h3>Average of the above numbers is ${db.mean}</h3> 
            <h3>Standard Deviation of the above numbers is ${db.std}</h3>
            <ul>
            <%
            	ArrayList<String> sid = new ArrayList<String>();
            	sid = (ArrayList<String>)session.getAttribute("sid");
            	for(String s_id : sid) {
            		out.println("<li><a href=\"/Assignment4.2/survey?sid="+s_id+"\">Link to Retrieve Data for the Student with Student ID :- "+s_id+"</a>");
            		out.println("");
            	}
            	
            %>
            </ul>
            
        </form>
	</body>
</html>