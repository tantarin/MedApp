<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Events</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <script type="text/javascript">
        function agreeForm(f) {
            let chbox =document.getElementById(f);
            document.getElementById("pt").disabled = !(chbox.checked && f === "p");
        }
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
                       <table  border="1" cellpadding="5">
                        <tr>
                            <th></th>
                            <th>
                                <div class="dropdown">
                                  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Ближайший день
                                </button>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <a class="dropdown-item" href="#">No filter</a>
                                </div>
                            </div>
                        </th>
                        <th>
                          <div class="dropdown">
                              <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Ближайший час
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="#">No filter</a>
                            </div>
                        </div>  
                    </th>
                    <th>
                       <input class="type-input" type="text">
                   </th>
                   <th></th>
                   <th><button class="confirm">Применить</button></th>
               </tr>
                           <thead>
               <tr class="name-title">
                <td class="left">Назначение</td>
                <td>Дата</td>
                <td>Время</td>
                <td>Пациент</td>
                <td>Статус</td>
                <td>Коментарий</td>
                           </thead>
            </tr>
            <c:forEach var="event" items="${listEvents}">
            <tr>
                <th></th>
                <td class="left">
                <c:out value="${event.type}" />
                </td>
                <td>
                <c:out value="${event.date}" />
                </td>
                <td>
                <c:out value="${event.time}" />
                </td>
                <td>
                <c:out value="${event.time}" />
                </td>
                <td>
                    <div class="dropdown">
                      <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Отменено
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="#">Выполнено</a>
                        <a class="dropdown-item" href="#">Запланировано</a>
                    </div>
                </div>
            </td>
            <th></th>
        </tr>
            </c:forEach>
</table>
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
