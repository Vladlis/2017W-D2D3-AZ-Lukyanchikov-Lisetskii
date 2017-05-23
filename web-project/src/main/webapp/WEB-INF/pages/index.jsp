<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Web-project</title>
</head>
<body>
    <h1><spring:message code="greeting"/></h1>
</body>
<br>
<a href="/?locale=ru">ru</a>
<a href="/?locale=en">en</a>
</html>
