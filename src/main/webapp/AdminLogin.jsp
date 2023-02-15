<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 07-02-2023
  Time: 06:27 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link type="text/css" rel="stylesheet" href="stylesz.css">
  <title>Admin Login</title>
</head>
<body>
<%! String message;%>
<nav>
  <h1>Admin Login >> <a href="loginUserAdmin.jsp">Home</a></h1>
</nav>
<% message = (String)request.getAttribute("Error");%>

<form action="authenticateAdmin" method="POST">
  <label>Admin name : </label>
  <input type="text" name="username" required><br>
  <label>Admin Password : </label>
  <input type="password" name="password" required><br>
  <button type="submit">Login</button><a href="NewAdmin.jsp"> New Admin </a><br>
</form>
<%try{%>
<% if(message != null){%>
<label><%=message%></label>
<%}%>

<%}catch (Exception e){

}%>
</body>
</html>

