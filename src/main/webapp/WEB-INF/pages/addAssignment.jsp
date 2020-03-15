<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Assignment</h2>
<c:url value="/addAssignment" var="add"/>
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
            <td><form:input path="patient" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
