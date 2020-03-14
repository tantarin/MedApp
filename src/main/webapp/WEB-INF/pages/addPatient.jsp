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
                Имя
            </td>
            <td>
                <form:input path="firstName" />
            </td>
        </tr>
        <tr>
            <td>
                Фамилия
            </td>
            <td><form:input path="lastName" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>
<br>
</body>
</html>