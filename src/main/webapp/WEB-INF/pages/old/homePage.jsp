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
        <c:url value="/events/getAll" var="del"/>
        <a href="${del}">All events</a>
    </li>
    <li>
        <c:url value="/patients/getAll" var="all"/>
        <a href="${all}">All patients</a>
    </li>
</ul>

</body>
</html>
