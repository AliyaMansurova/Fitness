<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="myPageHead.jsp" %>
<html>
<head>
    <title>outMessages</title>
</head>
<body>
<mytag:path path="/outMessages.jsp"/>
<div class="empty"></div>
<div class="messagePage">
    <%@ include file="messagePanel.jsp" %>
    <div class="message">
        <c:forEach items="${sessionScope.outMessages}" var="message">
            <div class="messageItem">
                <div class="imgBlockMessage"><img class="imgFriendMessage" src="/contant/images/logo.jpg"></div>
                <div class="textBlockMessage">
                    <a href="" class="textItem">${message.id_to.firstName} ${message.id_to.lastName}</a>
                    <div class="textItem">
                            ${message.date}
                    </div>
                    <div class="textItem">
                            ${message.message}
                    </div>
                    <form action="DeleteMessageServlet">
                        <button class="btnDelete" name="deleteMessage" value="${message.id}" type="submit" formmethod="get">
                        <fmt:message key="delete"/>
                        </button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>