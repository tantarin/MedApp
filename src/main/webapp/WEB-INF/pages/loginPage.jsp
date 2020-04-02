<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>Login page</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<body onload='document.loginForm.username.focus();'>
<c:if test="${not empty error}"><div>${error}</div></c:if>
<c:if test="${not empty message}"><div>${message}</div></c:if>
<div class="wrapper fadeInDown">
    <div id="formContent">
<form name='login' action="<c:url value='/loginPage' />" method='POST'>
    <table>
        <tr>
            <td>Name:</td>
            <td><input type='text'  id="login" class="fadeIn second" name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' id="password" class="fadeIn third" name='password' /></td>
        </tr>
    </table>
    <button class="btn btn-warning" type="button">Кнопочка</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
    </div>
</div>
</body>
</html>
