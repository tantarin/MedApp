<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Title</title>
</head>
<body>
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
