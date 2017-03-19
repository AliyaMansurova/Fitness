<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/profile.css">
<%@ include file="head.jsp" %>
<div class="profile">
    <img src="/contant/images/step2.jpg">
</div>
<div class="menu">
    <form action="FriendsServlet">
        <button class="btnMenu" type="submit"><fmt:message key="friends"/></button>
    </form>
    <form action="aboutMe.jsp">
        <button class="btnMenu" type="submit"><fmt:message key="aboutme"/></button>
    </form>
    <form action="MyMissionsServlet">
    <button class="btnMenu" type="submit" name="task" value="/tasks.jsp"><fmt:message key="tasks"/></button>
    </form>
    <form action="MyMissionsServlet">
    <button class="btnMenu" type="submit" name="task" value="/achievments.jsp"><fmt:message key="progress"/></button>
    </form>
    <form action="MessageServlet">
        <button class="btnMenu" type="submit"><fmt:message key="messages"/></button>
    </form>
    <button class="btnMenu" type="submit"><fmt:message key="best"/></button>
</div>

