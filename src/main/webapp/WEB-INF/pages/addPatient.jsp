<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
        <title>Add Patient</title>
</head>
<body>
<c:url value="/addPatient" var="add"/>
<form:form action="${add}" method="post" modelAttribute="patient">
    <table border="0" cellpadding="5">
        <tr>
            <td>
                <form:label path="firstName">
                    Имя
                </form:label>
            </td>
            <td>
                <form:input path="firstName" />
            </td>
        </tr>
        <tr>
            <td>
            <form:label path="lastName">
                Фамилия
            </form:label>
            </td>
            <td><form:input path="lastName" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>
<br>
<h3>Patients List</h3>
    <table class="tg">
        <tr>
            <th width="80">Person ID</th>
            <th width="120">Person Name</th>
            <th width="120">Person Last_name</th>
        </tr>
            <tr>
                <td>${patient.id}</td>
                <td>${patient.firstName}</td>
                <td>${patient.lastName}</td>
            </tr>
    </table>
</body>
</html>