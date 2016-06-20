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
    <title>Graph</title>
    <link type="text/css" rel="stylesheet" href="<spring:url value="/resources/css/bootstrap.min.css"/>"/>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript">

        google.charts.load('current', {packages: ['corechart', 'line']});
        google.charts.setOnLoadCallback(drawCurveTypes);

        function drawCurveTypes() {
            var data = new google.visualization.DataTable();
            data.addColumn('date', 'Date');
            data.addColumn('number', 'Value');
            var jsonData = $.ajax({
                url: "<spring:url
							value="/graph/get/${graphId}"/>",
                dataType: "json",
            }).done(function (results) {
                results.tableInformationList.forEach(function (entry) {
                    data.addRow([new Date(entry.date), entry.value]);
                });

                var options = {
                    hAxis: {
                        title: 'Time'
                    },
                    vAxis: {
                        title: 'Value'
                    },
                    series: {
                        1: {curveType: 'function'}
                    }
                };

                var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
                chart.draw(data, options);
            });

        }

    </script>
</head>
<body>
<jsp:include page="../views/fragments/header.jsp"></jsp:include>
<div class="container">

    <h2>Graph</h2>

    <h3>Insurer's name: <strong>${concretes[0].insurer.name}</strong></h3>

    <h3>Index: <strong>${concretes[0].index.indexName}</strong></h3>

    <div id="chart_div"></div>
    <table class="table table-hover">
        <tbody>
        <tr>
            <th>Start period</th>
            <th>End period</th>
            <th>Value</th>

        </tr>
        <c:forEach items="${concretes}" var="concrete">
            <tr>
                <td>${concrete.reportingPeriod.startPeriod}</td>
                <td>${concrete.reportingPeriod.stopPeriod}</td>
                <td>${concrete.value}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>