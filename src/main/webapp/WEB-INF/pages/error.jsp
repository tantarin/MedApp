<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" isErrorPage="true" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Error Page</title>
</head>
<body>
<font color="red">Error: <%=exception.getMessage() %>
</font><br>

Hi There, error code is <%=response.getContentType() %><br>
Please go to <a href="/patients/getAll">home page</a>
</body>
</html>
