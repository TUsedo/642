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
            <tr><td><label> Student ID without G </label></td><td><input name="sid" id ="sid" type="text" size = 30 maxlength= 10></input></td></tr>
            <tr><input value ="Submit" type ="submit"></input></tr>
        </form>
	</body>
</html>