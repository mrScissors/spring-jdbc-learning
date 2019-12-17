<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Event Management</title>
</head>
<body>
    <h1>Book Event</h1>

<form:form action="/SpringJdbc/newEvent" method="post" modelAttribute="event">
             <table>
                <tr>
                    <td><form:label path="eventTitle">Event Title</form:label></td>
                    <td><form:input path="eventTitle"/></td>
                </tr>
                <tr>
                    <td><form:label path="city">City</form:label></td>
                    <td><form:input path="city"/></td>
                </tr>
                <tr>
                    <td><form:label path="ticketPrice">Ticket Price</form:label></td>
                    <td><form:input path="ticketPrice"/></td>
                </tr>
                 <tr>
                    <td><form:label path="eventType">Event Type</form:label></td>
                    <td><form:input path="eventType"/></td>
                   </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>