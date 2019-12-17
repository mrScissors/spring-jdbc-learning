
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <html>
     <head>
           <title>Event Registry</title>
     </head>
     <body>
         <div align="center">
             <h1>Event List</h1>
             <h3><a href="addForm">New Contact</a></h3>
             <table border="1">
                 <th>No.
                 </th>
                 <th>EventTitle</th>
                 <th>City</th>
                 <th>TicketPrice</th>
                 <th>EventType</th>


                 <c:forEach var="event" items="${listEvent}">
                 <tr>
                     <td>${event.id}</td>
                     <td>${event.eventTitle}</td>
                     <td>${event.city}</td>
                     <td>${event.ticketPrice}</td>
                     <td>${event.eventType}</td>
                     <td>
                         <a href="editEvent/${event.id}">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                         <a href="deleteEvent/${event.id}">Delete</a>
                     </td>

                 </tr>
                 </c:forEach>
             </table>
         </div>
     </body>
 </html>