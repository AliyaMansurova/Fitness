
<html/>
<head>
    <link rel="stylesheet" href="css/head.css">
    <title>Head</title>
</head>
<body>
<%@ include file="/contant/langInit.jsp"%>
<div class="wrapper">
    <button class="btnhead" name="btn" value="fitnessGuide" type="submit" formmethod="post"><fmt:message key="fitnessGuid"/></button>
    <button class="btnhead" name="btn" value="aboutUs" type="submit" formmethod="post"><fmt:message key="aboutUs"/></button>
    <button class="btnhead" name="btn" value="en_EN" type="submit" formmethod="post">EN</button>
    <button class="btnhead" name="btn" value="ru_RU" type="submit" formmethod="post">RU</button>
    <button class="btnhead" name="btn" value="signIn" type="submit" formmethod="post"><fmt:message key="signIn"/></button>
</div>
<img src="/contant/images/1.jpg" width="100">
</body>
</html>