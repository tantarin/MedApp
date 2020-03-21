<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tanya
  Date: 18.03.2020
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<form:form method="post" modelAttribute="patient">
    <table border="0" cellpadding="5">
    <tr>
        <td>
            Patient id:
        </td>
        <td>
            <form:input  path="id" />
        </td>
        <td>
            New name:
        </td>
        <td>
            <form:input path="firstName" />
        </td>
        <td>
            New last name:
        </td>
        <td>
            <form:input path="lastName" />
        </td>
    </tr>
</table>
    <button type="submit" formaction="update">update</button>
    <button type="submit" formaction="delete">delete</button>
    </form:form>
</body>
</html>
