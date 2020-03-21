<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tanya
  Date: 21.03.2020
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit assignment</title>
</head>

<body>
<form:form method="post" modelAttribute="assignment">
    <table border="0" cellpadding="5">
        <tr>
            <td>
                Assignment id:
            </td>
            <td>
                <form:input  path="id" />
            </td>
            <td>
                New name:
            </td>
            <td>
                <form:input path="name" />
            </td>
            <td>
                New type:
            </td>
            <td>
                <form:input path="type" />
            </td>
        </tr>
    </table>
    <button type="submit" formaction="update">update</button>
    <button type="submit" formaction="delete">delete</button>
</form:form>
</body>
</html>
