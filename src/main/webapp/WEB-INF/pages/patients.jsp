<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="windows-1252">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        table tr:not(:first-line){
            cursor: pointer;transition: all .25s ease-in-out;
        }
        table tr:not(:first-child):hover{background-color: #ddd;}
        input {
            width: 100%;
            box-sizing: border-box;
        }
    </style>
    <title>Medical App</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
            <li><a class="nav-link" href="<c:url value="/logout" />">Logout</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container">
    <div class="row">
        <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

        <div class="col-xl-12 title">
            <h2>Patients</h2>
        </div>
    </div>
    <div class="col-xl-12 wrap">
        <div class="row">
            <a class="btn btn-success btn-list" href="${pageContext.request.contextPath}/patients/add">Add</a> &nbsp;&nbsp;&nbsp;&nbsp;
            <div class="event-title">
        <table id="table" class="table table-striped table-bordered">
            <thead>
            <tr class="name-title width-users">
                <td>Name</td>
                <td>Last name</td>
                <td>Ensurance number</td>
                <td>Doctor</td>
                <td>Status</td>
            </tr>
            </thead>
            <c:url value="/patients/getAll" var="add"/>
            <form:form action="${add}" method="post" modelAttribute="patient" id="url">
            <tr>
                <td>
                    <form:input type = "text" id="fname" path="firstName"/>
                </td>
                <td>
                    <form:input type = "text" id="lname" path="lastName"/>
                </td>
                <td>
                    <form:input type = "text" id="ens" path="ensNumber"/>
                </td>
                <td>
                    <form:input type = "text" id="doc" path="doctor"/>
                </td>
                <td>
                    <form:input type = "text" id="st" path="status"/>
                </td>
                <td width="23%">
                     <input type="submit" class="btn btn-success btn-list" value="Submit" >
                </td>
                </form:form>
            </tr>
            <c:forEach var="patient" items="${patients}">
                <tr>
                    <td>
                        <c:out value="${patient.firstName}" />
                    </td>
                    <td>
                        <c:out value="${patient.lastName}" />
                    </td>
                    <td>
                        <c:out value="${patient.ensNumber}" />
                    </td>
                    <td>
                        <c:out value="${patient.doctor}" />
                    </td>
                    <td>
                        <c:out value="${patient.status}" />
                    </td>
                    <td width="23%">
                        <a type="submit" class="btn btn-default" id="${patient.id}"  onclick="Update(id)">
                            <i class="material-icons">edit</i>
                        </a>
                        <a type="submit" class="btn btn-default" href="${pageContext.request.contextPath}/patients/delete?id=<c:out value='${patient.id}' />">
                            <i class="material-icons">clear</i>
                        </a>
                        <a type="submit" class="btn btn-default" href="${pageContext.request.contextPath}/patients/assignments?id=<c:out value='${patient.id}'/>">
                            <i class="material-icons">list</i>
                        </a>
                        <a type="submit" class="btn btn-default" href="${pageContext.request.contextPath}/patients/clear?id=<c:out value='${patient.id}'/>">
                            <i class="material-icons">delete</i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
         </div>
    </div>
     </div>

<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
<script type="text/javascript">
    function Update(id) {
        var table = document.getElementById("table");
        document.getElementById(id).onclick = function () {
            document.getElementById('url').action = "/patients/getAll?id="+id;
            var rIndex = document.getElementById(id).parentNode.parentNode.rowIndex;
                document.getElementById("fname").value = table.rows[rIndex].cells[0].innerHTML;
                document.getElementById("lname").value = table.rows[rIndex].cells[1].innerHTML;
                document.getElementById("ens").value = table.rows[rIndex].cells[2].innerHTML;
                document.getElementById("doc").value = table.rows[rIndex].cells[3].innerHTML;
                document.getElementById("st").value = table.rows[rIndex].cells[4].innerHTML;
            }
    }
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</html>
