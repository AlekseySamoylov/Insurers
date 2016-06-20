<%--
  Created by IntelliJ IDEA.
  User: alekseysamoylov
  Date: 6/19/16
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quarter</title>
    <link type="text/css" rel="stylesheet" href="<spring:url value="/resources/css/bootstrap.min.css"/>"/>
</head>
<body>
<jsp:include page="../views/fragments/header.jsp"></jsp:include>
<div class="container">

    <h2>Quarter</h2>

    <spring:url value="/insurer/list" var="insurerUrl"/>

    <form:form action="${insurerUrl}" method="post" modelAttribute="quarterParams">
        <div class="form-group">
            <label for="selectpicker1">Year</label>

            <form:select path="year" items="${yOptions}"
                         cssClass="selectpicker" id="selectpicker1"/>

        </div>
        <div class="form-group">
            <label for="selectpicker2">Quarter</label>

            <form:select path="quarter" items="${qOptions}"
                         cssClass="selectpicker" id="selectpicker2"/>
            <form:hidden path="insurer.insurerId"/>
        </div>

        <button type="submit" class="btn btn-default">Next</button>
    </form:form>
</div>

<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>