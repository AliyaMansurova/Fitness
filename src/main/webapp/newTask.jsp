<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="myPageHead.jsp" %>
<html>
<head></head>
<body>
<%session.setAttribute("path", "/newTask.jsp");%>
<div class="messagePage">
    <%@ include file="tasksPanel.jsp"%>
    <form action="NewTaskServlet" class="messageForm">
        <div class="newMessage">
            <div class="message-itemTo">
                <label class="messageLabelTo"><fmt:message key="to"/>: </label>
                <select class="selectFriends" name="sportsman">
                    <c:forEach items="${sessionScope.mySportsmans}" var="foundProfile">
                        <option value="${foundProfile.id}">${foundProfile.firstName} ${foundProfile.lastName} </option>
                    </c:forEach>
                </select>
            </div>
            <textarea class="textMessage" name="message" value=""/></textarea>
            <button class="btnSend" name="sendTo" type="submit"
                    formmethod="post">
                <fmt:message key="send"/>
            </button>
        </div>
    </form>
</div>
</body>
</html>
