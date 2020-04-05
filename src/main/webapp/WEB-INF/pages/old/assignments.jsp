<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assignments</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

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
<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
    <div class="container">
        <h3 class="text-center">Assignments</h3>
        <hr>
        <div class="container text-left">
            <a href="${pageContext.request.contextPath}/assignments/add?id=<c:out value='${id}'/>"> Add new assignment </a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Type</th>
                <th>Name</th>
            </tr>
            </thead>
            <c:forEach var="ass" items="${assignments}">
                <tr>
                    <td>
                        <c:out value="${ass.id}" />
                    </td>
                    <td>
                        <c:out value="${ass.type}" />
                    </td>
                    <td>
                        <c:out value="${ass.name}" />
                    </td>
                    <td><a href="${pageContext.request.contextPath}/assignments/update?id=<c:out value='${ass.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/assignments/delete?id=<c:out value='${ass.id}' />">Delete</a> &nbsp;&nbsp;</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
