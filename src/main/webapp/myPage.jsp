<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/profile.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="head.jsp"%>
<% session.setAttribute("path","/myPage.jsp");%>

<div class="profile">
    <img src="/contant/images/step2.jpg">
</div>
<div class="menu">
<button class="btnMenu"  type="submit"><fmt:message key="friends"/></button>
    <button class="btnMenu"  type="submit"><fmt:message key="aboutme"/></button>
    <button class="btnMenu"  type="submit"><fmt:message key="tasks"/></button>
    <button class="btnMenu"  type="submit"><fmt:message key="progress"/></button>
    <button class="btnMenu"  type="submit"><fmt:message key="messages"/></button>
    <button class="btnMenu"  type="submit"><fmt:message key="best"/></button>

</div>
</body>
</html>
