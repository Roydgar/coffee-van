<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Registration</h2>
<br>

<h2><c:out value="${sessionScope.registrationError}"/> </h2>
<br>

<form method="post" action="/registration">
    <label for="Username">Username:</label>

    <input type="text" id = "Username" name="username" pattern="^[a-z0-9_-]{3,16}$"/>

    <br>
    <br>

    <label for="Password">Password:</label>

    <input type="password"  id="Password" name="password" pattern="^[a-z0-9_-]{6,18}$"/>

    <br>
    <br>

    <label for="ConfirmPassword">Confirm: </label>

    <input type="password"  id="ConfirmPassword" name="confirmPassword" pattern="^[a-z0-9_-]{6,18}$"/>

    <br>
    <br>

    <input class="button" type="submit" value="Done">

</form>

</body>
</html>