<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" isErrorPage="true" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Error Page</title>
</head>
<body>


<div class="inner cover">
    <h1 class="cover-heading">Something wrong.</h1>
    <p class="lead"><spring:message text="${exception}" javaScriptEscape="false"/></p>
</div>


</body>
</html>
