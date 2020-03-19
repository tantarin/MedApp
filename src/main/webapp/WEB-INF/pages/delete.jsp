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
<c:url value="/patients/delete" var="del"/>
<form:form action="${del}" method="post" modelAttribute="patient">
    <table border="0" cellpadding="5">
        <tr>
            <td>
               Patient id:
            </td>
            <td>
                <form:input path="id" />
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
