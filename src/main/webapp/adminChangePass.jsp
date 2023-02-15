<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 14-02-2023
  Time: 12:55 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String adminId;%>
<html>
<head>
  <link type="text/css" rel="stylesheet" href="stylesz.css">
  <title>ChangePass</title>
</head>
<body>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

  HttpSession session2 = request.getSession(false);

  adminId = (String)session2.getAttribute("Admin_id");%>

<%if( adminId != null){%>
<nav>
  <h1>ChangePass >> <a href="adminAddFlightView.jsp">Cancel Password change</a></h1>
</nav>
<form action="changeAdminPass" method="POST">
  <input type="hidden" value="<%=adminId%>" name="adminId">
  <label>New Password</label>
  <input type="password" name="password">
  <label>Confirm Password</label>
  <input type="password" name="confirmPassword">
  <input type="submit" value="Change Password">
</form>
<%}%>
</body>
</html>
