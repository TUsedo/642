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
            <tr><td><label> Student ID without G </label></td><td><input name="sid" id ="sid" type="text" size = 30 maxlength= 10  ></input></td></tr>
            <tr><input value ="Submit" type ="submit"></input></tr>
         <h2>Congratulations You have won 2 tickets for the Movie of your Choice!!!!!!!!!!</h2>
        </form>
    </body>
</html>