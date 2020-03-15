<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring5 MVC Hibernate Demo</title>
</head>
<body>
<h1>Input Form</h1>
<form:form action="addUser" method="post" modelAttribute="user">
    <table>
        <tr>
            <td>Name</td>
            <td>
                <form:input path="name" /> <br />
                <form:errors path="name" />
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <form:input path="email" /> <br />
                <form:errors path="email" />
            </td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit">Submit</button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
