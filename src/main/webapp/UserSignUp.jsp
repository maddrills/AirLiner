<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 07-02-2023
  Time: 06:26 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link type="text/css" rel="stylesheet" href="stylesz.css">
  <title>Sign Up</title>
</head>

<%!boolean status;%>
<%
  try{
    status = (boolean)request.getAttribute("status");
  }
  catch (Exception e){
    System.out.println("not yet there");
    status = true;
  }
%>
<body>
<nav>
  <h1>New user Sign Up >> <a href="loginUserAdmin.jsp">Home</a></h1>
</nav>
<div>
  <form action="newUser" method="POST">
    <label>NEW user Username : </label>
    <input type="text" name="username" required><br>
    <label>Password : </label>
    <input type="password" name="password" required><br>
    <button type="submit">Sign Up</button>
  </form>
</div>
<% if(!status){%>
<label> Username Taken</label>
<%}request.removeAttribute("status");%>

</body>
</html>
