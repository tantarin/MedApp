<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script type="text/javascript">
        function agreeForm(f) {
            let chbox =document.getElementById(f);
            document.getElementById("tm1").disabled = !(chbox.checked && f === "o1");
            document.getElementById("tm2").disabled = !(chbox.checked && f === "o2");
            document.getElementById("tm3").disabled = !(chbox.checked && f === "o3");
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
            <li><a href="${pageContext.request.contextPath}/patients/getAll" class="nav-link">Add assignment</a></li>
        </ul>
    </nav>
</header>
<c:url value="/assignments/add" var="add"/>
<form:form action="${add}" method="post" modelAttribute="assignmentDto">
    <table border="0" cellpadding="5">
        <tr>
            <td>
                Тип:
            </td>
            <td>
                <form:input path="type" />
            </td>
        </tr>
        <tr>
            <td>
                Название:
            </td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
    </table>
        <br>
            <form:checkbox name="Mon" value="1" path="weeks"/>Monday</b>
            <form:checkbox name="Tues" value="2" path="weeks"/>Tuesday</b>
            <form:checkbox name="Wed" value="3" path="weeks"/>Wednesday</b>
            <form:checkbox name="Th" value="4" path="weeks"/>Thursday</b>
            <form:checkbox name="Fr" value="5" path="weeks"/>Friday</b>
            <form:checkbox name="Sat" value="6" path="weeks"/>Saturday</b>
            <form:checkbox name="Sun" value="7" path="weeks"/>Sunday</b>
            <br>
             <br>
        <input type="checkbox" id="o1" value="a1" onclick="agreeForm(this.id)">Утро</b>
        <form:input type="time" id="tm1" disabled="true" path="time1"/>
        <input type="checkbox" id="o2" value="a2" onclick="agreeForm(this.id)">День</b>
        <form:input type="time" id="tm2" disabled="true" path="time2"/>
        <input type="checkbox" id="o3" value="a3" onclick="agreeForm(this.id)">Вечер</b>
        <form:input type="time" id="tm3" disabled="true" path="time3"/>
    <br>
    <br>
    <label for="date1">From: </label>
    <form:input type="date" id="date1" path="dateFrom"/>
    <label for="date2">To: </label>
    <form:input type="date" id="date2" path="dateTo"/>
    <br>
    <br>
            <td colspan="2"><input type="submit" value="Save"></td>
</form:form>
</body>
</html>
