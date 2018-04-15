<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="show coffee van">
    <a href="${pageContext.request.contextPath}/show-coffee-van">Show coffee van</a>
</div>
<br>
<div class="sort">
    <form method="post" action="/sort-coffees">

        <label>Sort by:</label>

        <select name = "sortBy">
            <option value="name" >           Name</option>
            <option value="weight">          Weight</option>
            <option value="price">           Price </option>
            <option value="price to weight"> Price to Weight</option>
        </select>

        <input type="submit" value="Sort" name="sort"><br>
    </form>
</div>


<div class="search">
    <form method="post" action="/search-coffees">

        <label>Search by:</label>

        <select name = "searchBy">
            <option value="weight">          Weight</option>
            <option value="price">           Price </option>
        </select>

        <br>

        <div class="inputs">

            <label for="from">From</label>
            <input type="number" step="0.01" required value="" name="from" id="from"><br>
            <label for="to">To</label>
            <input type="number" step="0.1" required value="" name="to" id="to"><br>

        </div>

        <input type="submit" value="Search" name="search"><br>
    </form>

    <br>

</div>

<form method="post" action="/show-coffees">
    <button value="reset" name="reset" id="Reset">Reset filters</button>
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


<h1>Coffees available:</h1>

<c:forEach var="coffee" items="${sessionScope.coffees}">
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
</c:forEach>

</body>
</html>
