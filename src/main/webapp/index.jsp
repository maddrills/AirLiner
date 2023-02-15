<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.prepairedStatements.PreparedStatementGetAllAirportNames" %>
<%@ page import="com.prepairedStatements.PrepareStatementz" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="stylesz.css">
    <title>JSP - Hello World</title>
</head>
<body>
<%!
ResultSet resultSet,namesOfAirport3,namesOfAirport4;
        String option,airportId,flightId,from,to,date,cost;
    int sessionUserId;
    PrepareStatementz preparedStatementGetAllAirportNames3 = new PreparedStatementGetAllAirportNames();
    PrepareStatementz preparedStatementGetAllAirportNames4 = new PreparedStatementGetAllAirportNames();
%>
<%
    try {
        namesOfAirport3 = preparedStatementGetAllAirportNames3.resultSet();
        namesOfAirport4 = preparedStatementGetAllAirportNames4.resultSet();
    } catch (SQLException e) {
        System.out.println("No data");
    }


    HttpSession session1 = request.getSession();
    try {
        sessionUserId = (int) session1.getAttribute("users_id");
    }catch (Exception e){
        sessionUserId = 0;
    }
%>
<nav>
    <%if(sessionUserId == 0){%>
    <h1>Welcome AirLiner <a href="loginUserAdmin.jsp">Log In</a></h1>
    <%}else {

    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    %>
    <h1>Welcome AirLiner
        <form method="post" action="logOutUser">
            <input type="hidden" value="logOut" name="logOut">
            <input type="submit" value="Logout">
        </form>
        <br>
    </h1>
    <%}%>
</nav>
<table>
    <tr>
        <th>From</th>
        <th>To</th>
        <th>Date</th>
    </tr>
    <tr>
        <form action="searchFlight" method="POST">
            <td>
                <%try{%>
                <select name="from" id="from">
                    <option value="none" selected disabled hidden>Select an Option For Source</option>
                    <%while (namesOfAirport3.next()){%>
                    <%airportId = namesOfAirport3.getString("airport_id");
                        option = namesOfAirport3.getString("airport_name");%>
                    <option value="<%=airportId%>"><%=option%></option>
                    <%}%>
                </select>
            </td>
            <td>
                <select name="to" id="to">
                    <option value="none" selected disabled hidden>Select an Option For Destination</option>
                    <%while (namesOfAirport4.next()){%>
                    <%airportId = namesOfAirport4.getString("airport_id");
                        option = namesOfAirport4.getString("airport_name");%>
                    <option value="<%=airportId%>"><%=option%></option>
                    <%}%>
                </select>
                <%}catch (Exception e){}%>
            </td>
            <td>
                <input type="date" id="flightDate" name="flightDate">
            </td>
            <td>
                <input type="submit" value="Search For fight">
            </td>
        </form>
    </tr>
</table>

<%try{

    resultSet = (ResultSet)request.getAttribute("flightData");

}catch (Exception e){System.out.println("Exe");}%>


<%if(resultSet != null){%>
<p>Available Flights:</p>
<table>
    <tr>
        <th>From</th>
        <th>To</th>
        <th>Date</th>
        <th>number of passengers</th>
    </tr>

    <%try{%>
    <%while (resultSet.next()){%>
    <tr>
        <%flightId = resultSet.getString("flights_id");%>
        <%from = resultSet.getString("fromAir");%>
        <td><%=from%></td>
        <%to = resultSet.getString("toAir");%>
        <td><%=to%></td>
        <%date = resultSet.getString("date_of_departure");%>
        <td><%=date%></td>
        <td>
            <form method="POST" action="userBooking">
<%--                <input type="number" name="passengers">--%>
                <input type="hidden" value="<%=flightId%>" name="flightId">
                <input type = "submit"value="Book This">
            </form>
        </td>
    </tr>
    <%}%>
    <%}catch (Exception e){
        System.out.println("Exe");
    }%>
    <%}else {%>
    <P> Query for an available flights </P>
    <%}%>
</table>

<%if(sessionUserId == 0){%>
<%}else {%>
<%--<form method="post" action="showHistory">
    <input type="hidden" value="logOut" name="history">
    <input type="submit" value="Show History Of Tickets">
</form>--%>
<%}%>
</body>
</html>