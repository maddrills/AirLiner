<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 07-02-2023
  Time: 06:29 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="stylesz.css">
    <title>Admin Login</title>
</head>
<body>
<nav>
    <h1>Admin Login >> <a href="loginUserAdmin.jsp">User LogIn</a></h1>
</nav>

<form action="newAdmin" method="POST">
    <label>NEW Admin name : </label>
    <input type="text" name="username" required><br>
    <label>NEW Admin Password : </label>
    <input type="password" name="password" required><br>
    <button type="submit">Create Account</button>
</form>

</body>
</html>
