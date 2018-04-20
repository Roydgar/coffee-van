
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

<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        <option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
    </select>
</form>

<h2><fmt:message key="login.header" /></h2>
<br>

<h2><c:out value="${sessionScope.loginError}"/> </h2>
<br>

<form method="post" action="/login">
    <label for="Username"><fmt:message key="login.label.username" /></label>

    <input type="text" id = "Username" name="username" pattern="^[a-z0-9_-]{3,16}$"/>

    <br>

    <label for="Password"><fmt:message key="login.label.password" /></label>

    <input type="password"  id="Password" name="password"/>

    <br>

    <input class="button" type="submit" value="<fmt:message key="login.button.confirm" />">

</form>

<br>
<a href="${pageContext.request.contextPath}/registration"><fmt:message key="login.link.registration" /></a>

</body>
</html>
