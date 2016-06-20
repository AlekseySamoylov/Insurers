<%--
  Created by IntelliJ IDEA.
  User: alekseysamoylov
  Date: 6/19/16
  Time: 7:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Insurers</title>
    <link type="text/css" rel="stylesheet" href="<spring:url value="/resources/css/bootstrap.min.css"/>"/>
</head>
<body>
<jsp:include page="../views/fragments/header.jsp"></jsp:include>
<div class="container">
<h3>Search</h3>

<div class="form-inline">
    <spring:url value="/search" var="searchUrl"/>

    <form:form action="${searchUrl}" method="post" modelAttribute="searchFields">
        <div class="form-group">
            <label for="resource-name">Name</label>
            <form:input path="name" cssClass="form-control" id="resource-name"/>
        </div>
        <div class="form-group">
            <label for="resource-inn">Full INN</label>
            <form:input path="inn" placeholder="не обязательно" cssClass="form-control" id="resource-inn"/>
        </div>
        <button type="submit" class="btn btn-default">Search</button>


    </form:form>
</div>
    <hr>
    <h2>Insurers</h2>
    <div class="container">
    <table class="table table-hover">
        <tbody>
        <tr>
            <th>Name</th>
            <th>Licence</th>
            <th>INN</th>
            <th>OGRN</th>
            <th>Number of branches</th>
        </tr>
        <c:forEach items="${insurers}" var="insurer">
            <tr>
                <td><a href="<spring:url
							value="/insurer/${insurer.insurerId}"/>">${insurer.name}</a></td>
                <td>${insurer.license}</td>
                <td>${insurer.inn}</td>
                <td>${insurer.ogrn}</td>
                <td>${insurer.numberOfBranches}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</div>

<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>
