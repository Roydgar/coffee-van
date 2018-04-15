<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Edit product</h2>
<br>

<br>

<form method="post" action="/admin-editCoffee">
    <label for="Name">Product name:</label>

    <input type="text" id = "Name" name="name"/>

    <label for="Weight">Product weight:</label>

    <input type="number" id = "Weight" name="weight"/>

    <label for="Price">Product price:</label>

    <input type="number" step="0.01" id = "Price" name="price"/>

    <select name = "state">
        <option value="BEANS" >            Beans   </option>
        <option value="GROUND">            Ground  </option>
        <option value="INSTANT">           Instant </option>
    </select>

    <input class="button" type="submit" value="Done">

</form>

</body>
</html>