<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information Page</title>
    </head>
    <body>
        <h1>Student Information Page</h1>
        <table>
            <caption>Information of the Student Who's Student ID is G00${sb.id} is as follow!!!</caption>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr>
                <td width ="400 px"><label>Student ID</label></td>
                <td><input type ="text" readonly value ="G00${sb.id}" size ="40"></input></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr>
                <td width ="400 px"><label>Name</label></td>
                <td><input type ="text" readonly value ="${sb.name}"size ="40"></input></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr>
                <td width ="400 px"><label>Address</label></td>
                <td><input type ="text" readonly value ="${sb.address}"size ="40"></input></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr>
                <td width ="400 px"><label>Apartment :-</label></td>
                <td><input type ="text" readonly value ="${sb.apt}"size ="40"></input></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr>
                <td width ="400 px"><label>City</label></td>
                <td><input type ="text" readonly value ="${sb.city}"size ="40"></input></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr>
                <td width ="400 px"><label>State</label></td>
                <td><input type ="text" readonly value ="${sb.state}"size ="40"></input></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr>
                <td width ="400 px"><label>ZipCode</label></td>
                <td><input type ="text" readonly value ="${sb.zipcode}"size ="40"></input></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr>
                <td width ="400 px"><label>Phone</label></td>
                <td><input type ="text" readonly value ="${sb.telephone}"size ="40"></input></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr>
                <td width ="400 px"><label>E-Mail</label></td>
                <td><input type ="text" readonly value ="${sb.email}"size ="40"></input></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr>
                <td width ="400 px"><label>Blog URL</label></td>
                <td><input type ="text" readonly value ="${sb.blog}"size ="40"></input></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            
            <tr>
                <td width ="400 px"><label>What you like about the Campus ?</label></td>
                <td><input type ="text" readonly value ="${sb.campus_liking}" size ="40"></input></td>
            </tr>
			<tr><td></td></tr>
            <tr><td></td></tr>
            <tr>
                <td width ="400 px"><label>Survey Date</label></td>
                <td><input type ="text" readonly value ="${sb.survey_date}"size ="40"></input></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr>
                <td width ="400 px"><label>How did you find the university ?</label></td>
                <td><input type ="text" readonly value ="${sb.university}"size ="40"></input></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr>
                <td width ="400 px"><label>Comment's:</label></td>
                <td><input type ="text" readonly value ="${sb.comments}"size ="40"></textarea></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr>
                <td width ="400 px"><label>High School Graduation Date</label></td>
                <td><input type ="text" readonly value ="${sb.graduation}"size ="40"></input></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>            
        </table>
        
        
    </body>
</html>
