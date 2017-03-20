<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/profile.css">
<%@ include file="head.jsp" %>
<div class="profile">
        <c:choose>
        <c:when test="${sessionScope.containsKey('friendInf')}">
        </c:when>
        <c:otherwise>
        <div class="imgBlockProfile"><img class="imgProfile" src="/contant/images/logo.jpg"></div>
        <div class="textblok">
            <div class="textName">${sessionScope.user.firstName} ${sessionScope.user.lastName}</div>
            <div class="textItem">
                <fmt:message key="rating"/>:${sessionScope.user.rating}
            </div>
            <div class="textItem">
                <fmt:message key="status"/>:${sessionScope.user.status_code}
            </div>
            <div class="textItem">
                <fmt:message key="dob"/>:${sessionScope.user.dob}
            </div>
            <div class="textItem">
                <fmt:message key="country"/>:${sessionScope.user.country}
            </div>
            <div class="textItem">
                <fmt:message key="city"/>:${sessionScope.user.city}
            </div>
            <div class="textItem">
                <fmt:message key="height"/>:${sessionScope.user.height}
            </div>
            <div class="textItem">
                <fmt:message key="weight"/>:${sessionScope.user.weight}
            </div>
            </c:otherwise>
            </c:choose>
        </div>
</div>
<div class="menu">
    <form action="friends.jsp">
        <button class="btnMenu" type="submit"><fmt:message key="friends"/></button>
    </form>
    <form action="aboutMe.jsp">
        <button class="btnMenu" type="submit"><fmt:message key="aboutme"/></button>
    </form>
    <form action="MyMissionsServlet">
        <button class="btnMenu" type="submit" name="task" value="/tasks.jsp"><fmt:message key="tasks"/></button>
    </form>
    <form action="MyMissionsServlet">
        <button class="btnMenu" type="submit" name="task" value="/achievments.jsp"><fmt:message
                key="progress"/></button>
    </form>
    <form action="MessageServlet">
        <button class="btnMenu" type="submit"><fmt:message key="messages"/></button>
    </form>
    <form action="rating.jsp">
        <button class="btnMenu" type="submit"><fmt:message key="best"/></button>
    </form>
</div>

