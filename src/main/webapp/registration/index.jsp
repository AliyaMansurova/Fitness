<%@ page contentType="text/html;charset=UTF-8" language="java" import="Servlets.RegisterServlet"%>
<%@ page import="model.User" %>
<%@ page import="java.util.Collection" %>
<html>
<head>
    <title>registration</title>
</head>
<body>

<h1>Hello World!</h1>
<%
    Collection<User> users = (Collection<User>) request.getAttribute(RegisterServlet.USER);
%>

Это наши пользователи:
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>Date of Birth</th>
    </tr>
    <%
        for (User gun : users) {
    %>
    <tr>
        <td><%=gun.getId()%></td>
        <td><%=gun.getFirstName()%></td>
        <td><%=gun.getDob()%></td>

    </tr>
    <%
        }
    %>
</table>


</body>
</html>
