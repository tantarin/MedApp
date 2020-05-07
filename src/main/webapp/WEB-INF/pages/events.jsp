<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Events</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <script type="text/javascript">
        function agreeForm(f) {
            let chbox = document.getElementById(f);
            document.getElementById("pt").disabled = !(chbox.checked && f === "p");
        }
    </script>
    <style>

        .odd{background-color: #6fff93;}

    </style>

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

<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
<div class="container">
    <div class="row">

        <div class="col-xl-12 title">
            <h2>Events</h2>
        </div>
        <div class="col-xl-12 wrap">
            <div class="row">
                <div class="event-title">
                    <table id="table" class="table table-striped table-bordered">
                        <tr>
                            <th></th>
                            <th></th>
                            <th>
                                <c:url value="/events/getAll" var="filter"/>
                                <form:form action="${filter}" method="post" modelAttribute="filterDto">
                                <div class="dropdown">
                                    <form:select class="btn btn-secondary dropdown-toggle" path="byDay">
                                        <option>this day</option>
                                        <option selected="selected">no filter</option>
                                    </form:select>
                                </div>
                            </th>
                            <th>
                                <div class="dropdown">
                                    <form:select class="btn btn-secondary dropdown-toggle" path="byHour">
                                        <option>this hour</option>
                                        <option selected="selected">no filter</option>
                                    </form:select>
                                </div>
                            </th>
                            <th>
                                <form:input class="type-input" placeholder="patient's last name" type="text"
                                            path="byPatient"/>
                            </th>
                            <th></th>
                            <td width="23%">
                                <input type="submit" class="btn btn-success btn-list" value="Submit">
                            </td>
                        </tr>
                        </form:form>
                        <tr class="name-title">
                            <td class="left">Assignment</td>
                            <td>Doze</td>
                            <td>Date</td>
                            <td>Time</td>
                            <td>Patient</td>
                            <td>Status</td>
                            <td>Comments</td>

                        </tr>
                        <c:forEach var="event" items="${listEvents}">
                            <tr style="${event.status == 'Done' ? 'background: #A9F5E1;' : ''}">
                                <td class="left">
                                    <c:out value="${event.assignmentName}"/>
                                </td>
                                <td>
                                    <c:out value="${event.doze}"/>
                                </td>
                                <td>
                                    <c:out value="${event.date}"/>
                                </td>
                                <td>
                                    <c:out value="${event.time}"/>
                                </td>
                                <td>
                                    <c:out value="${event.patientName}"/>
                                </td>
                                <td>
                                    <div class="dropdown">
                                        <div class="dropdown">
                                            <c:url value="/events/comments?id=${event.id}" var="all"/>
                                            <form:form action="${all}" method="post" modelAttribute="eventDto">
                                            <form:select id="${event.id}" class="btn btn-secondary dropdown-toggle"
                                                         onchange="func(this.id, '${event.status}')" path="status" disabled="${event.comments == 'Patient discharged' ? 'true' : 'false'}" >
                                                <option value="Cancelled" ${event.status == "Cancelled" ? 'selected="selected"' : ''}>Cancelled</option>
                                                <option value="Done" ${event.status == "Done" ? 'selected="selected"' : ''}>Done</option>
                                                <option value="Scheduled" ${event.status == "Scheduled" ? 'selected="selected"' : ''}>Scheduled</option>
                                            </form:select>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <form:input value="${event.comments == '' ? '' : event.comments}" type="text"
                                                id="comm${event.id}" disabled="true" onchange="ff(this.id)" path="comments"/>
                                    </form:form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
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
<script>
        function ff(id) {
        document.getElementById(id).form.submit();
    }

    function func(id,status) {
        let s= status;
        if (document.getElementById(id).value === "Cancelled") {
            var idd = "comm" + id;
            document.getElementById(idd).removeAttribute("disabled");
            document.getElementById(idd).removeAttribute("hidden");
            document.getElementById(idd).focus();
        }
        if (document.getElementById(id).value === "Done"){
            ff(id);
        }
        if(document.getElementById(id).value === "Scheduled") {
            ff(id);
        }
    }
</script>
</html>
