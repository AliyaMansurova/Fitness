<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>login</title>
</head>
<body/>
<%@ include file="/head.jsp"%>
<%session.setAttribute("path","/login.jsp");%>
<form action="/SignInServlet">
<div class="signIn">
    <label class="labelLogin"><fmt:message key="login"/></label>
    <input type="text" class="textLogin" name="email" value="" /><br/>
    <label class="labelLogin"><fmt:message key="password"/></label>
    <input type="password" class="textLogin" name="password" value="" /><br/>
    <button class="btnBody" name="signIn" formmethod="get"><fmt:message key="signIn"/></button>
    <a href="/signUp.jsp" class="labelLogin" ><fmt:message key="signUp"/></a>
</div>
</form>
</body>
</html>
