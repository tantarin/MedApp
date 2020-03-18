<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<h2>Add</h2>
<c:url value="/patients/add" var="add"/>
<a href="${add}">Add new patient</a>
<c:url value="/assignments/add" var="addA"/>
<a href="${addA}">Add assignment</a>
<c:url value="/patients/delete" var="del"/>
<a href="${del}">Delete patient</a>
</body>
</html>
