<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/reg.css">
</head>
<body>
<%@ include file="/head.jsp" %>
<%session.setAttribute("path","/successfulRegistration.jsp");%>
<div class="sucReg">
    <a class="sucregLabel"><fmt:message key="successReg"/> </a>
    <a href="login.jsp"class="sucregLabel" ><fmt:message key="enter"/> </a>

</div>

</body>
</html>
