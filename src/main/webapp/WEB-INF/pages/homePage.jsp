<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<h3>Welcome to medapp</h3>
<ul>
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
    <li>
        <c:url value="/patients/getAll" var="all"/>
        <a href="${all}">All patients</a>
    </li>
</ul>
<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<a href="${pageContext.request.contextPath}/events/getAll">Nurse</a> | <a href="${pageContext.request.contextPath}/assignments/add">Doctor</a> | <a href="javascript:document.getElementById('logout').submit()">Logout</a>
</body>
</html>
