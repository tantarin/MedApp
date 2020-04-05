<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Events</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script type="text/javascript">
        function agreeForm(f) {
            let chbox =document.getElementById(f);
            document.getElementById("pt").disabled = !(chbox.checked && f === "p");
        }
    </script>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> Medical App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="${pageContext.request.contextPath}/patients/getAll" class="nav-link">Patients</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
    <div class="container">
        <h3 class="text-center">Events</h3>
        <hr>
        <div class="container text-left">
        </div>
        <br>
<c:url value="/events/filter" var="filter"/>
<form:form method="post" action="${filter}">
    <h4>Select a filter</h4>
    <table class="table table-bordered" border="0" cellpadding="5">
        <tr>
            <label>
                <input type="checkbox" name="date" value="1"/>
            </label>This day
            <label>
                <input type="checkbox" name="hour" value="2" />
            </label>Next hour
            <label>
                <input type="checkbox" id="p" value="3" onclick="agreeForm(this.id)"/>
                By patient
                <input type="text" id="pt" name="patient" disabled="true"/>
            </label>
        </tr>
    </table>
    <button type="submit">Ok</button>
</form:form>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of events</h2></caption>
        <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Time</th>
        </tr>
        <c:forEach var="event" items="${listEvents}">
            <tr>
                <td><c:out value="${event.id}" /></td>
                <td><c:out value="${event.date}" /></td>
                <td><c:out value="${event.time}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
