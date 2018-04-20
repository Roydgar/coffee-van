<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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


<div class="show coffee van">
    <a href="${pageContext.request.contextPath}/show-coffee-van"><fmt:message key="showCoffees.link.showCoffeeVan" /></a>
</div>

<form method="post" action="/logout">
    <input type="submit" value="<fmt:message key="showCoffees.button.logout" />" name="logout"><br>
</form>

<br>
<div class="sort">
    <form method="post" action="/sort-coffees">

        <label><fmt:message key="showCoffees.label.sortBy" /></label>

        <select name = "sortBy">
            <option value="name" >           <fmt:message key="showCoffees.option.SortByName" /></option>
            <option value="weight">          <fmt:message key="showCoffees.option.SortByWeight" /></option>
            <option value="price">           <fmt:message key="showCoffees.option.SortByPrice" /> </option>
            <option value="price to weight"> <fmt:message key="showCoffees.option.SortByPtW" />t</option>
        </select>

        <input type="submit" value="<fmt:message key="showCoffees.button.sort" />" name="sort"><br>
    </form>
</div>


<div class="search">
    <form method="post" action="/search-coffees">

        <label><fmt:message key="showCoffees.label.searchBy" /></label>

        <select name = "searchBy">
            <option value="weight">          <fmt:message key="showCoffees.option.SearchByWeight" /></option>
            <option value="price">           <fmt:message key="showCoffees.option.SearchByPrice" /> </option>
        </select>

        <br>

        <div class="inputs">

            <label for="from">  <fmt:message key="showCoffees.label.from" />   </label>
            <input type="number" step="0.01" required value="" name="from" id="from"><br>
            <label for="to">    <fmt:message key="showCoffees.label.to" />     </label>
            <input type="number" step="0.1" required value="" name="to" id="to"><br>

        </div>

        <input type="submit" value="<fmt:message key="showCoffees.button.search" />" name="search"><br>
    </form>

    <br>

</div>

<form method="post" action="/show-coffees">
    <button value="reset" name="reset" id="Reset"><fmt:message key="showCoffees.button.resetFilters" /></button>
</form>
<h2><c:out value="${requestScope.fullCoffeeVan}"/> </h2>


<%-- <c:set var="letters" scope="session" value="${requestScope.coffees}"/>
<c:set var="totalCount" scope="session" value="${fn:length(coffees)}"/>
<c:set var="perPage" scope="session"  value="${3}"/>
<c:set var="pageStart" value="${param.start}"/>

<c:if test="${empty pageStart or pageStart < 0}">
        <c:set var="pageStart" value="0"/>
</c:if>
<c:if test="${totalCount < pageStart}">
        <c:set var="pageStart" value="${pageStart - perPage}"/>
</c:if>

<a href="?start=${pageStart - perPage}"><<</a>${pageStart + 1} - ${pageStart + perPage}
<a href="?start=${pageStart + perPage}">>></a>

<h1>Coffees available:</h1>

<c:forEach var="coffee" items="${requestScope.coffees}"
           begin="${pageStart}" end="${pageStart + perPage - 1}">
    <ul>

        <li>Name: <c:out value="${coffee.name}"/></li>

        <li>Type: <c:out value="${coffee.state}"/></li>

        <li>Weight: <c:out value="${coffee.weight}"/></li>

        <li>Price: <c:out value="${coffee.price}"/> $</li>

        <form method="post" action="/show-coffees">
            <label for="count">Count to order:</label>
            <br>

            <input type="number" id = "count" name="count" min=0 max=999 value=0
                   required pattern="^(?![0-9]{4,})[0-9]{1,3}$"/></label><br>

            <input type="number"  hidden name="id" value="${coffee.id}" />

            <br>
            <input type="submit" value="Add to the van" name="ok"><br>
        </form>

    </ul>
    <hr/>
</c:forEach> --%>

<c:if test="${sessionScope.user.admin}">
    <form method="post" action="/admin-addCoffee">
        <input type="submit" value="<fmt:message key="showCoffees.button.AddCoffee" />" name="addCoffee"><br>
    </form>

</c:if>

<h1><fmt:message key="showCoffees.header" /></h1>

<c:forEach var="coffee" items="${sessionScope.coffees}">
    <ul>

        <li><fmt:message key="showCoffees.coffee.name" />: <c:out value="${coffee.name}"/></li>

        <li><fmt:message key="showCoffees.coffee.state" />: <c:out value="${coffee.state}"/></li>

        <li><fmt:message key="showCoffees.coffee.weight" />: <c:out value="${coffee.weight}"/></li>

        <li><fmt:message key="showCoffees.coffee.price" />: <c:out value="${coffee.price}"/> $</li>

        <c:if test="${sessionScope.user.admin}">

            <form method="post" action="/admin-removeCoffee">
                <input type="submit" value="<fmt:message key="showCoffees.button.delete" />" name="deleteCoffee"><br>
                <input type="number"  hidden name="id" value="${coffee.id}" />
            </form>

            <form method="post" action="/admin-editCoffee">
                <input type="submit" value="<fmt:message key="showCoffees.button.edit" />" name="editCoffee"><br>
                <input type="number"  hidden name="id" value="${coffee.id}" />
            </form>

        </c:if>

        <form method="post" action="/show-coffees">
            <label for="count"><fmt:message key="showCoffees.label.count" /></label>

            <br>

            <input type="number" id = "count" name="count" min=0 max=999 value=0
                   required pattern="^(?![0-9]{4,})[0-9]{1,3}$"/></label><br>

            <input type="number"  hidden name="id" value="${coffee.id}" />

            <br>
            <input type="submit" value="<fmt:message key="showCoffees.button.addToTheVan" />" name="ok"><br>
        </form>

    </ul>
    <hr/>
</c:forEach>

</body>
</html>
