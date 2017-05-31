<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User Home</title>
</head>
<body>
<form method="GET" action="/user/author">
    <label>Input author name:
        <input type="text" name="name">
    </label>
    <input type="submit" value="Submit"/>
</form>
<br>
<form method="GET" action="/user/book">
    <label>Input book name:
        <input type="text" name="name">
    </label>
    <input type="submit" value="Submit"/>
</form>
<br>
<a href="/logout">Logout</a>
</body>
</html>
