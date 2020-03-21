<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Add assignment to patient</h2>
<c:url value="/assignments/add" var="add"/>
<form:form action="${add}" method="post" modelAttribute="assignment">
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
        <tr>
            <td colspan="2"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
