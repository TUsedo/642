<%@page import="java.util.ArrayList" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Winner Acknowledgment Page</title>
    </head>
    <body>
        <h1>Thank you for your participation</h1>
         <form name ="survey"  method ="Get" action="/Assignment6.1/survey">
         	<h3>Data Entered by You : ${sb.data} </h3>
            <h3>Average of the above numbers is ${db.mean}</h3> 
            <h3>Standard Deviation of the above numbers is ${db.std}</h3>
         	<h2>Congratulations You have won 2 tickets for the Movie of your Choice!!!!!!!!!!</h2>
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