<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>Medical App</title>
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
<br>

<div class="row">
    <div class="container">
        <h3 class="text-center">Patients</h3>
        <hr>
        <div class="container text-left">

            <a href="${pageContext.request.contextPath}/patients/add" class="btn btn-success">Add
                new patient</a>
        </div>
        <br>
        <table id="table" class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Last name</th>
                <th>Status</th>
            </tr>
            </thead>
            <c:forEach var="patient" items="${patients}">
                <tr>
                    <td>
                        <c:out value="${patient.id}" />
                    </td>
                    <td>
                        <c:out value="${patient.firstName}" />
                    </td>
                    <td>
                        <c:out value="${patient.lastName}" />
                    </td>
                    <td>
                        <span id="${patient.id}">
                            <c:out value="${patient.status}" />
                        </span>
                    </td>
                    <td><a href="${pageContext.request.contextPath}/patients/update?id=<c:out value='${patient.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/events/delete?id=<c:out value='${patient.id}' />">Discharge</a> &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/patients/assignments?id=<c:out value='${patient.id}' />">Assignments</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>

</html>
