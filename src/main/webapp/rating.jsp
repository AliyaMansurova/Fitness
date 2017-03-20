<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="myPageHead.jsp" %>
<html>
<head>
    <title>rating</title>
    <link rel="stylesheet" href="/css/friends.css">
</head>
<body>
<mytag:path path="/rating.jsp"/>
<div class="empty"></div>
<div class="friendsList">
    <c:forEach items="${sessionScope.rating}" var="foundProfile">
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
