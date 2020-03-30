<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tanya
  Date: 24.03.2020
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Events</title>
    <script type="text/javascript">
        function agreeForm(f) {
            let chbox =document.getElementById(f);
            document.getElementById("pt").disabled = !(chbox.checked && f === "p");
        }
    </script>
</head>
<body>
<c:url value="/events/filter" var="filter"/>
<form:form method="post" action="${filter}">
    <h4>Select a filter</h4>
    <table border="0" cellpadding="5">
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
