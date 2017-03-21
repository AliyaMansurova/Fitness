<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>signUp</title>
    <link rel="stylesheet" href="/css/reg.css">
</head>
<body>
<%@ include file="/head.jsp" %>
<mytag:path path="/signUp.jsp"/>
<label class="reg"><fmt:message key="registration"/></label>
<c:if test="${sessionScope.containsKey('freeLogin')}">
            <span class="loginNotFree">
                <fmt:message key="loginNotFree"/>
            </span>
</c:if>
<form action="RegisterServlet" method="get">
    <div class="signUp">
        <div class="registr-item">
            <label class="labelReg"><fmt:message key="firstName"/>:</label>
            <input type="text" class="textVal" name="firstName" required="required" pattern="[A-Za-zА-Яа-яЁё-]{2,50}"/>
        </div>
        <div class="registr-item">
            <label class="labelReg"><fmt:message key="lastName"/>:</label>
            <input type="text" class="textVal" name="lastName" required="required" pattern="[A-Za-zА-Яа-яЁё-]{2,50}"/>
        </div>
        <div class="registr-item">
            <label class="labelReg"><fmt:message key="patronymic"/>:</label>
            <input type="text" class="textReg" name="patronymic" value="" pattern="[A-Za-zА-Яа-яЁё-]{2,255}"/>
        </div>
        <div class="registr-item">
            <label class="labelReg"><fmt:message key="gender"/>:</label>
            <select class="selectText" name="gender">
                <option  value="Unknown"></option>
                <option  value="Male"><fmt:message key="male"/></option>
                <option  value="Female"><fmt:message key="female"/></option>
            </select>
        </div>
        <div class="registr-item">
            <label class="labelReg"><fmt:message key="dob"/>:</label>
            <input type="date" max="2017-01-01" min="1910-01-01" class="textVal" name="dob" value="2000-01-01"/>
        </div>
        <div class="registr-item">
            <label class="labelReg"><fmt:message key="telephone"/>:</label>
            <input type="tel"  class="textVal" name="telephone" required="required" pattern="[0-9]{6,11}" placeholder="89650001122" />
        </div>
        <div class="registr-item">
            <label class="labelReg"><fmt:message key="email"/>:</label>
            <input type="email" class="textVal" name="email" required="required" pattern="[0-9a-zA-Z_]+@[0-9a-zA-Z_]+[/.][a-z]{2,3}"/>
        </div>
        <div class="registr-item">
            <label class="labelReg"><fmt:message key="password"/>:</label>
            <input type="password" class="textVal" name="password" required="required"/>
        </div>
        <div class="registr-item">
            <label class="labelReg"><fmt:message key="height"/>:</label>
            <input type="text" class="textReg" name="height" value="" pattern="[0-9]{0,3}[/.][0-9]{0,3}" placeholder="170.0"/>
        </div>
        <div class="registr-item">
            <label class="labelReg"><fmt:message key="weight"/>:</label>
            <input type="text" class="textReg" name="weight" value="" pattern="[0-9]{0,3}[/.][0-9]{0,3}" placeholder="50.5"/>
        </div>
        <div class="registr-item">
            <label class="labelReg"><fmt:message key="country"/>:</label>
            <input type="text" class="textReg" name="country" value="" pattern="[A-Za-zА-Яа-яЁё\s]{2,60}"/>
        </div>
        <div class="registr-item">
            <label class="labelReg"><fmt:message key="city"/>:</label>
            <input type="text" class="textReg" name="city" value="" pattern="[A-Za-zА-Яа-яЁё\s-]{2,60}"/>
        </div>
        <div class="registr-item">
            <label class="labelReg"><fmt:message key="status"/>:</label>
            <select class="selectText" name="status">
                <option value="Unknown"></option>
                <option  value="Sportsman"><fmt:message key="sportsman"/></option>
                <option  value="Trainer"><fmt:message key="trainer"/></option>
            </select>
        </div>
        <button class="btnBody" name="signUp" formmethod="get"><fmt:message key="signUp"/></button>
    </div>
</form>
</body>
</html>