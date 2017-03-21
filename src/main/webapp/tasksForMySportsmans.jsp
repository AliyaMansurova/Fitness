<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="myPageHead.jsp" %>
<html>
<head>
    <title>tasksForMySportsmen</title>
    <link rel="stylesheet" href="/css/tasks.css">
</head>
<body>
<mytag:path path="/tasksForMySportsmans.jsp"/>
<div class="empty"></div>
<div class="taskPage">
    <%@ include file="tasksPanel.jsp" %>
    <div class="taskList">
        <c:forEach items="${sessionScope.missionsForMySportsmans}" var="tasks">
            <div class="taskItem">
                <div class="imgBlock"><img class="imgTask" src="/contant/images/do.png"></div>
                <div class="textBlok">
                    <a href="" class="textItem"><fmt:message
                            key="to"/>:${tasks.id_trainer.firstName} ${tasks.id_trainer.lastName}</a>
                    <div class="textItem">${tasks.date}
                    </div>
                    <div class="textItem">${tasks.mission}</div>
                    <div class="row">
                    <form action="DeleteMissionServlet">
                        <button class="btnDelete" name="deleteMission" value="${tasks.id}" type="submit"
                                formmethod="post">
                            <fmt:message key="delete"/>
                        </button>
                    </form>
                    <form action="CompleteMissionServlet">
                        <button class="btnDelete" name="completeMission" value="${tasks.id}" type="submit"
                                formmethod="get">
                            <fmt:message key="complete"/>
                        </button>
                    </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>