<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="myPageHead.jsp" %>
<html>
<head>
    <title>searchFriends</title>
    <link rel="stylesheet" href="/css/friends.css">
</head>
<body>
<mytag:path path="/searchFriends.jsp"/>
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
    <c:forEach items="${sessionScope.foundedUsers}" var="foundUsers">
        <div class="friendItem">
            <div class="imgllock"><img class="imgFriend" src="/contant/images/logo.jpg"></div>
            <div class="textblok">
                <a href="" class="textItem">${foundUsers.firstName} ${foundUsers.lastName}</a>
                <div class="textItem">
                    <fmt:message key="rating"/>:${foundUsers.rating}
                </div>
                <div class="textItem">
                    <fmt:message key="status"/>:${foundUsers.status_code}
                </div>
                <form action="AddFriendServlet">
                    <button class="btnDelete" name="addFriend" value="${foundUsers.id}" type="submit"
                            formmethod="get">
                        <fmt:message key="add"/>
                    </button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>

