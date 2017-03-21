<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="myPageHead.jsp" %>
<html>
<head>
    <title>newSportsman</title>
    <link rel="stylesheet" href="/css/tasks.css">
</head>
<body>
<mytag:path path="/newSportsman.jsp"/>
<div class="empty"></div>
<div class="taskPage">
    <%@ include file="tasksPanel.jsp" %>
    <div class="taskList">
        <c:forEach items="${sessionScope.newSportsmans}" var="mySportsman">
            <div class="trainerItem">
                <div class="imgblock"><img class="imgTrainer" src="/contant/images/logo.jpg"></div>
                <div class="textblok">
                    <a href="" class="textItem">${mySportsman.firstName} ${mySportsman.lastName}</a>
                    <div class="textItem">
                        <fmt:message key="rating"/>:${mySportsman.rating}
                    </div>
                    <div class="textItem">
                        <fmt:message key="status"/>:${mySportsman.status_code}
                    </div>
                    <form action="AddTrainingServlet">
                        <button class="btnDelete" name="addSportsman" value="${mySportsman.id}" type="submit"
                                formmethod="get">
                            <fmt:message key="train"/>
                        </button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
