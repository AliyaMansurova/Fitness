<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/friends.css">
<% session.setAttribute("path", "/friends.jsp");%>
<%@ include file="myPageHead.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="searchFriends">
    <form action="SearchFriendsServlet">
        <input type="text" class="textSearch" name="firstName" value="" pattern="[A-Za-zА-Яа-яЁё]{1,50}"/>
        <input type="text" class="textSearch" name="lastName" value="" pattern="[A-Za-zА-Яа-яЁё]{1,50}"/>
        <select class="selectSearch" name="gender">
            <option value="Unknown" selected></option>
            <option value="Male"><fmt:message key="male"/></option>
            <option value="Female"><fmt:message key="female"/></option>
        </select>
        <button class="btnSearch" name="searchFriends" type="submit" formmethod="get"><fmt:message key="find"/></button>
    </form>
</div>
<div class="friendsList">
    <c:forEach items="${sessionScope.friends}" var="foundProfile">
        <div class="friendItem">
            <div class="imgBlock"><img class="imgFriend" src="/contant/images/logo.jpg"></div>
            <div class="textblok">
                <a href="" class="textItem">${foundProfile.firstName} ${foundProfile.lastName}</a>
                <div class="textItem">
                    <fmt:message key="rating"/>:${foundProfile.rating}
                </div>
                <div class="textItem">
                    <fmt:message key="status"/>:${foundProfile.status_code}
                </div>
                <div class="row">
                    <form action="DeleteFriendServlet">
                        <button class="btnDelete" name="deleteFriend" value="${foundProfile.id}" type="submit"
                                formmethod="get">
                            <fmt:message key="delete"/>
                        </button>
                    </form>
                    <c:if test="${sessionScope.containsKey('trainer')}">
                        <form action="AddTrainingServlet">
                        <button class="btnDelete" name="addSportsman" value="${foundProfile.id}" type="submit"
                                formmethod="get">
                            <fmt:message key="train"/>
                        </button>
                        </form>
                    </c:if>
                </div>

            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
