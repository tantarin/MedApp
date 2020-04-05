<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Add patients</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <body>
        <header>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                <div>
                    <a href="https://www.javaguides.net" class="navbar-brand"> Medical App </a>
                </div>

                <ul class="navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/patients/getAll" class="nav-link">Add Patients</a></li>
                    <li><a href="${pageContext.request.contextPath}/events/getAll" class="nav-link">Events</a></li>
                </ul>
            </nav>
        </header>
        <br>

        <div class="container">
            <div class="row">
                <div class="col-xl-12 title">
                    <h2>Добавить нового пациента</h2>
                </div>
                <div class="col-xl-12 wrap">
                  <div class="row">
                     <div class="add-assigment">
                       <div class="add-box">
                        <label>Имя</label>
                        <input type="text">
                        <label>Фамилия</label>
                        <input type="text">
                    </div> 
                    <div class="add-assigment">
                       <div class="add-pt">Номер страховки
                        <input type="text">
                    </div> 

                    <div class="add-box">Лечащий врач
                        <select class="form-control form-control-lg">
                            <option></option>
                            <option>Процедура</option>
                            <option>Лекарство</option>
                        </select>
                    </div> 
                    <div class="add-b">Статус
                        <div class="status">
                            <div class="form-check">
                              <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
                              <label class="form-check-label" for="exampleRadios1">
                                Лечится
                            </label>
                        </div>
                        <div class="form-check break">
                          <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
                          <label class="form-check-label" for="exampleRadios2">
                            Выписан
                        </label>
                    </div>
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
        </div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</html>