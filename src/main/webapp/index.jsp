
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty
    language ? language : pageContext.request.locale}" scope="session" />

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="locale" />

<html>
<head>
    <title>Big Black Beans</title>

</head>
<body>

<h1><fmt:message key="index.header" /></h1><br />

<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        <option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
    </select>
</form>


<div class="auth">
    <a href="${pageContext.request.contextPath}/login"><fmt:message key="index.link.login" /></a>

    <br>

    <a href="${pageContext.request.contextPath}/registration"><fmt:message key="index.link.registration" /></a>
</div>

</body>
</html>