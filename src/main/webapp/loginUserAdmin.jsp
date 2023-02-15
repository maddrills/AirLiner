<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 14-02-2023
  Time: 02:11 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <link type="text/css" rel="stylesheet" href="stylesz.css">
  <title>JSP - Hello World</title>
</head>
<body>
<nav>
  <h1>Welcome AirLiner <a href="index.jsp">Home</a></h1>
</nav>
<form action="authenticate" method="POST">
  <label>Username : </label>
  <input type="text" name="username" required><br>
  <label>Password : </label>
  <input type="password" name="password" required><br>
  <button type="submit">Login</button><a href="UserSignUp.jsp"> Sign up </a><br>
  Admin <a href="AdminLogin.jsp"> Login </a>
</form>
</body>
</html>