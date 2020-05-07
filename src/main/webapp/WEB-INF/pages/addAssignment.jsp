<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add assigment</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <script type="text/javascript">
        //TODO change status
        var del = document.getElementById("del");
        agreeForm = function () {
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
            <li><a class="nav-link" href="<c:url value="/logout" />">Logout</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="container">
    <div class="row">
        <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
        <c:url value="/assignments/add" var="add"/>
        <form:form action="${add}" method="post" modelAttribute="assignmentDto">
        <div class="col-xl-12 title">
            <h2>Add assignment</h2>
        </div>
        <div class="col-xl-12 wrap">
            <div class="row">
                <div class="add-assigment">
                    <div class="add-box">Type
                        <form:select id="type" class="form-control form-control-lg" path="type" onchange="func()">
                            <option>Procedure</option>
                            <option>Medicine</option>
                        </form:select>
                    </div>
                    <div class="add-box">Name
                        <form:select id="name" class="form-control form-control-lg" path="name">
                            <option></option>
                        </form:select>
                    </div>
                    <div class="add-box ad-box">
                        <label>Doze</label>
                        <form:input path="doze"/>
                    </div>



                    <div class="add-box">
                        <br>
                        <div class="custom-control custom-checkbox">
                            <form:checkbox class="custom-control-input" id="mon" path="weeks" value="1"/>
                            <label class="custom-control-label" for="mon">Monday</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <form:checkbox class="custom-control-input" id="tue" path="weeks" value="2"/>
                            <label class="custom-control-label" for="tue">Tuesday</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <form:checkbox class="custom-control-input" id="w" path="weeks" value="3"/>
                            <label class="custom-control-label" for="w">Wednesday </label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <form:checkbox class="custom-control-input" id="t" path="weeks" value="4"/>
                            <label class="custom-control-label" for="t">Thursday</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <form:checkbox class="custom-control-input" id="f" path="weeks" value="5"/>
                            <label class="custom-control-label" for="f">Friday</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <form:checkbox class="custom-control-input" id="s" path="weeks" value="6"/>
                            <label class="custom-control-label" for="s">Saturday</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                            <form:checkbox class="custom-control-input" id="san" path="weeks" value="7"/>
                            <label class="custom-control-label" for="san">Sunday</label>
                        </div>
                        <br>
                    </div>
                    <div class="add-box">
                        &nbsp;
                        &nbsp;
                        &nbsp;
                        &nbsp;
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="a">
                            <label id="mor" class="custom-control-label" for="a"
                                   onclick="agreeForm(this.id)">Morning</label>
                        </div>
                        <form:input type="time" id="tm1" name="appt" min="09:00" max="18:00" required="true"
                                    path="time1" disabled="true"/>
                        &nbsp;
                        &nbsp;
                        &nbsp;
                        &nbsp;
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="q">
                            <label id="aft" class="custom-control-label" for="q"
                                   onclick="agreeForm(this.id)">Afternoon</label>
                        </div>
                        <form:input type="time" id="tm2" name="appt" min="09:00" max="18:00" required="true"
                                    path="time2" disabled="true"/>
                        &nbsp;
                        &nbsp;
                        &nbsp;
                        &nbsp;
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="r">
                            <label id="eve" class="custom-control-label" for="r"
                                   onclick="agreeForm(this.id)">Evening</label>
                        </div>
                        <form:input type="time" id="tm3" name="appt" min="09:00" max="18:00" required="true"
                                    path="time3" disabled="true"/>
                    </div>
                    <div class="add-box">
                        <div class="from">
                            <label>From</label>
                            <form:input type="date" onclick="mindate()" id="fromDate" name="trip-start" min="2018-01-01"
                                        max="2020-12-31" path="dateFrom"/>
                        </div>
                        <div class="from">
                            <label>To</label>
                            <form:input type="date" id="toDate" name="trip-start" min="2018-01-01" max="2020-12-31"
                                        path="dateTo"/>
                        </div>
                    </div>
                    <div class="add-box">
                        <input type="submit" class="btn btn-success btn-list" value="Add">&nbsp;&nbsp;&nbsp;&nbsp;
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
<script type="text/javascript">
    func();
   function func(){
       let select = document.getElementById("name");
       if (document.getElementById("type").value === "Procedure") {
           $('#name')
               .empty();
           let opt = document.createElement('option');
           opt.value = "Massage";
           opt.innerHTML = "Massage";
           select.appendChild(opt);
           let opt1 = document.createElement('option');
           opt1.value = "Tomography";
           opt1.innerHTML = "Tomography";
           select.appendChild(opt1);
           let opt2 = document.createElement('option');
           opt2.value = "Magnetic Therapy";
           opt2.innerHTML = "Magnetic Therapy";
           select.appendChild(opt2);
       }
       else if (document.getElementById("type").value === "Medicine") {
           $('#name')
               .empty();
           let opt = document.createElement('option');
           opt.value = "Wellbutrin ";
           opt.innerHTML = "Wellbutrin ";
           select.appendChild(opt);
           let opt1 = document.createElement('option');
           opt1.value = "Indocin";
           opt1.innerHTML = "Indocin";
           select.appendChild(opt1);
           let opt2 = document.createElement('option');
           opt2.value = "Proscar";
           opt2.innerHTML = "Proscar";
           select.appendChild(opt2);
       }
    }


    function agreeForm(f) {
        if (f === "mor") {
            if (!document.getElementById("tm1").getAttribute("disabled")) {
                document.getElementById("tm1").setAttribute("disabled","true")
            } else {
                document.getElementById("tm1").removeAttribute("disabled");
            }
        }
        if (f === "aft") {
            if (!document.getElementById("tm2").getAttribute("disabled")) {
                document.getElementById("tm2").setAttribute("disabled","true")
            } else {
                document.getElementById("tm2").removeAttribute("disabled");
            }
        }
        if (f === "eve") {
            if (!document.getElementById("tm3").getAttribute("disabled")) {
                document.getElementById("tm3").setAttribute("disabled","true")
            } else {
                document.getElementById("tm3").removeAttribute("disabled");
            }
        }
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
        document.getElementById("fromDate").min = [year, month, day].join('-');
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