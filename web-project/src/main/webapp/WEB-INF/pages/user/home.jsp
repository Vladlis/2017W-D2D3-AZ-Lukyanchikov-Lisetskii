<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User Home</title>
</head>
<body>
<form method="GET" action="/user/authors">
    <label>Input author name:
        <input type="text" name="name">
    </label>
</form>
<br>
<a href="/logout">Logout</a>
</body>
</html>
