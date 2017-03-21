<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="myPageHead.jsp" %>
<html>
<head>
    <title>tasks</title>
    <link rel="stylesheet" href="/css/tasks.css">
</head>
<body>
<mytag:path path="/tasks.jsp"/>
<div class="empty"></div>
<div class="taskPage">
    <%@ include file="tasksPanel.jsp" %>
    <div class="taskList">
        <c:forEach items="${sessionScope.tasks}" var="tasks">
            <div class="taskItem">
                <div class="imgBlock"><img class="imgTask" src="/contant/images/do.png"></div>
                <div class="textBlok">
                    <a href="" class="textItem"><fmt:message
                            key="from"/>:${tasks.id_sportsman.firstName} ${tasks.id_sportsman.lastName}</a>
                    <div class="textItem">${tasks.date}
                    </div>
                    <div class="textItem">${tasks.mission}</div>
                    <form action="DeleteMissionServlet">
                        <button class="btnDelete" name="deleteMission" value="${tasks.id}" type="submit"
                                formmethod="get">
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
