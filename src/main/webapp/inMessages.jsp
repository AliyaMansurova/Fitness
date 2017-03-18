<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="myPageHead.jsp" %>
<html>
<head></head>
<body>
<%session.setAttribute("path", "/inMessages.jsp");%>
<div class="messagePage">
    <%@ include file="messagePanel.jsp" %>
    <div class="message">
        <c:forEach items="${sessionScope.inMessages}" var="message">
            <div class="messageItem">
                <div class="imgBlockMessage"><img class="imgFriendMessage" src="/contant/images/logo.jpg"></div>
                <div class="textBlockMessage">
                    <a href="" class="textItem">${message.id_from.firstName} ${message.id_from.lastName}</a>
                    <div class="textItem">
                            ${message.date}
                    </div>
                    <div class="textItem">
                            ${message.message}
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
