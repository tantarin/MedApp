<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tanya
  Date: 29.03.2020
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Welcome to medapp</h3>
<ul>
    <li>
        <c:url value="/patients/add" var="add"/>
        <a href="${add}">Add new patient</a>
    </li>
    <li>
        <c:url value="/patients/delete" var="add"/>
        <a href="${add}">Sign out or update patient</a>
    </li>
    <li>
        <c:url value="/assignments/add" var="addA"/>
        <a href="${addA}">Add assignment</a>
    </li>
    <li>
        <c:url value="/assignments/update" var="edit"/>
        <a href="${edit}">Edit assignments</a>
    </li>
    <li>
        <c:url value="/assignments/delete" var="del"/>
        <a href="${del}">Delete assignment</a>
    </li>
    <li>
        <c:url value="/events/getAll" var="del"/>
        <a href="${del}">All events</a>
    </li>
</ul>
<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<a href="${pageContext.request.contextPath}/events/getAll">Nurse</a> | <a href="${pageContext.request.contextPath}/assignments/add">Doctor</a> | <a href="javascript:document.getElementById('logout').submit()">Logout</a>
</body>
</html>
