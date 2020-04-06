<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add assigment</title>

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
                <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
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
                      <div class="add-box ad-box">
                        <label>Name</label>
                          <form:input path="name" />
                    </div>
                      <div class="add-box ad-box">
                          <label>Doze</label>
                          <form:input path="doze" />
                      </div>
                      <div class="add-box">Type
                        <form:select class="form-control form-control-lg" path="type">
                            <option ></option>
                            <option>Procedure</option>
                            <option>Medicine</option>
                        </form:select>
                    </div>


                    <div class="add-box">Time pattern
                        <br>
                        <form:checkbox name="Mon" value="1" path="weeks"/>Monday</b>
                        <form:checkbox name="Tues" value="2" path="weeks"/>Tuesday</b>
                        <form:checkbox name="Wed" value="3" path="weeks"/>Wednesday</b>
                        <form:checkbox name="Th" value="4" path="weeks"/>Thursday</b>
                        <form:checkbox name="Fr" value="5" path="weeks"/>Friday</b>
                        <form:checkbox name="Sat" value="6" path="weeks"/>Saturday</b>
                        <form:checkbox name="Sun" value="7" path="weeks"/>Sunday</b>
                        <br>
                    </div> 
                    <div class="add-box">Number of times per day
                        <div class="flex">
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="customControlAutosizing">
                                <input class="custom-control-label" type="checkbox" id="o1" value="a1" onclick="agreeForm(this.id)">Утро</b>
                            </div>
                             <form:input path="time1" type="time" id="tm1" name="appt" min="09:00" max="18:00" required="true" disabled="true"/>
                        </div>
                        <div class="flex">
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="customControlAutosizing1" >
                                <input class="custom-control-label" type="checkbox" id="o2" value="a2" onclick="agreeForm(this.id)">День</b>
                            </div>
                            <form:input type="time" id="tm2" name="appt" min="09:00" max="18:00" required="true" path="time2" disabled="true"/>
                        </div>
                        <div class="flex">
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="customControlAutosizing2">
                                <input class="custom-control-label" type="checkbox" id="o3" value="a1" onclick="agreeForm(this.id)">Вечер</b>
                            </div>
                            <form:input type="time" id="tm3" name="appt" min="09:00" max="18:00" required="true" path="time3" disabled="true"/>
                      </div>
                  </div>
                  <div class="add-box">
                    <div class="from">
                      <label>From</label>
                      <form:input type="date" id="start" name="trip-start" min="2018-01-01" max="2020-12-31" path="dateFrom"/>
                  </div>
                  <div class="from">
                      <label>To</label>
                      <form:input type="date" id="start1" name="trip-start" min="2018-01-01" max="2020-12-31" path="dateTo"/>
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
    <c:url value="/logout" var="logoutUrl" />
    <form id="logout" action="${logoutUrl}" method="post" >
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script type="text/javascript">
    function agreeForm(f) {
        let chbox =document.getElementById(f);
        document.getElementById("tm1").disabled = !(chbox.checked && f === "o1");
        document.getElementById("tm2").disabled = !(chbox.checked && f === "o2");
        document.getElementById("tm3").disabled = !(chbox.checked && f === "o3");
    }
</script>
</html>