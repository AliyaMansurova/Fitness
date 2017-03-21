<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="myPageHead.jsp" %>
<html>
<head>
    <title>mySportsmans</title>
    <link rel="stylesheet" href="/css/tasks.css">
</head>
<body>
<mytag:path path="/mySportsmans.jsp"/>
<div class="empty"></div>
<div class="taskPage">
    <%@ include file="tasksPanel.jsp" %>
    <div class="taskList">
        <c:forEach items="${sessionScope.mySportsmans}" var="mySportsman">
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
                    <form action="DeleteTrainingServlet">
                        <button class="btnDelete" name="deleteSportsman" value="${mySportsman.id}" type="submit"
                                formmethod="post">
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