<link rel="stylesheet" href="/css/messages.css">
<div class="messagesPanel">
    <a href="/tasks.jsp" class="message-link"><fmt:message key="myTasks"/></a>
    <a href="/myTrainers.jsp" class="message-link"><fmt:message key="myTrainers"/></a>
    <c:choose>
        <c:when test="${sessionScope.containsKey('trainer')}">
            <a href="/mySportsmans.jsp" class="message-link"><fmt:message key="mySportsmans"/></a>
            <a href="/tasksForMySportsmans.jsp" class="message-link"><fmt:message key="tasksFor"/></a>
            <a href="/newTask.jsp" class="message-link"><fmt:message key="newTask"/></a>
        </c:when>
    </c:choose>
</div>

