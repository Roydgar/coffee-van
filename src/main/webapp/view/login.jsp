
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Login</h2>
<br>

<form method="post" action="/login">
    <label for="Username">Username:</label>

    <input type="text" id = "Username" name="username" pattern="^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+['-]?)+$"/>

    <br>

    <label for="Password">Password:</label>

    <input type="password"  id="Password" name="password"/>

    <br>

    <input class="button" type="submit" value="Login">

</form>

</body>
</html>
