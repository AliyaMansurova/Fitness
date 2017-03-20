<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="myPageHead.jsp" %>
<html>
<head>
    <link rel="stylesheet" href="/css/aboutMe.css">
</head>
<body>
<%session.setAttribute("path","/aboutMe.jsp");%>
<c:if test="${sessionScope.containsKey('freeLogin')}">
            <span class="loginNotFree">
                <fmt:message key="loginNotFree"/>
            </span>
</c:if>
<c:if test="${sessionScope.containsKey('edited')}">
            <span class="loginNotFree">
                <fmt:message key="edited"/>
            </span>
</c:if>
<form action="EditServlet" method="get">
    <div class="Information">
        <div class="inf-item">
            <label class="labelInf"><fmt:message key="firstName"/>:</label>
            <input type="text" class="textInf" name="firstName" value="${sessionScope.firstName}" required="required"
                   pattern="[A-Za-zА-Яа-яЁё]{2,50}"/>
        </div>
        <div class="inf-item">
            <label class="labelInf"><fmt:message key="lastName"/>:</label>
            <input type="text" class="textInf" name="lastName" value="${sessionScope.lastName}" required="required"
                   pattern="[A-Za-zА-Яа-яЁё]{2,50}"/>
        </div>
        <div class="inf-item">
            <label class="labelInf"><fmt:message key="patronymic"/>:</label>
            <input type="text" class="textInf" name="patronymic" value="${sessionScope.patronymic}"
                   pattern="[A-Za-zА-Яа-яЁё]{2,255}"/>
        </div>
        <div class="inf-item">
            <label class="labelInf"><fmt:message key="gender"/>:</label>
            <c:choose>
                <c:when test="${sessionScope.gender eq 'Unknown'}">
                    <select class="selectInf" name="gender">
                        <option value="Unknown" selected></option>
                        <option value="Male"><fmt:message key="male"/></option>
                        <option value="Female"><fmt:message key="female"/></option>
                    </select>
                </c:when>
                <c:when test="${sessionScope.gender eq 'Male'}">
                    <select class="selectInf" name="gender">
                        <option value="Unknown"></option>
                        <option value="Male" selected><fmt:message key="male"/></option>
                        <option value="Female"><fmt:message key="female"/></option>
                    </select>
                </c:when>
                <c:when test="${sessionScope.gender eq 'Female'}">
                    <select class="selectInf" name="gender">
                        <option value="Unknown"></option>
                        <option value="Male"><fmt:message key="male"/></option>
                        <option value="Female" selected><fmt:message key="female"/></option>
                    </select>
                </c:when>
            </c:choose>
        </div>
        <div class="inf-item">
            <label class="labelInf"><fmt:message key="dob"/>:</label>
            <input type="date" max="2017-01-01" min="1910-01-01" class="textInf" name="dob"
                   value="${sessionScope.dob}"/>
        </div>
        <div class="inf-item">
            <label class="labelInf"><fmt:message key="height"/>:</label>
            <input type="text" class="textInf" name="height" value="${sessionScope.height}"
                   pattern="[0-9]{0,3}[/.][0-9]{0,3}"/>
        </div>
        <div class="inf-item">
            <label class="labelInf"><fmt:message key="weight"/>:</label>
            <input type="text" class="textInf" name="weight" value="${sessionScope.weight}"
                   pattern="[0-9]{0,3}[/.][0-9]{0,3}"/>
        </div>
        <div class="inf-item">
            <label class="labelInf"><fmt:message key="country"/>:</label>
            <input type="text" class="textInf" name="country" value="${sessionScope.country}"
                   pattern="[A-Za-zА-Яа-яЁё\s]{2,60}"/>
        </div>
        <div class="inf-item">
            <label class="labelInf"><fmt:message key="city"/>:</label>
            <input type="text" class="textInf" name="city" value="${sessionScope.city}"
                   pattern="[A-Za-zА-Яа-яЁё\s]{2,60}"/>
        </div>
        <div class="inf-item">
            <label class="labelInf"><fmt:message key="status"/>:</label>
            <c:choose>
                <c:when test="${sessionScope.status eq 'Unknown'}">
                    <select class="selectInf" name="status">
                        <option value="Unknown" selected></option>
                        <option value="Sportsman"><fmt:message key="sportsman"/></option>
                        <option value="Trainer"><fmt:message key="trainer"/></option>
                    </select>
                </c:when>
                <c:when test="${sessionScope.status eq 'Sportsman'}">
                    <select class="selectInf" name="status">
                        <option value="Unknown"></option>
                        <option value="Sportsman" selected><fmt:message key="sportsman"/></option>
                        <option value="Trainer"><fmt:message key="trainer"/></option>
                    </select>
                </c:when>
                <c:when test="${sessionScope.status eq 'Trainer'}">
                    <select class="selectInf" name="status">
                        <option value="Unknown"></option>
                        <option value="Sportsman"><fmt:message key="sportsman"/></option>
                        <option value="Trainer" selected><fmt:message key="trainer"/></option>
                    </select>
                </c:when>
            </c:choose>
        </div>
        <div class="inf-item">
            <label class="labelInf"><fmt:message key="city"/>:</label>
            <input type="text" class="textInf" name="city" value="${sessionScope.city}"
                   pattern="[A-Za-zА-Яа-яЁё\s]{2,60}"/>
        </div>
        <div class="inf-item">
            <label class="labelInf"><fmt:message key="telephone"/>:</label>
            <input type="tel" class="textInf" name="telephone" value="${sessionScope.telephone}" required="required"
                   pattern="[0-9]{6,11}" placeholder="89650001122"/>
        </div>
        <div class="inf-item">
            <label class="labelInf"><fmt:message key="email"/>:</label>
            <input type="email" class="textInf" name="email" value="${sessionScope.email}" required="required"
                   pattern="[0-9a-zA-Z_]+@[0-9a-zA-Z_]+[/.][a-z]{2,3}"/>
        </div>
        <div class="inf-item">
            <label class="labelInf"><fmt:message key="password"/>:</label>
            <input type="password" class="textInf" name="password" value="${sessionScope.password}"
                   required="required"/>
        </div>
        <button class="btnInf" name="save" formmethod="get"><fmt:message key="save"/></button>
    </div>
</form>
</body>
</html>
