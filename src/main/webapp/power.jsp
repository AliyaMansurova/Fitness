<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>$Title$</title>
</head>
<body/>
<%@ include file="head.jsp"%>
<% session.setAttribute("path","/power.jsp");%>
<c:choose>
    <c:when test="${sessionScope.locale eq 'ru_RU'}">
        <iframe width=100% height=100% align="center" src="https://www.youtube.com/embed/8EsHWGTj5VE" frameborder="0" allowfullscreen></iframe>
    </c:when>
    <c:when test="${sessionScope.locale eq 'en_EN'}">
        <iframe width=100% height=100% src="https://www.youtube.com/embed/o8Sz21bFFWs" frameborder="0" allowfullscreen></iframe>
    </c:when>
    <c:otherwise>
        <iframe width=100% height=100% src="https://www.youtube.com/embed/o8Sz21bFFWs"  frameborder="0" allowfullscreen></iframe>
    </c:otherwise>
</c:choose>
</body>
</html>