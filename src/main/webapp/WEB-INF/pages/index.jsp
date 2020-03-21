<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<h2>Patient</h2>
<c:url value="/patients/add" var="add"/>
<a href="${add}">Add new patient</a>
<c:url value="/patients/delete" var="add"/>
<a href="${add}">Sign out or update patient</a>
<c:url value="/assignments/add" var="addA"/>
<a href="${addA}">Add assignment</a>
<c:url value="/assignments/update" var="edit"/>
<a href="${edit}">Edit assignments</a>
<c:url value="/assignments/delete" var="del"/>
<a href="${del}">Delete assignment</a>
</body>
</html>
