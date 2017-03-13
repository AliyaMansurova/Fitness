<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:requestEncoding value="utf-8" />
<c:choose>
    <c:when test="${sessionScope.locale eq 'ru_RU'}">
        <fmt:setLocale value="ru_RU"/>
    </c:when>
    <c:when test="${sessionScope.locale eq 'en_EN'}">
        <fmt:setLocale value="en_EN"/>
    </c:when>
    <c:otherwise>
        <fmt:setLocale value="en_EN"/>
    </c:otherwise>
</c:choose>
<fmt:setBundle basename="local.local"/>
