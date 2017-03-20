<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>successfulRegistration</title>
    <link rel="stylesheet" href="/css/reg.css">
</head>
<body>
<%@ include file="/head.jsp" %>
<mytag:path path="/successfulRegistration.jsp"/>
<div class="empty"></div>
<div class="sucReg">
    <a class="sucregLabel"><fmt:message key="successReg"/> </a>
    <a href="login.jsp"class="sucregLabel" ><fmt:message key="enter"/> </a>
</div>
</body>
</html>
