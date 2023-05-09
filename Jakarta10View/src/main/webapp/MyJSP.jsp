<%--
  Created by IntelliJ IDEA.
  User: James
  Date: 09/05/2023
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    for (int i = 0; i < 10; i++) {
%>
<h1><%="Hello " + i %></h1>
<%
    }
%>
</body>
</html>
