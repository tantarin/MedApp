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
                <li><a href="${pageContext.request.contextPath}/patients/getAll" class="nav-link">Add assigment</a></li>
                <li><a href="${pageContext.request.contextPath}/events/getAll" class="nav-link">Events</a></li>
            </ul>
        </nav>
    </header>
    <br>

    <div class="container">
        <div class="row">
            <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

            <div class="col-xl-12 title">
                <h2>Добавить новое назначение</h2>
            </div>
            <div class="col-xl-12 wrap">
              <div class="row">
                  <div class="add-assigment">
                      <div class="add-box ad-box">
                        <label for="">Название</label>
                        <input type="text">
                    </div> 

                    <div class="add-box">Тип
                        <select class="form-control form-control-lg">
                            <option></option>
                            <option>Процедура</option>
                            <option>Лекарство</option>
                        </select>
                    </div> 

                    <div class="add-box">Временной Временной
                        <select class="form-control form-control-lg">
                            <option></option>
                            <option>Ежедневно</option>
                            <option>Через день</option>
                            <option>Раз в день</option>
                        </select>
                    </div> 
                    <div class="add-box">Количество раз в день
                        <div class="flex">
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="customControlAutosizing">
                                <label class="custom-control-label" for="customControlAutosizing">Утро</label>
                            </div>
                             <input type="time" id="appt" name="appt"
                            min="09:00" max="18:00" required>
                        </div>
                        <div class="flex">
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="customControlAutosizing1">
                                <label class="custom-control-label" for="customControlAutosizing1">День</label>
                            </div>
                            <input type="time" id="appt1" name="appt"
                            min="09:00" max="18:00" required>
                        </div>
                        <div class="flex">
                          <label>Вечер</label>
                          <input type="time" id="appt2" name="appt"
                          min="09:00" max="18:00" required>
                      </div>
                  </div>
                  <div class="add-box">
                    <div class="from">
                      <label>From</label>
                      <input type="date" id="start" name="trip-start"          
                      min="2018-01-01" max="2020-12-31">
                  </div>
                  <div class="from">
                      <label>To</label>
                      <input type="date" id="start1" name="trip-start"
                      min="2018-01-01" max="2020-12-31">
                  </div>
              </div>
              <div class="add-box">
                  <button class="btn btn-success add">Добавить</button>
              </div>
          </div>
      </div>
  </div>
</div>
    </div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</html>