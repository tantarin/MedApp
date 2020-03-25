<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<h2>Add assignment to patient</h2>
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
        <tr>
            <td>
                Id пациента:
            </td>
            <td><form:input path="patientId" /></td>
        </tr>
    </table>
        <br>
            <form:checkbox name="Mon" value="a1" path="weeks"/>Monday</b>
            <form:checkbox name="Tues" value="a2" path="weeks"/>Tuesday</b>
            <form:checkbox name="Wed" value="a3" path="weeks"/>Wednesday</b>
            <form:checkbox name="Th" value="a4" path="weeks"/>Thursday</b>
            <form:checkbox name="Fr" value="a5" path="weeks"/>Friday</b>
            <form:checkbox name="Sat" value="a5" path="weeks"/>Saturday</b>
            <form:checkbox name="Sun" value="a5" path="weeks"/>Sunday</b>
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
