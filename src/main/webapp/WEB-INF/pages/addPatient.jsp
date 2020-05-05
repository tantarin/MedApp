<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Add patients</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> Medical App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="${pageContext.request.contextPath}/patients/getAll" class="nav-link">Patients</a></li>
            <li><a href="${pageContext.request.contextPath}/events/getAll" class="nav-link">Events</a></li>
            <li><a href="javascript:document.getElementById('logout').submit()" class="nav-link">Logout</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="container">
    <div class="row">
        <c:url value="/patients/add" var="add"/>
        <form:form action="${add}" method="post" modelAttribute="patient">
        <div class="col-xl-12 title">
            <h2>Add new patient</h2>
        </div>
        <div class="col-xl-12 wrap">
            <div class="row">
                <div class="add-assigment">
                    <div class="add-box">
                        <label>Name</label>
                        <form:input type="text" path="firstName" placeholder="Ivan" required="true"/>
                        <label>Last name</label>
                        <form:input type="text" path="lastName" placeholder="Ivanov" required="true"/>
                    </div>
                    <div class="add-box">
                        <label>Diagnosis</label>
                        <form:input type="text" path="diagnosis" placeholder="Diagnosis" required="true"/>
                    </div>
                    <div class="add-box">
                        Security number
                        <form:input type="text" path="ensNumber" required="true"
                                    oninvalid="this.setCustomValidity('16 digits are required')"
                                    oninput="this.setCustomValidity('')" pattern="[0-9]{16}"/>
                    </div>
                    <div class="add-box">Doctor
                        <form:select class="form-control form-control-lg" path="doctor">
                            <option>Ivanov</option>
                            <option>Sidorov</option>
                        </form:select>
                    </div>
                    <div class="add-b">Status
                        <div class="status">
                            <div class="form-check">
                                <form:radiobutton class="form-check-input" name="exampleRadios" id="exampleRadios1"
                                                  value="on medication" checked="true" path="status"/>
                                <label class="form-check-label" for="exampleRadios1">
                                    On medication
                                </label>
                            </div>
                            <div class="form-check break">
                                <form:radiobutton class="form-check-input" name="exampleRadios" id="exampleRadios2"
                                                  value="discharged" path="status"/>
                                <label class="form-check-label" for="exampleRadios2">
                                    Disсharged
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="add-box">
                        <input type="submit" class="btn btn-success btn-list" value="Add">&nbsp;&nbsp;
                    </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<c:url value="/logout" var="logoutUrl"/>
<form id="logout" action="${logoutUrl}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</html>