<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    Your coffee van!
</head>
<body>

<br>


<form method="post" action="/logout">
    <input type="submit" value="Logout" name="logout"><br>
</form>

<br>
<br>
<br>

Total weight: <c:out value="${requestScope.totalWeight}"/> g.
<br>
Max weight: <c:out value="${requestScope.maxWeight}"/> g.

<br>
<br>

Total price: <c:out value="${requestScope.totalPrice}"/> $

<c:forEach var="coffee" items="${requestScope.order}">
    <ul>

        <li>Name: <c:out value="${coffee.key.name}"/></li>

        <li>Type: <c:out value="${coffee.key.state}"/></li>

        <li>Weight: <c:out value="${coffee.key.weight}"/></li>

        <li>Price : <c:out value="${coffee.key.price}"/></li>

        <li>Count: <c:out value="${coffee.value}"/></li>

        <form method="post" action="/delete-coffee">

            <input type="number"  hidden name="id" value="${coffee.key.id}" />

            <input type="submit" value="Delete" name="ok"><br>

        </form>

    </ul>
    <hr/>

</c:forEach>

</body>
</html>