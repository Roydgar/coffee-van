<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty
    language ? language : pageContext.request.locale}" scope="session" />

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="locale" />

<html>
<head>
    <title>Title</title>
    <fmt:message key="showCoffeeVan.title" />
</head>
<body>

<br>


<form method="post" action="/logout">
    <input type="submit" value="<fmt:message key="showCoffeeVan.button.logout" />" name="logout"><br>
</form>

<br>
<a href="${pageContext.request.contextPath}/show-coffees"><fmt:message key="showCoffeeVan.link.toCatalog" /></a>

<br>
<br>

<div class="orderInfo">
    <label> <fmt:message key="showCoffeeVan.label.totalWeight" />: <c:out value="${requestScope.totalWeight}"/> g. </label>
    <br>

    <label> <fmt:message key="showCoffeeVan.label.maxWeight" />: <c:out value="${requestScope.maxWeight}"/> g. </label>

    <br>
    <br>

    <label> <fmt:message key="showCoffeeVan.label.totalPrice" />: <c:out value="${requestScope.totalPrice}"/> $ </label>
</div>

<c:forEach var="coffee" items="${requestScope.order}">
    <ul>

        <li><fmt:message key="showCoffeeVan.coffee.name" />: <c:out value="${coffee.key.name}"/></li>

        <li><fmt:message key="showCoffeeVan.coffee.state" />: <c:out value="${coffee.key.state}"/></li>

        <li><fmt:message key="showCoffeeVan.coffee.weight" />: <c:out value="${coffee.key.weight}"/></li>

        <li><fmt:message key="showCoffeeVan.coffee.price" /> : <c:out value="${coffee.key.price}"/></li>

        <li><fmt:message key="showCoffeeVan.coffee.count" />: <c:out value="${coffee.value}"/></li>

        <form method="post" action="/delete-coffee">

            <input type="number"  hidden name="id" value="${coffee.key.id}" />

            <input type="submit" value="<fmt:message key="showCoffeeVan.button.delete" />" name="ok"><br>

        </form>

    </ul>
    <hr/>

</c:forEach>

</body>
</html>