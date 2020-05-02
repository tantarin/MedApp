<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Assigment</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <script type="text/javascript">
        //TODO change status
        var del = document.getElementById("del");
        agreeForm = function(){
            document.getElementById("msgToReplace").innerHTML = "discharged";
            return false;
        };
    </script>
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
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="col-xl-12 title">
        <h2>Assigments</h2>
</div>
     <div class="col-xl-12 wrap">
      <div class="row">
          <a class="btn btn-success btn-list" href="${pageContext.request.contextPath}/assignments/add?id=<c:out value='${id}' />">Add</a> &nbsp;&nbsp;&nbsp;&nbsp;
        <div class="event-title">
        <table id="table" class="table table-striped table-bordered">
            <thead>
            <tr class="name-title width">
                <td>Type</td>
                <td>Name</td>
                <td>Period</td>
                <td>Time</td>
                <td>Doze</td>
                <td></td>
            </tr>
            </thead>
            <c:forEach var="ass" items="${assignments}">
                <tr>
                    <td>
                        <c:out value="${ass.type}" />
                    </td>
                    <td>
                        <c:out value="${ass.name}" />
                    </td>
                    <td>
                        <c:out value="${ass.period}" />
                    </td>
                    <td>
                        <c:out value="${ass.time1}" />
                        <c:out value="${ass.time2}" />
                        <c:out value="${ass.time3}" />
                    </td>
                    <td>
                        <c:out value="${ass.doze}" />
                    </td>
                    <td>
                        <a class="btn btn-success btn-list" href="${pageContext.request.contextPath}/assignments/edit?id=<c:out value='${ass.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="btn btn-secondary btn-list" href="${pageContext.request.contextPath}/assignments/delete?id=<c:out value='${ass.id}' />">Delete</a> &nbsp;&nbsp;&nbsp;&nbsp;

                    </td>
                </tr>
            </c:forEach>
        </table>
         </div>
    </div>
    </div>
    </div>
    </div>
</div>
<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</html>
