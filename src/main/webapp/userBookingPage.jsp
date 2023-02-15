<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.prepairedStatements.PrepareStatementz" %>
<%@ page import="com.prepairedStatements.PrepairedStatementGetAllFlightDataByFlightId" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 13-02-2023
  Time: 08:03 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="stylesz.css">
    <title>Booking Page</title>
</head>
<body>
<%!
    ResultSet resultSet,namesOfAirport1,namesOfAirport2;
    String option,airportId,flightId,from,to,date,cost;
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
<nav>
    <%if(sessionUserId == 0){
    response.sendRedirect("loginUserAdmin.jsp");
    %>
    <%}else {%>
    <%try{%>
    <%while (resultSet.next()){
        from = resultSet.getString("fromAir");
        to = resultSet.getString("toAir");
        date = resultSet.getString("date_of_departure");
        cost = resultSet.getString("cost");
    %>
    <h1>Booking Page <label>From: <%=from%> || </label>
        <label>To: <%=to%> ||</label>
        <label>Date: <%=date%></label></h1>
    <%}%>
    <%}catch(Exception e){

    }%>
    <%}%>
</nav>

<%if(sessionUserId == 0){
%>
<%}else {%>
<table>
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Gender</th>
    </tr>
    <tr>
        <form action="confirmThis" method="POST">
            <input type="hidden" value="<%=from%>" name="from">
            <input type="hidden" value="<%=to%>" name="to">
            <input type="hidden" value="<%=date%>" name="date">
            <input type="hidden" value="<%=cost%>" name="cost">
            <td><input type="text" name="passengerName"></td>
            <td><input type="number" name="passengerAge"></td>
            <td>
                <label>M</label>
                <input type="radio" name="gender" id="male" value="male" checked>
                <label>F</label>
                <input type="radio" name="gender" id="femail" value="feMail" checked></td>
            <td><input type="submit" value="Pay Rs <%=cost%>"></td>
        </form>
    </tr>
</table>
<%}%>
</body>
</html>
