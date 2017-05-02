<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>User Home</title>
</head>
<body>
<form method="GET" action="/user/authors">
    <label>Input author name:
        <input type="text" name="name">
    </label>
    <input type="submit" value="Get"/>
</form>
<br>
<a href="/logout">Logout</a>
</body>
</html>
