<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit assigment</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <style type="text/css">
        .fix {
            -webkit-box-shadow: none;
            box-shadow: none;
        }
        .fix:focus {
            -webkit-box-shadow: none;
            box-shadow: none;
        }
    </style>
</head>

<body onload="myFunction()">

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> Medical App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="${pageContext.request.contextPath}/patients/getAll" class="nav-link">Patients</a></li>
            <li><a href="${pageContext.request.contextPath}/events/getAll" class="nav-link">Events</a></li>
            <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
        </ul>
    </nav>
</header>
<br>

<div class="container">
    <div class="row">
        <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
        <c:url value="/assignments/edit?id=${assignmentDto.id}" var="add"/>
        <form:form action="${add}" method="post" modelAttribute="assignmentDto">
        <div class="col-xl-12 title">
            <h2>Edit assignment</h2>
        </div>
        <div class="col-xl-12 wrap">
            <div class="row">
                <div class="add-assigment">
                    <div class="add-box ad-box">
                        <label>Name</label>
                        <form:input path="name" id="name"/>
                    </div>

                    <div class="add-box">Type
                        <form:select class="form-control form-control-lg" path="type" id="type">
                            <option ></option>
                            <option>Procedure</option>
                            <option>Medicine</option>
                        </form:select>
                    </div>

                    <div class="add-box">
                        <br>
                        <div class="custom-control custom-checkbox">
                            <form:checkbox class="custom-control-input" path="weeks" checked="true" value="Monday"/>
                            <label class="custom-control-label">Monday</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <form:checkbox class="custom-control-input" path="weeks" checked="true" value="Monday"/>
                            <label class="custom-control-label">Tuesday</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <form:checkbox class="custom-control-input" path="weeks" checked="true" value="Monday"/>
                            <label class="custom-control-label">Wednesday </label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <form:checkbox class="custom-control-input" path="weeks" checked="true" value="Monday"/>
                            <label class="custom-control-label">Thursday</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <form:checkbox class="custom-control-input" path="weeks" checked="true" value="Monday"/>
                            <label class="custom-control-label">Friday</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <form:checkbox class="custom-control-input" path="weeks" checked="true" value="Monday"/>
                            <label class="custom-control-label">Saturday</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <form:checkbox class="custom-control-input" path="weeks" checked="true" value="Monday"/>
                            <label class="custom-control-label">Sunday</label>
                        </div>
                        <br>
                    </div>
                    <div class="add-box">
                        &nbsp;
                        &nbsp;
                        &nbsp;
                        &nbsp;
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="defaultChecked" checked>
                            <label class="custom-control-label" onclick="agreeForm(this.id)">Morning</label>
                        </div>
                            <form:input type="time" id="tm2" name="appt" min="09:00" max="18:00" required="true" path="time1" disabled="true"/>
                        &nbsp;
                        &nbsp;
                        &nbsp;
                        &nbsp;
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input"checked>
                            <label class="custom-control-label" onclick="agreeForm(this.id)">Afternoon</label>
                        </div>
                            <form:input type="time" id="tm2" name="appt" min="09:00" max="18:00" required="true" path="time2" disabled="true"/>
                        &nbsp;
                        &nbsp;
                        &nbsp;
                        &nbsp;
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="defaultChecked2">
                            <label class="custom-control-label" onclick="agreeForm(this.id)" for="defaultChecked2">Evening</label>
                        </div>
                            <form:input type="time" id="tm3" name="appt" min="09:00" max="18:00" required="true" path="time3" disabled="true"/>
                    </div>
                    <div class="add-box">
                        <div class="from">
                            <label>From</label>
                            <form:input type="date" id="fromDate" name="trip-start" value="2018-02-02" onclick="mindate()" min="2018-01-01" max="2020-12-31" path="dateFrom"/>
                        </div>
                        <div class="from">
                            <label>To</label>
                            <form:input type="date" id="toDate" name="trip-start" min="2018-01-01" max="2020-12-31" path="dateTo"/>
                        </div>
                    </div>
                    <div class="add-box">
                        <input type="submit" class="btn btn-success btn-list" value="Add">&nbsp;&nbsp;&nbsp;&nbsp;
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</form:form>
<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script type="text/javascript">
    function myFunction(){
        document.getElementById("name").defaultValue = ${assignmentDto.name};
        document.getElementById("type").defaultValue = ${assignmentDto.type};
        document.getElementById("name").defaultValue = ${assignmentDto.name};
    }
    function mindate() {
        var d = new Date();
        var month = '' + (d.getMonth() + 1);
        var day = '' + d.getDate();
        var year = d.getFullYear();
        if (month.length < 2)
            month = '0' + month;
        if (day.length < 2)
            day = '0' + day;
        var newDate =  [year, month, day].join('-');
        document.getElementById("fromDate").min = newDate;
    }
    document.getElementById('fromDate').oninput = () => {
        let tt = new Date(document.getElementById('fromDate').value);
        var month = '' + (tt.getMonth() + 1);
        var day = '' + tt.getDate();
        var year = tt.getFullYear();
        if (month.length < 2)
            month = '0' + month;
        if (day.length < 2)
            day = '0' + day;
        document.getElementById("toDate").min = [year, month, day].join('-');
    };
</script>
</html>