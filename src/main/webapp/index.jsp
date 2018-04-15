
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<h1>Hello, friend! Welcome to the Coffee Shop "Big Black Beans"</h1><br />

<div class="auth">
    <a href="${pageContext.request.contextPath}/login">Login</a>

    <br>

    <a href="${pageContext.request.contextPath}/registration">Registration</a>
</div>

</body>
</html>