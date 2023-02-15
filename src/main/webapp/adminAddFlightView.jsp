<%@ page import="com.prepairedStatements.PreparedStatementGetFlightDataAll" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.prepairedStatements.PrepareStatementz" %>
<%@ page import="com.prepairedStatements.PreparedStatementGetAllAirportNames" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 09-02-2023
  Time: 03:20 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link type="text/css" rel="stylesheet" href="stylesz.css">
  <title>Admin Flight Add</title>
</head>
<%! ResultSet resultSet,namesOfAirport1,namesOfAirport2;

        String option,airportId,flightId,from,to,date,cost;
String sessionUserId;%>

<%HttpSession session1 = request.getSession();
  sessionUserId = (String)session1.getAttribute("Admin_id");%>
<body>
<%if(session1.getAttribute("Admin_id") != null){%>
<nav>
  <h1>Welcome:
    <form method="post" action="logOutAdmin">
    <input type="hidden" value="logOut" name="logOut">
    <input type="submit" value="Logout">
    </form>
  </h1>
</nav>
<%}%>
<%
  response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

  PrepareStatementz preparedStatementGetFlightDataAll = new PreparedStatementGetFlightDataAll();
  PrepareStatementz preparedStatementGetAllAirportNames = new PreparedStatementGetAllAirportNames();
  PrepareStatementz preparedStatementGetAllAirportNames2 = new PreparedStatementGetAllAirportNames();
  try {
    namesOfAirport1 = preparedStatementGetAllAirportNames.resultSet();
    namesOfAirport2 = preparedStatementGetAllAirportNames2.resultSet();
    resultSet = preparedStatementGetFlightDataAll.resultSet();
  } catch (SQLException e) {
    System.out.println("No data");
  }
%>
<%if(session1.getAttribute("Admin_id") != null){%>
<table>
  <tr>
    <th>From</th>
    <th>To</th>
    <th>Date</th>
    <th>cost</th>
  </tr>
  <tr>
      <form action="addNewFlight" method="POST">
        <td>
          <%try{%>
        <select name="from" id="from">
          <option value="none" selected disabled hidden>Select an Option For Source</option>
          <%while (namesOfAirport1.next()){%>
          <%airportId = namesOfAirport1.getString("airport_id");
            option = namesOfAirport1.getString("airport_name");%>
          <option value="<%=airportId%>"><%=option%></option>
          <%}%>
        </select>
        </td>
        <td>
        <select name="to" id="to">
          <option value="none" selected disabled hidden>Select an Option For Destination</option>
          <%while (namesOfAirport2.next()){%>
          <%airportId = namesOfAirport2.getString("airport_id");
            option = namesOfAirport2.getString("airport_name");%>
          <option value="<%=airportId%>"><%=option%></option>
          <%}%>
        </select>
          <%}catch (Exception e){}%>
        </td>
        <td>
          <input type="date" id="flightDate" name="flightDate">
        </td>
        <td>
          <input type="text" id="cost" name="cost">
        </td>
        <td>
          <input type="submit" value="Add to fight">
        </td>
      </form>
  </tr>
</table>
<br>
<br>
<br>
<p> Flights Added </p>
<br>
<table>
  <tr>
    <th>From</th>
    <th>To</th>
    <th>Date</th>
    <th>Price</th>
  </tr>
  <%try{%>
  <%while (resultSet.next()){%>
  <tr>
    <td><%from = resultSet.getString("airFrom");%><%=from%></td>
    <td><%to = resultSet.getString("airTo");%><%=to%></td>
    <td><%date = resultSet.getString("date_of_departure");%><%=date%></td>
    <td><%cost = resultSet.getString("cost");%><%=cost%></td>
  </tr>
  <%}%>
  <%}catch (Exception e){}%>
</table>
<div>
<a href="adminChangePass.jsp"><input type="submit" value="Change Password"></a>
</div>
<%}else {%>
<label>Illegal Forced Entry</label>
<%}%>
</body>
</html>
