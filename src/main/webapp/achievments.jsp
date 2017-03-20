<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="myPageHead.jsp" %>
<html>
<head>
    <link rel="stylesheet" href="/css/tasks.css">
    <title>myAchievments</title>
</head>
<body>
<mytag:path path="/achievments.jsp"/>
<div class="empty"></div>
<div class="taskList">
    <c:forEach items="${sessionScope.achievments}" var="achieve">
        <div class="taskItem">
            <div class="imgBlock"><img class="imgTask" src="/contant/images/done.png"></div>
            <div class="textBlok">
                <a href="" class="textItem"><fmt:message key="from"/>:${achieve.id_trainer.firstName} ${achieve.id_trainer.lastName}</a>
                <div class="textItem">${achieve.date}
                </div>
                <div class="textItem">${achieve.mission}</div>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
