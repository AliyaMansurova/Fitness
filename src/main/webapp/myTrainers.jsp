<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="myPageHead.jsp" %>
<html>
<head>
    <title>myTrainers</title>
    <link rel="stylesheet" href="/css/tasks.css">
</head>
<body>
<mytag:path path="/myTrainers.jsp"/>
<div class="empty"></div>
<div class="taskPage">
    <%@ include file="tasksPanel.jsp" %>
    <div class="taskList">
        <c:forEach items="${sessionScope.myTrainers}" var="myTrainer">
            <div class="trainerItem">
                <div class="imgblock"><img class="imgTrainer" src="/contant/images/logo.jpg"></div>
                <div class="textblok">
                    <a href="" class="textItem">${myTrainer.firstName} ${myTrainer.lastName}</a>
                    <div class="textItem">
                        <fmt:message key="rating"/>:${myTrainer.rating}
                    </div>
                    <div class="textItem">
                        <fmt:message key="status"/>:${myTrainer.status_code}
                    </div>
                    <form action="DeleteTrainingServlet">
                        <button class="btnDelete" name="deleteTrainer" value="${myTrainer.id}" type="submit"
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