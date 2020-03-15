<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<h2>Add</h2>
<c:url value="/addPatient" var="add"/>
<a href="${add}">Add new patient</a>
<c:url value="/addAssignment" var="addA"/>
<a href="${addA}">Add assignment</a>
</body>
</html>
