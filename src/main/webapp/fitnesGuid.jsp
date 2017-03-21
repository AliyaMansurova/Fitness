<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>fitnesGuid</title>
</head>
<body/>
<%@ include file="/head.jsp"%>
<mytag:path path="/fitnesGuid.jsp"/>
<div class="empty"></div>
<div class="fg">
    <div class="fgItem">
        <a href="power.jsp"><img class="img" src="/contant/images/power1.jpg"></a>
        <label class="fgText"><fmt:message key="power"/></label>
    </div>
    <div class="fgItem">
        <a href="interval.jsp"><img class="img" src="/contant/images/interval1.jpg"></a>
        <label class="fgText"><fmt:message key="interval"/></label>
    </div>
    <div class="fgItem">
        <a href="step.jsp"><img class="img" src="/contant/images/step1.jpg"></a>
        <label class="fgText"><fmt:message key="step"/></label>
    </div>
    <div class="fgItem">
        <a href="stretching.jsp"><img class="img" src="/contant/images/stretching1.jpg"></a>
        <label class="fgText"><fmt:message key="stretching"/></label>
    </div>
    <div class="fgItem">
        <a href="pilates.jsp"><img class="img" src="/contant/images/pilates1.jpg"></a>
        <label class="fgText"><fmt:message key="pilates"/></label>
    </div>
</div>
</div>
</body>
</html>