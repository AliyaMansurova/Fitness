<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/friends.css">
<% session.setAttribute("path","/rating.jsp");%>
<%@ include file="myPageHead.jsp" %>
<html>
<head>
</head>
<body>
<div class="friendsList">
    <c:forEach items="${sessionScope.friends}" var="foundProfile">
        <div class="friendItem">
            <div class="imgBlock"><img class="imgFriend" src="/contant/images/logo.jpg"></div>
            <div class="textblok">
                <a href="" class="textItem">${foundProfile.firstName} ${foundProfile.lastName}</a>
                <div class="textItem">
                    <fmt:message key="rating"/>:${foundProfile.rating}
                </div>
                <div class="textItem">
                    <fmt:message key="status"/>:${foundProfile.status_code}
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
