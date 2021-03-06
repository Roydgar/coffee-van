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

<h2><fmt:message key="addCoffee.title" /></h2>
<br>

<br>

<form method="post" action="/admin-addCoffee">
    <label for="Name"> <fmt:message key="addCoffee.label.name" /> :</label>

    <input type="text" id = "Name" name="name"/>

    <label for="Weight"> <fmt:message key="addCoffee.label.weight" />:</label>

    <input type="number" id = "Weight" name="weight"/>

    <label for="Price"> <fmt:message key="addCoffee.label.price" />:</label>

    <input type="number" step="0.01" id = "Price" name="price"/>

    <select name = "state">
        <option value="BEANS" >           <fmt:message key="addCoffee.option.state.beans" />   </option>
        <option value="GROUND">           <fmt:message key="addCoffee.option.state.ground" />  </option>
        <option value="INSTANT">          <fmt:message key="addCoffee.option.state.instant" /> </option>
    </select>

    <input class="button" type="submit" value="<fmt:message key="addCoffee.button.Done" />">

</form>

</body>
</html>