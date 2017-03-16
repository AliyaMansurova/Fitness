<%@ include file="/contant/init/langInit.jsp"%>
<link rel="stylesheet" href="/css/head.css">
<div class="wrapper">
    <form action="/index.jsp">
        <button class="btnhead"  type="submit"><fmt:message key="trainHard"/></button>
    </form>
    <form action="/fitnesGuid.jsp">
        <button class="btnhead"  type="submit"><fmt:message key="fitnessGuid"/></button>
    </form>
    <button class="btnhead" name="btn" value="aboutUs" type="submit" formmethod="post"><fmt:message key="aboutUs"/></button>
    <form action="InitLangServlet">
    <button class="btnhead" name="locale" value="en_EN" type="submit" formmethod="post">EN</button>
    <button class="btnhead" name="locale" value="ru_RU" type="submit" formmethod="post">RU</button>
    </form>
    <c:choose>
    <c:when test="${sessionScope.containsKey('user')}">
        <form action="/step.jsp">
            <button class="btnhead"  type="submit"><fmt:message key="mypage"/></button>
        </form>
        <form action="/SignOutServlet">
            <button class="btnhead"  type="submit" formmethod="post"><fmt:message key="exit"/></button>
        </form>
    </c:when>
    <c:otherwise>
        <form action="/login.jsp">
            <button class="btnhead" name="btn" value="signIn" type="submit" formmethod="post"><fmt:message key="signIn"/></button>
        </form>
    </c:otherwise>
    </c:choose>
</div>
