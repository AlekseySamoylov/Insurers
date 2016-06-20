<%--
  Created by IntelliJ IDEA.
  User: alekseysamoylov
  Date: 6/19/16
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Insurer in quarter</title>
    <link type="text/css" rel="stylesheet" href="<spring:url value="/resources/css/bootstrap.min.css"/>"/>
</head>
<body>
<jsp:include page="../views/fragments/header.jsp"></jsp:include>
<div class="container">

    <h2>Indexes in one quarter</h2>

    <h3>Insurer's name: <strong>${concretes[0].insurer.name}</strong></h3>

    <table class="table table-hover">
        <tbody>
        <tr>
            <th>Name</th>
            <th>Value</th>
            <th>Start Period</th>
            <th>End Period</th>
        </tr>
        <c:forEach items="${concretes}" var="concrete">
            <tr>
                <td>
                    <a href="<spring:url value="/graph/${concrete.insurer.insurerId}+${concrete.index.indexId}"/>">${concrete.index.indexName}</a>
                </td>
                <td>${concrete.value}</td>
                <td>${concrete.reportingPeriod.startPeriod}</td>
                <td>${concrete.reportingPeriod.stopPeriod}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>