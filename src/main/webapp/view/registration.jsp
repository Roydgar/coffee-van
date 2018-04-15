<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Registration</h2>
<br>

<form method="post" action="/registration">
    <label for="Username">Username:</label>

    <input type="text" id = "Username" name="username" pattern="^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+['-]?)+$"/>

    <br>

    <label for="Password">Password:</label>

    <input type="password"  id="Password" name="password"/>

    <br>

    <input class="button" type="submit" value="Done">

</form>

</body>
</html>