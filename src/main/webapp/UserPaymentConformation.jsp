<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 15-02-2023
  Time: 04:17 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="stylesz.css">
    <title>Booking Page</title>
</head>
<%!
ResultSet resultSet,namesOfAirport1,namesOfAirport2;
        String gender,passengerAge,passengerName,flightId,from,to,date,cost;
    int sessionUserId;
%>
<%
    HttpSession session1 = request.getSession();
    try{
        sessionUserId = (int)session1.getAttribute("users_id");}
    catch (Exception e){
        sessionUserId = 0;
    }
    resultSet = (ResultSet) request.getAttribute("resultSet");
%>
<body>
    <h1>Welcome AirLiner <a href="index.jsp">Home</a></h1>
</nav>
<%if(sessionUserId == 0){
    response.sendRedirect("loginUserAdmin.jsp");
%>
<%}else {%>

<%
    from = request.getParameter("from");
    to = request.getParameter("to");
    date = request.getParameter("date");
    cost = request.getParameter("cost");
    passengerName = request.getParameter("passengerName");
    passengerAge = request.getParameter("passengerAge");
    gender = request.getParameter("gender");
%>

    <p>Conformed Ticket for</p>
    <table>
        <tr>
            <th>
                from
            </th>
            <th>
                to
            </th>
            <th>
                date
            </th>
            <th>
                cost
            </th>
            <th>
                passengerName
            </th>
            <th>
                passengerAge
            </th>
            <th>
                gender
            </th>
        </tr>
        <tr>
            <td>
                <%=from%>
            </td>
            <td>
                <%=to%>
            </td>
            <td>
                <%=date%>
            </td>
            <td>
                <%=cost%>
            </td>
            <td>
                <%=passengerName%>
            </td>
            <td>
                <%=passengerAge%>
            </td>
            <td>
                <%=gender%>
            </td>
        </tr>
    </table>

<%}%>

</body>
</html>
